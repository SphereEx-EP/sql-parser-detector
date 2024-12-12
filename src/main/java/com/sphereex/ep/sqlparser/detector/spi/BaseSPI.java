package com.sphereex.ep.sqlparser.detector.spi;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public interface BaseSPI {
    
    /**
     * Initialize SPI.
     *
     * @param props properties to be initialized
     */
    default void init(final Properties props) {
    }
    
    /**
     * Get type.
     *
     * @return type
     */
    Object getType();
    
    /**
     * Get type aliases.
     *
     * @return type aliases
     */
    default Collection<Object> getTypeAliases() {
        return Collections.emptyList();
    }
    
    /**
     * Judge whether default service provider.
     *
     * @return is default service provider or not
     */
    default boolean isDefault() {
        return false;
    }
}
