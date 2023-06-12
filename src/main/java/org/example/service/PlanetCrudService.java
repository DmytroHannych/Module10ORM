package org.example.service;

import org.example.Entity.Client;
import org.example.Entity.Planet;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PlanetCrudService {


    public void create(Planet planet) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(planet);
        transaction.commit();
        session.close();
    }

    public Planet getByid(String id){
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }
    public List<Planet> listAll(){
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Planet> planets = session.createQuery("from Planet", Planet.class).list();
        session.close();
        return planets;
    }

    public void update(String id, String name){
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Planet updatePlanet = session.get(Planet.class, id);
        updatePlanet.setName(name);
        session.persist(updatePlanet);
        transaction.commit();
        session.close();
    }

    public void deleteById(String id){
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Query query = session.createQuery("delete from Planet where id= :id", Planet.class);
        query.setParameter("id", id);
        query.list();
        session.close();
    }
}
