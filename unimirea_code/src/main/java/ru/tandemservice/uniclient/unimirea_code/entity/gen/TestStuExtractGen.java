package ru.tandemservice.uniclient.unimirea_code.entity.gen;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import ru.tandemservice.movestudent.entity.CommonStuExtract;
import ru.tandemservice.uni.entity.catalog.CompensationType;
import ru.tandemservice.uniclient.unimirea_code.entity.TestStuExtract;
import org.tandemframework.core.view.formatter.DebugEntityFormatter;
import org.tandemframework.core.meta.entity.IEntityMeta;
import org.tandemframework.core.runtime.EntityRuntime;
import org.tandemframework.core.entity.*;
import org.tandemframework.core.entity.dsl.*;
import org.tandemframework.core.bean.*;

/**
 * Тестовый (тестовый)
 */
@SuppressWarnings({"all", "unchecked", "unused", "deprecation"})
public abstract class TestStuExtractGen extends CommonStuExtract
{
    public static final IFastBean FAST_BEAN = new FastBean();

    public static final String ENTITY_CLASS = "ru.tandemservice.uniclient.unimirea_code.entity.TestStuExtract";
    public static final String ENTITY_NAME = "testStuExtract";
    public static final int VERSION_HASH = 1578689907;
    private static IEntityMeta ENTITY_META;

    public static final String L_NEW_COMPENSATION_TYPE = "newCompensationType";

    private CompensationType _newCompensationType;     // Вид возмещения затрат

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
    public CompensationType getNewCompensationType()
    {
        return _newCompensationType;
    }

    /**
     * @param newCompensationType Вид возмещения затрат. Свойство не может быть null.
     */
    public void setNewCompensationType(CompensationType newCompensationType)
    {
        dirty(_newCompensationType, newCompensationType);
        _newCompensationType = newCompensationType;
    }

    public void update(IEntity another)
    {
        update(another, true);
    }

    public void update(IEntity another, boolean withNaturalIdProperties)
    {
        super.update(another, withNaturalIdProperties);
        if (another instanceof TestStuExtractGen)
        {
            setNewCompensationType(((TestStuExtract)another).getNewCompensationType());
        }
    }

    @Override
    public IFastBean getFastBean()
    {
        return FAST_BEAN;
    }

    protected static class FastBean<T extends TestStuExtractGen> extends CommonStuExtract.FastBean<T>    {
        public Class<T> getBeanClass()
        {
            return (Class<T>) TestStuExtract.class;
        }

        public T newInstance()
        {
            return (T) new TestStuExtract();
        }
        @Override
        public Object getPropertyValue(T obj, String propertyName)
        {
            switch(propertyName)
            {
                case "newCompensationType":
                    return obj.getNewCompensationType();
            }
            return super.getPropertyValue(obj, propertyName);
        }

        @Override
        public void setPropertyValue(T obj, String propertyName, Object value)
        {
            switch(propertyName)
            {
                case "newCompensationType":
                    obj.setNewCompensationType((CompensationType) value);
                    return;
            }
            super.setPropertyValue(obj, propertyName, value);
        }

        @Override
        public boolean isReadableProperty(String propertyName)
        {
            switch(propertyName)
            {
                case "newCompensationType":
                        return true;
            }
            return super.isReadableProperty(propertyName);
        }

        @Override
        public boolean isWritableProperty(String propertyName)
        {
            switch(propertyName)
            {
                case "newCompensationType":
                    return true;
            }
            return super.isWritableProperty(propertyName);
        }

        @Override
        public Class getPropertyType(String propertyName)
        {
            switch(propertyName)
            {
                case "newCompensationType":
                    return CompensationType.class;
            }
            return super.getPropertyType(propertyName);
        }
    }
    private static final Path<TestStuExtract> _dslPath = new Path<TestStuExtract>();

    public static Path as(String alias)
    {
        return _dslPath.forAlias(alias, "TestStuExtract");
    }
            

    /**
     * @return Вид возмещения затрат. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.TestStuExtract#getNewCompensationType()
     */
    public static CompensationType.Path<CompensationType> newCompensationType()
    {
        return _dslPath.newCompensationType();
    }

    public static class Path<E extends TestStuExtract> extends CommonStuExtract.Path<E>
    {
        private CompensationType.Path<CompensationType> _newCompensationType;

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
     * @see ru.tandemservice.uniclient.unimirea_code.entity.TestStuExtract#getNewCompensationType()
     */
        public CompensationType.Path<CompensationType> newCompensationType()
        {
            if(_newCompensationType == null )
                _newCompensationType = new CompensationType.Path<CompensationType>(L_NEW_COMPENSATION_TYPE, this);
            return _newCompensationType;
        }

        public Class getEntityClass()
        {
            return TestStuExtract.class;
        }

        public String getEntityName()
        {
            return "testStuExtract";
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
