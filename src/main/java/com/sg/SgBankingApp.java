package com.sg;

import com.sg.domain.client.Client;
import com.sg.service.account.AccountServiceImpl;
import com.sg.service.client.ClientServiceImpl;
import com.sg.service.statement.ConsoleStatementPrinter;

import java.math.BigDecimal;


public class SgBankingApp {
    public static void main(String[] args)  {
        ClientServiceImpl clientService = new ClientServiceImpl();
        AccountServiceImpl accountService=new AccountServiceImpl();
        ConsoleStatementPrinter statementPrinter = new ConsoleStatementPrinter();

        Client client = clientService.register("Anas Bouchouha");
        System.out.println(client);

        accountService.deposit(client.getAccount(), BigDecimal.valueOf(2000));
        accountService.withdraw(client.getAccount(),BigDecimal.valueOf(500));
        accountService.withdraw(client.getAccount(),BigDecimal.valueOf(500));
        accountService.deposit(client.getAccount(),BigDecimal.valueOf(600));

        //accountService.withdraw(client.getAccount(),BigDecimal.valueOf(0));
        //accountService.withdraw(client.getAccount(),BigDecimal.valueOf(1000025));

        statementPrinter.print(client.getAccount());

        System.out.println(client.getAccount());

    }
}
