package br.com.erichiroshi.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erichiroshi.picpay.entity.WalletType;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}