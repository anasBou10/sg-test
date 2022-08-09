package com.sg.domain.services.statement;

import com.sg.domain.account.Account;

public class ConsoleStatementPrinter implements StatementPrinter {
    @Override
    public void print(Account account) {
        account.getTransactions().stream().forEach(System.out::println);
    }
}
