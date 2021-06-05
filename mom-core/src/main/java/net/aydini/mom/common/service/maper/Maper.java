package net.aydini.mom.common.service.maper;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 29, 2021
 */
public interface Maper<I extends Object , O extends Object>
{

    /**  
     * 
     * @param input
     * @return
     */
    O map(I input);

}
