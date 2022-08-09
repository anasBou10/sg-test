package com.sg.domain.services.transaction;

import com.sg.domain.transaction.Transaction;
import com.sg.domain.transaction.TransactionStatus;
import com.sg.domain.transaction.TransactionType;

import java.math.BigDecimal;

public interface TransactionService {
    Transaction register(BigDecimal amount, TransactionType type, TransactionStatus status);
}
