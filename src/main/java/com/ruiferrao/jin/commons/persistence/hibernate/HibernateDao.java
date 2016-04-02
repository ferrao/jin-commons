package com.ruiferrao.jin.commons.persistence.hibernate;

import com.ruiferrao.jin.commons.persistence.Dao;
import com.ruiferrao.jin.commons.persistence.TransactionException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;

import java.util.List;

public abstract class HibernateDao<T> implements Dao<T> {

    private Class<T> type;

    public HibernateDao(Class<T> type) {
        this.type = type;
    }

    /**
     * @see Dao#save(Object)
     */
    @Override
    public void save(T dao) {

        try {

            HibernateSessionManager.getSession().saveOrUpdate(dao);

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

    }

    /**
     * @see Dao#delete(Object)
     */
    @Override
    public void delete(T dao) {

        try {

            HibernateSessionManager.getSession().delete(dao);

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

    }

    /**
     * @see Dao#findOne(Query)
     */
    @SuppressWarnings("unchecked")
    @Override
    public T findOne(Query query) {

        try {

            return (T) query.uniqueResult();

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

    }

    /**
     * @see Dao#findMany(Query)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<T> findMany(Query query) {

        try {

            return (List<T>) query.list();

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {

        try {

            return HibernateSessionManager.getSession().createCriteria(type)
                    .list();

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

    }

    /**
     * @see Dao#count()
     */
    public long count() {

        try {

            return (Long) HibernateSessionManager.getSession().createCriteria(type)
                    .setProjection(Projections.rowCount())
                    .uniqueResult();

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

    }

}
