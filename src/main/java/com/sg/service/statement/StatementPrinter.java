package com.sg.service.statement;

import com.sg.domain.account.Account;

public interface StatementPrinter {
    void print(Account account);
}
