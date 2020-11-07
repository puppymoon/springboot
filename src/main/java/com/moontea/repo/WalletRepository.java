package com.moontea.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moontea.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
