package net.aydini.mom.filler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.aydini.mom.common.annotation.MapedField;
import net.aydini.mom.common.exception.FillerException;
import net.aydini.mom.common.holder.MaperEntity;
import net.aydini.mom.common.service.maper.Maper;
import net.aydini.mom.common.service.maper.ObjectMaper;
import net.aydini.mom.util.reflection.ReflectionUtil;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Apr 7, 2021
 */
public class AnnotatedFieldFiller extends AbstractBaseFiller
{

    AnnotatedFieldFiller(ObjectMaper objectMapper)
    {
        super(objectMapper);
    }

    private final static Logger log = LoggerFactory.getLogger(AnnotatedFieldFiller.class);

    @Override
    protected <T> Optional<Object> getValueOfSourceField(MaperEntity<T> maperEntity, Field targetObjectField)
    {
        MapedField mapedField = targetObjectField.getAnnotation(MapedField.class);
        if (mapedField == null) throw new FillerException(targetObjectField.getName() + " is not annotated with @MapedField");

        Object sourceFieldValue = null;
        try
        {
            sourceFieldValue = getValueByFieldName(maperEntity, mapedField);
            sourceFieldValue = convertValue(mapedField, sourceFieldValue);
            Optional<Object> mapCustom = mapCustom(maperEntity, mapedField);
            if(mapCustom.isPresent())
                sourceFieldValue = mapCustom.get();
            if (sourceFieldValue == null) sourceFieldValue = mapedField.defaultValue().getValue();
            return Optional.ofNullable(sourceFieldValue);
        }
        catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e)
        {
            log.error("cant get value of {} from  ",
                    mapedField.fieldName().isEmpty() == false ? mapedField.fieldName() : targetObjectField.getName(),
                    maperEntity.getSource());
            throw new FillerException(e.getMessage(), e);
        }
    }

    private <T> Optional<Object> mapCustom(MaperEntity<T> maperentity, MapedField mapedField)
    {
        if (!mapedField.custom()) return Optional.empty();
        Optional<Maper<Object,Object>> maper = getMapedFieldMaper(mapedField);
        if (maper.isPresent()) return Optional.ofNullable(maper.get().map(maperentity.getSource()));
        return Optional.empty();
    }

    private boolean hasMaper(MapedField mapedField)
    {
        return mapedField.maper() != Maper.class;
    }

    @SuppressWarnings("unchecked")
    private Optional<Maper<Object,Object>> getMapedFieldMaper(MapedField mapedField)
    {
        if (!hasMaper(mapedField)) return Optional.empty();
        return Optional.of((Maper<Object,Object>)ReflectionUtil.instantiate(mapedField.maper()));
    }

    private Object convertValue(MapedField mapedField, Object value)
    {
        if (mapedField.custom() || value == null) return value;
        Optional<Maper<Object,Object>> maper = getMapedFieldMaper(mapedField);
        if (maper.isPresent()) return maper.get().map(value);
        return value;

    }

    private <T> Object getValueByFieldName(MaperEntity<T> maperEntity, MapedField mapedField)
            throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
    {
        if (mapedField.custom() || mapedField.fieldName() == null || mapedField.fieldName().isEmpty()) return null;
        Field sourceClassField = ReflectionUtil.findClassFieldByFieldName(maperEntity.getSource().getClass(), mapedField.fieldName());
        return ReflectionUtil.getFieldValueFromObject(sourceClassField, maperEntity.getSource());
    }

}
