package com.sphereex.ep.sqlparser.detector.spi;

import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

public class BaseSPILoader {
    
    private BaseSPILoader() {
    }
    
    public static BaseSPILoader getInstance() {
        return new BaseSPILoader();
    }
    
    private final Map<Class<? extends BaseSPI>, Map<String, ? extends BaseSPI>> REGISTERED_SERVICES = new ConcurrentHashMap<>();
    
    private <T extends BaseSPI> T loadDefaultService(final Class<T> serviceClass) {
        return getService(serviceClass, "default");
    }
    
    public <T extends BaseSPI> T getService(final Class<T> serviceClass, String serviceName) {
        if (serviceClass != null && serviceName == null) {
            return loadDefaultService(serviceClass);
        }
        T result = null;
        Map<String, T> serviceMap = (Map<String, T> )REGISTERED_SERVICES.get(serviceClass);
        if (serviceMap!= null && serviceMap.get(serviceName) != null) {
            return (T) REGISTERED_SERVICES.get(serviceClass).get(serviceName);
        } else {
            serviceMap = new ConcurrentHashMap<>(16);
            ServiceLoader<T> serviceLoader = ServiceLoader.load(serviceClass);
            for (T service : serviceLoader){
                if (service.getType() != null) {
                    serviceMap.put(service.getType().toString(), service);
                    if (serviceName.equalsIgnoreCase(service.getType().toString())) {
                        result = service;
                    }
                }
            }
            REGISTERED_SERVICES.put(serviceClass, serviceMap);
        }
        if (result == null) {
            throw new IllegalArgumentException("No service found for " + serviceClass.getName() + " with name: " + serviceName);
        }
        return result;
    }
}
