package com.sg.domain.services.statement;

import com.sg.domain.account.Account;

public interface StatementPrinter {
    void print(Account account);
}
