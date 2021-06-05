package net.aydini.mom.mapper;

import net.aydini.mom.common.service.maper.Maper;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Apr 7, 2021
 */
public class PasswordMaper implements Maper<String, String>
{

    @Override
    public String map(String input)
    {
        if(input == null)
            return null;
        return "map"+input;
    }

}
