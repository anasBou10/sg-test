package com.sg.service.account;

import com.sg.domain.account.Account;
import com.sg.domain.transaction.Transaction;
import com.sg.domain.transaction.TransactionStatus;
import com.sg.domain.transaction.TransactionType;
import com.sg.exception.InsufficientBalanceException;
import com.sg.exception.InvalidAmountException;
import com.sg.service.transaction.TransactionServiceImpl;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import java.util.logging.Logger;

public class AccountServiceImpl implements AccountService{

    private Logger log = Logger.getLogger(AccountServiceImpl.class.getName());

    @Override
    public Account register(String clientId) {
        log.info("Creating account for client with id : "+clientId);
        Account account = new Account();
        account.setId("account_"+ UUID.randomUUID().toString());
        account.setClientId(clientId);
        account.setBalance(BigDecimal.valueOf(0));
        account.setCreatedAt(Instant.now());
        log.info("Account created with id : "+account.getId());
        return  account;
    }

    @Override
    public Transaction withdraw(Account account, BigDecimal amount)  throws RuntimeException {
        if(amount.compareTo(BigDecimal.valueOf(0))!=1){
            throw new InvalidAmountException("Invalid amount !");
        }

        if (account.getBalance().compareTo(amount)==-1){
            throw new InsufficientBalanceException("Insufficient balance  !");
        }
        account.setBalance(account.getBalance().subtract(amount));
        Transaction transaction =new TransactionServiceImpl().register(amount, TransactionType.WITHDRAW, TransactionStatus.SUCCUSS);
        account.getTransactions().add(transaction);
        return transaction;

    }

    @Override
    public Transaction deposit(Account account, BigDecimal amount)  throws InvalidAmountException {
        if(amount.compareTo(BigDecimal.valueOf(0))!=1){
            throw new InvalidAmountException("Invalid amount !");
        }
        account.setBalance(account.getBalance().add(amount));
        Transaction transaction =new TransactionServiceImpl().register(amount, TransactionType.DEPOSIT, TransactionStatus.SUCCUSS);
        account.getTransactions().add(transaction);
        return transaction;
    }
}
