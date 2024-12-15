package com.sphereex.ep.sqlparser.detector.spi;

import java.util.Collection;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

public class BaseSPILoader<T extends BaseSPI> {
    
    private BaseSPILoader() {
    }
    
    public static BaseSPILoader getInstance() {
        return new BaseSPILoader();
    }
    
    private final Map<Class<T>, T> REGISTERED_SERVICES = new ConcurrentHashMap<>();
    
    private BaseSPI loadDefaultService(final Collection<? extends BaseSPI> services) {
        return services.stream().filter(BaseSPI::isDefault).findFirst().orElse(null);
    }
    
//    public <T extends BaseSPI> T getService(final Class<T> serviceClass, String serviceName) {
//        T result = null;
//        if (REGISTERED_SERVICES.get(serviceClass).get(serviceName) != null) {
//            return REGISTERED_SERVICES.get(serviceClass).get(serviceName);
//        } else {
//             ServiceLoader<BaseSPI> serviceLoader = (ServiceLoader<BaseSPI>) ServiceLoader.load(serviceClass);
//            for (final BaseSPI service : serviceLoader) {
//                if (service.getType().equals(serviceName)) {
//                    result = (T)service;
//                }
//            }
//        }
//        if (result == null) {
//            throw new IllegalArgumentException("No service found for " + serviceClass.getName() + " with name: " + serviceName);
//        }
//        return result;
//    }
}
