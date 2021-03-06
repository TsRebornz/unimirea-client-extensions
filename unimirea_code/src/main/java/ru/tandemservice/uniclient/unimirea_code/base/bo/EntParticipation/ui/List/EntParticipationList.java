package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tandemframework.caf.logic.handler.IDefaultComboDataSourceHandler;
import org.tandemframework.caf.logic.handler.IDefaultSearchDataSourceHandler;
import org.tandemframework.caf.ui.config.BusinessComponentManager;
import org.tandemframework.caf.ui.config.datasource.ColumnListExtPoint;
import org.tandemframework.caf.ui.config.datasource.IColumnListExtPointBuilder;
import org.tandemframework.caf.ui.config.presenter.PresenterExtPoint;
import org.tandemframework.caf.ui.datasource.UIDataSourceConfig;
import org.tandemframework.caf.ui.datasource.select.SelectDSConfig;
import org.tandemframework.caf.ui.datasource.select.SelectDataSource;
import org.tandemframework.common.CommonDefines;
import org.tandemframework.core.component.PublisherActivator;
import org.tandemframework.core.entity.IEntity;
import org.tandemframework.core.util.ParametersMap;
import org.tandemframework.core.view.formatter.FormattedMessage;
import org.tandemframework.core.view.list.column.IPublisherLinkResolver;
import org.tandemframework.hibsupport.dql.DQLSelectBuilder;
import org.tandemframework.shared.commonbase.base.util.ui.EntityComboDataSourceHandler;
import org.tandemframework.shared.employeebase.base.entity.OrgUnitTypePostRelation;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic.EntParticipationDSHandler;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.View.EntParticipationView;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.View.EntParticipationViewUI;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;

/**
 * Created by ocean on 14.10.2015.


Source should be ISingleSelectModel or array or collection.
But source type is : org.tandemframework.core.view.list.source.DynamicListDataSource
*/
@Configuration
public class EntParticipationList extends BusinessComponentManager
{
    public static final String SELECT_ENT_DS = "selectEntDS";
    public static final String POST_RELATION_DS = "postDS";


    @Bean
    @Override
    public PresenterExtPoint presenterExtPoint()
    {
        //Регистрируем data source типа searchListDS c именем SELECT_ENT_DS
        return presenterExtPointBuilder().addDataSource(searchListDS(SELECT_ENT_DS, selectEntDS(), this.entParticipationDSHandler()))
                .addDataSource(this.postDataSourceConfig())
                .create();
    }

    @Bean
    public IDefaultSearchDataSourceHandler entParticipationDSHandler()
    {
        return new EntParticipationDSHandler(this.getName());
    }

    @Bean
    public UIDataSourceConfig postDataSourceConfig()
    {
        return SelectDSConfig.with(POST_RELATION_DS, this.getName()).dataSourceClass(SelectDataSource.class).handler(this.postDSHandler()).create();
    }

    @Bean
    public IDefaultComboDataSourceHandler postDSHandler()
    {
        return new EntityComboDataSourceHandler(getName(), OrgUnitTypePostRelation.class)
                .where(OrgUnitTypePostRelation.id(), "postList", true)
                .pageable(true);
    }

    @Bean
    public ColumnListExtPoint selectEntDS()
    {
        final String alias = "a";
        final DQLSelectBuilder entPart = new DQLSelectBuilder().fromEntity(EntertainmentPrtcption.class, alias);

        IColumnListExtPointBuilder columns = columnListExtPointBuilder(SELECT_ENT_DS);

        columns.addColumn(publisherColumn("title", EntertainmentPrtcption.P_FULL_ENTERTAINMENT_NAME).publisherLinkResolver(new IPublisherLinkResolver()
        {
            @Override

            public Object getParameters(IEntity entity)
            {
                EntertainmentPrtcption entPrtcption = (EntertainmentPrtcption) entity;
                return new ParametersMap().add(PublisherActivator.PUBLISHER_ID_KEY, entPrtcption != null ? entPrtcption.getId().toString() : null).add(EntParticipationViewUI.PUBLISHER_ID, entPrtcption.getId().toString());
            }

            @Override
            public String getComponentName(IEntity entity)
            {
                return EntParticipationView.class.getSimpleName();
            }
        }).permissionKey("ui:pageSettings.permissionEdit"));
        columns.addColumn(textColumn("employeePost", EntertainmentPrtcption.employee().person().identityCard().fullFio().s()).order());
        columns.addColumn(textColumn("overseer", (EntertainmentPrtcption.overseerAsString())));
        columns.addColumn(actionColumn(EDIT_COLUMN_NAME, CommonDefines.ICON_EDIT, EDIT_LISTENER).permissionKey("ui:pageSettings.permissionEdit").visible("ui:pageSettings.editDeleteColumnsIsVisible"));
        columns.addColumn(actionColumn(DELETE_COLUMN_NAME, CommonDefines.ICON_DELETE, DELETE_LISTENER,
                 FormattedMessage.with().template("selectEntDS.delete.alert")
                        .parameter(EntertainmentPrtcption.P_FULL_ENTERTAINMENT_NAME).create()

        ).permissionKey("ui:pageSettings.permissionDelete").visible("ui:pageSettings.editDeleteColumnsIsVisible")) ;
        return columns.create();
    }
}
