package com.maltsevve.crud4.repository;

import com.maltsevve.crud4.model.Region;
import com.maltsevve.crud4.model.builders.region.RegionDirector;
import com.maltsevve.crud4.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JavaIORegionRepositoryImpl implements RegionRepository {
    private final static RegionDirector REGION_DIRECTOR = new RegionDirector();

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

        return region;
    }

    @Override
    public Region update(Region region) {
        List<Region> regions = getAll();

        return region;
    }

    @Override
    public Region getById(Long aLong) {
        Region region = null;

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

    }
}
