package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.AddEdit;

import org.tandemframework.caf.ui.UIPresenter;
import org.tandemframework.core.component.Bind;
import org.tandemframework.core.component.Input;
import org.tandemframework.hibsupport.DataAccessServices;
import org.tandemframework.hibsupport.dql.DQLSelectBuilder;
import org.tandemframework.hibsupport.entity.EntityHolder;
import org.tandemframework.shared.commonbase.base.util.DQLFullCheckSelectModel;
import org.tandemframework.shared.employeebase.base.entity.EmployeePost;
import org.tandemframework.tapsupport.component.selection.ISelectModel;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.EntParticipationManager;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;

import static org.tandemframework.hibsupport.dql.DQLExpressions.property;

/**
 * Created by ocean on 05.11.2015.
 */

@Input({
        @Bind(key = "programId", binding = "programHolderId")
})
public class EntParticipationAddEditUI extends UIPresenter
{
    private Long _programHolderId;



    //private EntityHolder<EntertainmentPrtcption> programHolder = new EntityHolder<>();
    //private EntertainmentTypeUnit entTypeUnit;
    private EntertainmentPrtcption _entertainmentPrtcption;
    //private EmployeePost participant;
    //private boolean overseer;


    @Override
    public void onComponentRefresh()
    {
        if (null != _programHolderId)
            _entertainmentPrtcption = DataAccessServices.dao().get(this.getProgramHolderId());
        else
        _entertainmentPrtcption = new EntertainmentPrtcption();

        //_entertainmentPrtcption.getUnit()
    }

    public void onClickApply()
    {
        EntParticipationManager.instance()._entParticipationDAO().saveOrUpdateEntParticipation(_entertainmentPrtcption);
        deactivate();
    }

    private final ISelectModel entTypeUnitModel = new DQLFullCheckSelectModel(EntertainmentTypeUnit.titile())
    {
        @Override
        protected DQLSelectBuilder query(String alias, String filter)
        {
            DQLSelectBuilder dql = new DQLSelectBuilder().fromEntity(EntertainmentTypeUnit.class, alias);
            if (null != filter)
            {
                dql.where(
                        like(EntertainmentTypeUnit.titile().fromAlias(alias), filter)
                );
            }

            dql.order(property(EntertainmentTypeUnit.titile().fromAlias(alias)));
            return dql;
        }
    };



    private final ISelectModel participantModel = new DQLFullCheckSelectModel(EmployeePost.person().identityCard().fullFio())
    {
        @Override
        protected DQLSelectBuilder query(String alias, String filter)
        {
            DQLSelectBuilder dql = new DQLSelectBuilder().fromEntity(EmployeePost.class, alias);
            if (null != filter)
            {
                dql.where(
                        like(EmployeePost.person().identityCard().fullFio().fromAlias(alias), filter)
                );
            }

            dql.order(property(EmployeePost.person().identityCard().fullFio().fromAlias(alias)));
            return dql;
        }
    };

    //geter and seters

    public EntertainmentPrtcption getEntertainmentPrtcption()
    {
        return _entertainmentPrtcption;
    }

    public void setEntertainmentPrtcption(EntertainmentPrtcption entertainmentPrtcption)
    {
        _entertainmentPrtcption = entertainmentPrtcption;
    }

    public Long getProgramHolderId() {
        return _programHolderId;
    }

    public void setProgramHolderId(Long _programHolderId) {
        this._programHolderId = _programHolderId;
    }

    public ISelectModel getParticipantModel()
    {
        return participantModel;
    }

    // select models


    public ISelectModel getEntTypeUnitModel() {
        return entTypeUnitModel;
    }
}
