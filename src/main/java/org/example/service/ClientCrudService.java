package org.example.service;

import org.example.Entity.Client;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClientCrudService {

    public void create(String name) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Client newClient = new Client();
            newClient.setName(name);
            session.persist(newClient);
            transaction.commit();

        }
    }

    public Client getByid(Long id){
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Client client = session.get(Client.class, id);
            return client;
        }
    }
    public List<Client> listAll(){
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            List<Client> clients = session.createQuery("from Client", Client.class).list();
            return clients;
        }
    }

    public void update(Long id, String name){
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client updateClient = session.get(Client.class, id);
            updateClient.setName(name);
            session.persist(updateClient);
            System.out.println("updateClient = " + updateClient);
            transaction.commit();

        }
    }

            public int deleteById(Long id){
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            String queryString = "delete from Client c where c.id=:id";
            Query query = session.createQuery(queryString);
            query.setParameter("id",id);
            return query.executeUpdate();
        }
    }


}
