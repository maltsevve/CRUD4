package com.maltsevve.crud4.repository;

import com.maltsevve.crud4.model.Region;
import com.maltsevve.crud4.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JavaIORegionRepositoryImpl implements RegionRepository {
    public JavaIORegionRepositoryImpl() {

    }

    @Override
    public Region save(Region region) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(region);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        if (region.getId() != null) {
            return region;
        } else {
            List<Region> regions = getAll();
            return regions.stream().filter(r -> region.getName().equals(r.getName())).findFirst().orElse(null);
        }
    }

    @Override
    public Region update(Region region) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(region);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return region;
    }

    @Override
    public Region getById(Long aLong) {
        Region region = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            region = session.get(Region.class, aLong);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return region;
    }

    @Override
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            regions = session.createQuery("FROM Region").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return regions.stream().sorted(Comparator.comparing(Region::getId)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long aLong) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Region region = session.get(Region.class, aLong);
            session.delete(region);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
