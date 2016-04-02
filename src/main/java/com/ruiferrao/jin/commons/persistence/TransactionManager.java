package com.ruiferrao.jin.commons.persistence;

public interface TransactionManager {

    void begin();

    void commit();

    void rollback();

}
