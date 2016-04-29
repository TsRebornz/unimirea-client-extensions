package ru.tandemservice.uniclient.unimirea_code.entity.gen;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import ru.tandemservice.movestudent.entity.ListStudentExtract;
import ru.tandemservice.uni.entity.catalog.Course;
import ru.tandemservice.uni.entity.orgstruct.Group;
import ru.tandemservice.uniclient.unimirea_code.entity.GiveBadgeCommonListExtract;
import org.tandemframework.core.view.formatter.DebugEntityFormatter;
import org.tandemframework.core.meta.entity.IEntityMeta;
import org.tandemframework.core.runtime.EntityRuntime;
import org.tandemframework.core.entity.*;
import org.tandemframework.core.entity.dsl.*;
import org.tandemframework.core.bean.*;

/**
 * Проект приказа «О выдаче обычных значков»
 */
@SuppressWarnings({"all", "unchecked", "unused", "deprecation"})
public abstract class GiveBadgeCommonListExtractGen extends ListStudentExtract
{
    public static final IFastBean FAST_BEAN = new FastBean();

    public static final String ENTITY_CLASS = "ru.tandemservice.uniclient.unimirea_code.entity.GiveBadgeCommonListExtract";
    public static final String ENTITY_NAME = "giveBadgeCommonListExtract";
    public static final int VERSION_HASH = 677344562;
    private static IEntityMeta ENTITY_META;

    public static final String L_COURSE = "course";
    public static final String L_GROUP = "group";

    private Course _course;     // Курс
    private Group _group;     // Группа

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
     * @return Курс. Свойство не может быть null.
     */
    @NotNull
    public Course getCourse()
    {
        return _course;
    }

    /**
     * @param course Курс. Свойство не может быть null.
     */
    public void setCourse(Course course)
    {
        dirty(_course, course);
        _course = course;
    }

    /**
     * @return Группа. Свойство не может быть null.
     */
    @NotNull
    public Group getGroup()
    {
        return _group;
    }

    /**
     * @param group Группа. Свойство не может быть null.
     */
    public void setGroup(Group group)
    {
        dirty(_group, group);
        _group = group;
    }

    public void update(IEntity another)
    {
        update(another, true);
    }

    public void update(IEntity another, boolean withNaturalIdProperties)
    {
        super.update(another, withNaturalIdProperties);
        if (another instanceof GiveBadgeCommonListExtractGen)
        {
            setCourse(((GiveBadgeCommonListExtract)another).getCourse());
            setGroup(((GiveBadgeCommonListExtract)another).getGroup());
        }
    }

    @Override
    public IFastBean getFastBean()
    {
        return FAST_BEAN;
    }

    protected static class FastBean<T extends GiveBadgeCommonListExtractGen> extends ListStudentExtract.FastBean<T>    {
        public Class<T> getBeanClass()
        {
            return (Class<T>) GiveBadgeCommonListExtract.class;
        }

        public T newInstance()
        {
            return (T) new GiveBadgeCommonListExtract();
        }
        @Override
        public Object getPropertyValue(T obj, String propertyName)
        {
            switch(propertyName)
            {
                case "course":
                    return obj.getCourse();
                case "group":
                    return obj.getGroup();
            }
            return super.getPropertyValue(obj, propertyName);
        }

        @Override
        public void setPropertyValue(T obj, String propertyName, Object value)
        {
            switch(propertyName)
            {
                case "course":
                    obj.setCourse((Course) value);
                    return;
                case "group":
                    obj.setGroup((Group) value);
                    return;
            }
            super.setPropertyValue(obj, propertyName, value);
        }

        @Override
        public boolean isReadableProperty(String propertyName)
        {
            switch(propertyName)
            {
                case "course":
                        return true;
                case "group":
                        return true;
            }
            return super.isReadableProperty(propertyName);
        }

        @Override
        public boolean isWritableProperty(String propertyName)
        {
            switch(propertyName)
            {
                case "course":
                    return true;
                case "group":
                    return true;
            }
            return super.isWritableProperty(propertyName);
        }

        @Override
        public Class getPropertyType(String propertyName)
        {
            switch(propertyName)
            {
                case "course":
                    return Course.class;
                case "group":
                    return Group.class;
            }
            return super.getPropertyType(propertyName);
        }
    }
    private static final Path<GiveBadgeCommonListExtract> _dslPath = new Path<GiveBadgeCommonListExtract>();

    public static Path as(String alias)
    {
        return _dslPath.forAlias(alias, "GiveBadgeCommonListExtract");
    }
            

    /**
     * @return Курс. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.GiveBadgeCommonListExtract#getCourse()
     */
    public static Course.Path<Course> course()
    {
        return _dslPath.course();
    }

    /**
     * @return Группа. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.GiveBadgeCommonListExtract#getGroup()
     */
    public static Group.Path<Group> group()
    {
        return _dslPath.group();
    }

    public static class Path<E extends GiveBadgeCommonListExtract> extends ListStudentExtract.Path<E>
    {
        private Course.Path<Course> _course;
        private Group.Path<Group> _group;

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
     * @return Курс. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.GiveBadgeCommonListExtract#getCourse()
     */
        public Course.Path<Course> course()
        {
            if(_course == null )
                _course = new Course.Path<Course>(L_COURSE, this);
            return _course;
        }

    /**
     * @return Группа. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.GiveBadgeCommonListExtract#getGroup()
     */
        public Group.Path<Group> group()
        {
            if(_group == null )
                _group = new Group.Path<Group>(L_GROUP, this);
            return _group;
        }

        public Class getEntityClass()
        {
            return GiveBadgeCommonListExtract.class;
        }

        public String getEntityName()
        {
            return "giveBadgeCommonListExtract";
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
