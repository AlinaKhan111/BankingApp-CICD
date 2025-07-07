package com.alinakhan.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alinakhan.wallet.model.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Integer>{

}
