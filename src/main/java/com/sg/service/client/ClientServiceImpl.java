package com.sg.service.client;

import com.sg.domain.client.Client;
import com.sg.service.account.AccountServiceImpl;

import java.time.Instant;
import java.util.UUID;
import java.util.logging.Logger;

public class ClientServiceImpl implements  ClientService{
    private Logger log = Logger.getLogger(ClientServiceImpl.class.getName());
    @Override
    public Client register(String name) {
        log.info("Creating new Client...");
        Client client=new Client();
        client.setId("client_"+UUID.randomUUID().toString());
        client.setName(name);
        client.setCreatedAt(Instant.now());
        client.setId("client_"+ UUID.randomUUID().toString());
        client.setAccount(new AccountServiceImpl().register(client.getId()));
        log.info("Client created with id : "+client.getId());
        return client;
    }
}
