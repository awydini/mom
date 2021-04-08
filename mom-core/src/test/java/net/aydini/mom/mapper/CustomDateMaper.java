package net.aydini.mom.mapper;

import java.time.LocalDate;

import net.aydini.mom.common.service.maper.Maper;
import net.aydini.mom.model.UserDto;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Apr 7, 2021
 */
public class CustomDateMaper implements Maper<UserDto, LocalDate>
{

    @Override
    public LocalDate map(UserDto input)
    {
        if(input.getRegisterDate() == null)
            return null;
        return input.getRegisterDate().plusDays(5);
    }


}
