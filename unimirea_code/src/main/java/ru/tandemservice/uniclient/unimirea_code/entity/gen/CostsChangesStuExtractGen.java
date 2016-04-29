package ru.tandemservice.uniclient.unimirea_code.entity.gen;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import ru.tandemservice.movestudent.entity.CommonStuExtract;
import ru.tandemservice.uni.entity.catalog.CompensationType;
import ru.tandemservice.uniclient.unimirea_code.entity.CostsChangesStuExtract;
import org.tandemframework.core.view.formatter.DebugEntityFormatter;
import org.tandemframework.core.meta.entity.IEntityMeta;
import org.tandemframework.core.runtime.EntityRuntime;
import org.tandemframework.core.entity.*;
import org.tandemframework.core.entity.dsl.*;
import org.tandemframework.core.bean.*;

/**
 * Об изменении вида возмещения затрат (тестовый)
 */
@SuppressWarnings({"all", "unchecked", "unused", "deprecation"})
public abstract class CostsChangesStuExtractGen extends CommonStuExtract
{
    public static final IFastBean FAST_BEAN = new FastBean();

    public static final String ENTITY_CLASS = "ru.tandemservice.uniclient.unimirea_code.entity.CostsChangesStuExtract";
    public static final String ENTITY_NAME = "costsChangesStuExtract";
    public static final int VERSION_HASH = -1812358968;
    private static IEntityMeta ENTITY_META;

    public static final String L_COSTS_CHANGES_COMPENSATION_TYPE = "costsChangesCompensationType";

    private CompensationType _costsChangesCompensationType;     // Вид возмещения затрат

    @Override
    public String toString() {
        return DebugEntityFormatter.INSTANCE.format(this);
    }

    public IEntityMeta getEntityMeta()
    {
        if( ENTITY_META==null )
        {
            ENTITY_META = EntityRuntime.getMeta(ENTITY_NAME);
        }
        return ENTITY_META;
    }

    /**
     * @return Вид возмещения затрат. Свойство не может быть null.
     */
    @NotNull
    public CompensationType getCostsChangesCompensationType()
    {
        return _costsChangesCompensationType;
    }

    /**
     * @param costsChangesCompensationType Вид возмещения затрат. Свойство не может быть null.
     */
    public void setCostsChangesCompensationType(CompensationType costsChangesCompensationType)
    {
        dirty(_costsChangesCompensationType, costsChangesCompensationType);
        _costsChangesCompensationType = costsChangesCompensationType;
    }

    public void update(IEntity another)
    {
        update(another, true);
    }

    public void update(IEntity another, boolean withNaturalIdProperties)
    {
        super.update(another, withNaturalIdProperties);
        if (another instanceof CostsChangesStuExtractGen)
        {
            setCostsChangesCompensationType(((CostsChangesStuExtract)another).getCostsChangesCompensationType());
        }
    }

    @Override
    public IFastBean getFastBean()
    {
        return FAST_BEAN;
    }

    protected static class FastBean<T extends CostsChangesStuExtractGen> extends CommonStuExtract.FastBean<T>    {
        public Class<T> getBeanClass()
        {
            return (Class<T>) CostsChangesStuExtract.class;
        }

        public T newInstance()
        {
            return (T) new CostsChangesStuExtract();
        }
        @Override
        public Object getPropertyValue(T obj, String propertyName)
        {
            switch(propertyName)
            {
                case "costsChangesCompensationType":
                    return obj.getCostsChangesCompensationType();
            }
            return super.getPropertyValue(obj, propertyName);
        }

        @Override
        public void setPropertyValue(T obj, String propertyName, Object value)
        {
            switch(propertyName)
            {
                case "costsChangesCompensationType":
                    obj.setCostsChangesCompensationType((CompensationType) value);
                    return;
            }
            super.setPropertyValue(obj, propertyName, value);
        }

        @Override
        public boolean isReadableProperty(String propertyName)
        {
            switch(propertyName)
            {
                case "costsChangesCompensationType":
                        return true;
            }
            return super.isReadableProperty(propertyName);
        }

        @Override
        public boolean isWritableProperty(String propertyName)
        {
            switch(propertyName)
            {
                case "costsChangesCompensationType":
                    return true;
            }
            return super.isWritableProperty(propertyName);
        }

        @Override
        public Class getPropertyType(String propertyName)
        {
            switch(propertyName)
            {
                case "costsChangesCompensationType":
                    return CompensationType.class;
            }
            return super.getPropertyType(propertyName);
        }
    }
    private static final Path<CostsChangesStuExtract> _dslPath = new Path<CostsChangesStuExtract>();

    public static Path as(String alias)
    {
        return _dslPath.forAlias(alias, "CostsChangesStuExtract");
    }
            

    /**
     * @return Вид возмещения затрат. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.CostsChangesStuExtract#getCostsChangesCompensationType()
     */
    public static CompensationType.Path<CompensationType> costsChangesCompensationType()
    {
        return _dslPath.costsChangesCompensationType();
    }

    public static class Path<E extends CostsChangesStuExtract> extends CommonStuExtract.Path<E>
    {
        private CompensationType.Path<CompensationType> _costsChangesCompensationType;

        public Path()
        {
            super();
        }

        public Path(String path)
        {
            super(path);
        }

        public Path(String childEntityProperty, EntityPath path)
        {
            super(childEntityProperty, path);
        }

    /**
     * @return Вид возмещения затрат. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.CostsChangesStuExtract#getCostsChangesCompensationType()
     */
        public CompensationType.Path<CompensationType> costsChangesCompensationType()
        {
            if(_costsChangesCompensationType == null )
                _costsChangesCompensationType = new CompensationType.Path<CompensationType>(L_COSTS_CHANGES_COMPENSATION_TYPE, this);
            return _costsChangesCompensationType;
        }

        public Class getEntityClass()
        {
            return CostsChangesStuExtract.class;
        }

        public String getEntityName()
        {
            return "costsChangesStuExtract";
        }

        public Path as(String alias)
        {
            Path path = new Path(getPath());
            path.setAlias(alias);
            return path;
        }

        private Path forAlias(String alias, String root)
        {
            Path path = new Path();
            path.setAlias(alias, root);
            return path;
        }
    }
}
