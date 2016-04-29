package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.List;

import org.tandemframework.caf.ui.UIPresenter;
import org.tandemframework.caf.ui.datasource.IUIDataSource;
import org.tandemframework.core.component.Bind;
import org.tandemframework.core.component.State;
import org.tandemframework.hibsupport.DataAccessServices;
import org.tandemframework.shared.commonbase.base.util.CommonPostfixPermissionModelBase;
import org.tandemframework.shared.organization.base.entity.OrgUnit;
import org.tandemframework.shared.organization.base.util.OrgUnitSecModel;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic.EntParticipationDSHandler;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.AddEdit.EntParticipationAddEdit;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipationEmp.EntParticipationEmpManager;

/**
 * Created by ocean on 14.10.2015.
 */


@State({
        @Bind(key = EntParticipationListUI.ORG_UNIT_ID, binding = "orgUnit.id")
})
public class EntParticipationListUI extends UIPresenter
{
    public static final String ORG_UNIT_ID = "orgUnitId";
    public static final String ENT_UNIT = "entUnit";
    public static final String WITH_SUCCESS_DS = "withSuccessDS";
    public static final String ORG_UNIT_DS = "orgUnitDS";
    public static final String PROGRAM_SUBJECT_DS = "programSubjectDS";
    public static final String PROP_POST_LIST="postList";

    private OrgUnit _orgUnit = new OrgUnit();

    public OrgUnit getOrgUnit() {
        return _orgUnit;
    }

    public void setOrgUnit(OrgUnit _orgUnit) {
        this._orgUnit = _orgUnit;
    }

    private OrgUnitSecModel _secModel;
    public OrgUnitSecModel getSecModel(){ return _secModel; }


//    EntertainmentTypeUnit entTypeUnit = context.get(TYPEUNIT);
//
//    String lastName = context.get(LAST_NAME);
//    String firstName = context.get(FIRST_NAME);
//    String midName = context.get(MID_NAME);
//    LAST_NAME, FIRST_NAME, MID_NAME,TYPEUNIT

    @Override
    public void onComponentRefresh()
    {
        _orgUnit = DataAccessServices.dao().getNotNull(_orgUnit.getId());
        _secModel = new OrgUnitSecModel(_orgUnit);
    }

    @Override
    public void onBeforeDataSourceFetch(IUIDataSource dataSource)
    {
        if(dataSource.getName().equals(EntParticipationList.SELECT_ENT_DS)){
            super.onBeforeDataSourceFetch(dataSource);
            dataSource.putAll(getSettings().getAsMap(EntParticipationDSHandler.LAST_NAME, EntParticipationDSHandler.FIRST_NAME, EntParticipationDSHandler.MID_NAME, EntParticipationDSHandler.TYPEUNIT));
            dataSource.put(PROP_POST_LIST, _uiSettings.get(PROP_POST_LIST));
            dataSource.put("orgUnitId", _orgUnit.getId());
        }
    }

    public void onClickAddEntParticipation() throws Throwable {
        _uiActivation.asDialog(EntParticipationAddEdit.class).activate();
    }

    public void onEditEntityFromList()
    {
        _uiActivation.asRegion(EntParticipationAddEdit.class)
                .parameter("programId",getListenerParameterAsLong())
                .activate();
    }

    public void onDeleteEntityFromList()
    {
        EntParticipationEmpManager.instance()._entParticipationDAO().deleteEntParticipation(getListenerParameterAsLong());
    }

}
