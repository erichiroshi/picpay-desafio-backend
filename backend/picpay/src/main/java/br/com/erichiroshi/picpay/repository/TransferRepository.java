package br.com.erichiroshi.picpay.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erichiroshi.picpay.entity.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}