package org.example.service;

import org.example.Entity.Client;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class ClientCrudService {

    public void create(String name) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client newClient = new Client();
            newClient.setName(name);
            session.persist(newClient);
            transaction.commit();

        }
    }

    public Client getByid(Long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Client client = session.get(Client.class, id);
            return client;
        }
    }

    public List<Client> listAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            List<Client> clients = session.createQuery("from Client", Client.class).list();
            return clients;
        }
    }

    public void update(Long id, String name) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client updateClient = session.get(Client.class, id);
            updateClient.setName(name);
            session.persist(updateClient);
            System.out.println("updateClient = " + updateClient);
            transaction.commit();

        }
    }

    public void deleteById(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Client client = session.get(Client.class, id);
            transaction = session.beginTransaction();
            if (client != null) {
                session.remove(client);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


}
