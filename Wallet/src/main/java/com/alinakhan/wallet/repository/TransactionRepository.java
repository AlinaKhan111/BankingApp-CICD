package com.alinakhan.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alinakhan.wallet.model.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String>{

}
