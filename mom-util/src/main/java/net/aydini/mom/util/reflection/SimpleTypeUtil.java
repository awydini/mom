package net.aydini.mom.util.reflection;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
public class SimpleTypeUtil
{

    private final List<Class<?>> SIMPLE_TYPE_LIST;

    private static SimpleTypeUtil instance;

    SimpleTypeUtil()
    {
        SIMPLE_TYPE_LIST = Arrays.asList(new Class[] { Byte.class, Short.class, Integer.class, Float.class, Double.class, Boolean.class,
                Long.class, BigDecimal.class, BigInteger.class, String.class, java.util.Date.class, java.sql.Date.class, LocalDate.class,
                LocalTime.class, Object.class });
    }

    private static SimpleTypeUtil getInstance()
    {

        if (instance == null) instance = new SimpleTypeUtil();
        return instance;
    }

    public static boolean isSimpleType(Class<?> clazz)
    {
        return getInstance().SIMPLE_TYPE_LIST.contains(clazz);
    }

}
