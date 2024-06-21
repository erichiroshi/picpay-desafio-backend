package br.com.erichiroshi.picpay.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import br.com.erichiroshi.picpay.controller.dto.TransferDTO;
import br.com.erichiroshi.picpay.entity.Transfer;
import br.com.erichiroshi.picpay.entity.Wallet;
import br.com.erichiroshi.picpay.repository.TransferRepository;
import br.com.erichiroshi.picpay.repository.WalletRepository;
import br.com.erichiroshi.picpay.service.exception.InsufficientBalanceException;
import br.com.erichiroshi.picpay.service.exception.TransferNotAllowedForWalletTypeException;
import br.com.erichiroshi.picpay.service.exception.TransferNotAuthorizedException;
import br.com.erichiroshi.picpay.service.exception.WalletNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;
    private final WalletRepository walletRepository;

    public TransferService(TransferRepository transferRepository,
                           AuthorizationService authorizationService,
                           NotificationService notificationService,
                           WalletRepository walletRepository) {
        this.transferRepository = transferRepository;
        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
        this.walletRepository = walletRepository;
    }

    @Transactional
    public Transfer transfer(TransferDTO transferDto) {

        Wallet sender = walletRepository.findById(transferDto.payer())
                .orElseThrow(() -> new WalletNotFoundException(transferDto.payer()));

        Wallet receiver = walletRepository.findById(transferDto.payee())
                .orElseThrow(() -> new WalletNotFoundException(transferDto.payee()));

        validateTransfer(transferDto, sender);

        sender.debit(transferDto.value());
        receiver.credit(transferDto.value());

        Transfer transfer = new Transfer(sender, receiver, transferDto.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);
        Transfer transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));

        return transferResult;
    }

    private void validateTransfer(TransferDTO transferDto, Wallet sender) {

        if (!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowedForWalletTypeException();
        }

        if (!sender.isBalancerEqualOrGreatherThan(transferDto.value())) {
            throw new InsufficientBalanceException();
		}

		if (!authorizationService.isAuthorized(transferDto)) {
			throw new TransferNotAuthorizedException();
		}

	}
}