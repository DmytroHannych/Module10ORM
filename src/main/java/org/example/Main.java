package org.example;

import org.example.Flyway.FlywayDatabaseInitService;
import org.example.service.ClientCrudService;

public class Main {
    public static void main(String[] args) {
        FlywayDatabaseInitService databaseInitService = new FlywayDatabaseInitService();
        databaseInitService.InitData();

        ClientCrudService clientCrudService = new ClientCrudService();
        clientCrudService.create("Piter");
    }
}