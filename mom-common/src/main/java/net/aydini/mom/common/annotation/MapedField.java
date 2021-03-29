package net.aydini.mom.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.aydini.mom.common.domain.DefaultValue;
import net.aydini.mom.common.service.Maper;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 27, 2021
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface MapedField
{
    String fieldName() default "";
    
    boolean custom() default false;
    
    Class<? extends Maper> maper() default Maper.class;
    
    DefaultValue defaultValue() default DefaultValue.NULL;
}
