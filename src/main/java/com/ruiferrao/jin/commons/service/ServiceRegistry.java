package com.ruiferrao.jin.commons.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton containing instances of the service interface
 *
 * @see Service
 */
public class ServiceRegistry {

    private static ServiceRegistry registry;

    private Map<String, Service> registryMap = new HashMap<>();

    private ServiceRegistry() {
    }

    public static ServiceRegistry getServiceRegistry() {

        if (registry == null) {
            registry = new ServiceRegistry();
        }

        return registry;

    }

    /**
     * Obtain a reference to the service
     *
     * @param sname the name of the service to unregister
     * @return a reference to the service instance
     */
    public Service getService(String sname) {
        return registryMap.get(sname);
    }

    /**
     * Register a new service
     *
     * @param sname   the name of the service to register
     * @param service a reference to the service instance
     */
    public void registerService(String sname, Service service) {
        registryMap.put(sname, service);
    }

    /**
     * Unregister an existing service
     *
     * @param sname the name of the service to unregister
     */
    public void unregisterService(String sname) {
        registryMap.remove(sname);
    }

}
