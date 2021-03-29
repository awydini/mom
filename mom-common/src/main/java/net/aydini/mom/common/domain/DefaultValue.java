package net.aydini.mom.common.domain;

import java.math.BigDecimal;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 29, 2021
 */
public enum DefaultValue {

      
    INTEGER(0), LONG(0L), DOUBLE(0D), FLOAT(0F), BIGDECIMAL(BigDecimal.ZERO), STRING(""), NULL(null);
    
    private Object value;

    private DefaultValue(Object value)
    {
        
        this.value = value;
    }

    public Object getValue()
    {
        
        return value;
    }
    
}
