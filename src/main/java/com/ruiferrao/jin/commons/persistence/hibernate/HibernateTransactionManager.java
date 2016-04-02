package com.ruiferrao.jin.commons.persistence.hibernate;

import com.ruiferrao.jin.commons.persistence.TransactionManager;

public class HibernateTransactionManager implements TransactionManager {

    @Override
    public void begin() {

        HibernateSessionManager.beginTransaction();

    }

    @Override
    public void commit() {

        HibernateSessionManager.commitTransaction();

    }

    @Override
    public void rollback() {

        HibernateSessionManager.rollbackTransaction();

    }
}
