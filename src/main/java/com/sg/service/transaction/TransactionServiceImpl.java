package com.sg.service.transaction;

import com.sg.domain.transaction.Transaction;
import com.sg.domain.transaction.TransactionStatus;
import com.sg.domain.transaction.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import java.util.logging.Logger;

public class TransactionServiceImpl implements  TransactionService{
    private Logger log = Logger.getLogger(TransactionServiceImpl.class.getName());
    @Override
    public Transaction register(BigDecimal amount, TransactionType type, TransactionStatus status) {
        log.info("Creating new transaction of type : "+type);
        Transaction transaction = new Transaction();
        transaction.setId("transaction_"+ UUID.randomUUID().toString());
        transaction.setCreatedAt(Instant.now());
        transaction.setAmount(amount);
        transaction.setType(type);
        transaction.setStatus(status);
        log.info("Transaction created with id : "+transaction.getId());
        return transaction;
    }
}
