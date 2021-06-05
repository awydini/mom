package net.aydini.mom.util;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 28, 2021
 */
public class TestCase
{

    private final Object when;
    private final Object then;

    public TestCase(Object when, Object then)
    {
        super();
        this.when = when;
        this.then = then;
    }

    public Object getWhen()
    {
        return when;
    }

    public Object getThen()
    {
        return then;
    }

}
