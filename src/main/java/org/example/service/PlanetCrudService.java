package org.example.service;


import org.example.Entity.Planet;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {


    public void create(Planet planet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Planet getByid(String id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }

    public List<Planet> listAll() {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Planet> planets = session.createQuery("from Planet", Planet.class).list();
        session.close();
        return planets;
    }

    public void update(String id, String name) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Planet updatePlanet = session.get(Planet.class, id);
            updatePlanet.setName(name);
            session.persist(updatePlanet);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deleteById(Integer id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Planet planet = session.get(Planet.class, id);
            transaction = session.beginTransaction();
            if (planet != null) {
                session.remove(planet);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
