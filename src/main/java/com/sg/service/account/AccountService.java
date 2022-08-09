package com.sg.service.account;

import com.sg.domain.account.Account;
import com.sg.domain.transaction.Transaction;

import java.math.BigDecimal;

public interface AccountService {

    Account register(String clientId);

    Transaction withdraw(Account account, BigDecimal amount);

    Transaction deposit(Account account, BigDecimal amount);

}
