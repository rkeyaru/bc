package com.zoosite.test;

import java.util.List;

 
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ZooDao implements Dao<Zoo> {
  Session session = null;

  public ZooDao() {
    session = HibernateUtil.getInstance().openSession();
  }

  @Override
  public Zoo get(long id) {
    Zoo zoo = session.get(Zoo.class, id);
    return zoo;

  }

  @Override
  public List<Zoo> getAll() {

    List<Zoo> zooList = session.createNamedQuery("findZoo", Zoo.class).list();
    return zooList;

  }

  @Override
  public Boolean save(Zoo t) {

    Transaction tx = session.beginTransaction();
    session.persist(t);
    tx.commit();
    return true;

  }

  @Override
  public void update(Zoo t) {
    Transaction tx = session.beginTransaction();
    session.merge(t);
    tx.commit();

  }

  @Override
  public Zoo delete(int t) {
    return null;

  }

}
