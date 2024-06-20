package br.com.erichiroshi.picpay.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.erichiroshi.picpay.controller.dto.CreateWalletDto;
import br.com.erichiroshi.picpay.entity.Wallet;
import br.com.erichiroshi.picpay.repository.WalletRepository;
import br.com.erichiroshi.picpay.service.exception.WalletDataAlreadyExistsException;

@Service
public class WalletService {

	private final WalletRepository walletRepository;

	public WalletService(WalletRepository walletRepository) {
		this.walletRepository = walletRepository;
	}

	public Wallet createWallet(CreateWalletDto dto) {

		Optional<Wallet> walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());

		if (walletDb.isPresent()) {
			throw new WalletDataAlreadyExistsException("CpfCnpj or Email already exists");
		}

		return walletRepository.save(dto.toWallet());
	}
}