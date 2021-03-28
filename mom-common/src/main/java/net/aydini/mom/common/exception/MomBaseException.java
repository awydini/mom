package net.aydini.mom.common.exception;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 27, 2021
 */
public class MomBaseException extends RuntimeException
{
    /**
     * 
     */
    private static final long serialVersionUID = -4409618886903484580L;
    private String message;

    public MomBaseException(String message)
    {
        super(message);
    }

    public MomBaseException(String message, Throwable throwable)
    {
        super(message, throwable);
    }

    public MomBaseException(Throwable throwable)
    {
        super(throwable);
    }

    public String getMessage()
    {
        return message;
    }

}
