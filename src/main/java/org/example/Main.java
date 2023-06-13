package org.example;

import org.example.Entity.Client;
import org.example.Entity.Planet;
import org.example.Flyway.FlywayDatabaseInitService;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;

public class Main {
    public static void main(String[] args) {
//        FlywayDatabaseInitService databaseInitService = new FlywayDatabaseInitService();
//        databaseInitService.initData();

        ClientCrudService clientCrudService = new ClientCrudService();
//        clientCrudService.create("Piter");
//        Client byid = clientCrudService.getByid(6L);
//        System.out.println("byid = " + byid);
//        System.out.println("clientCrudService.listAll() = " + clientCrudService.listAll());
//        clientCrudService.update(7l,"Opera");

    }
}