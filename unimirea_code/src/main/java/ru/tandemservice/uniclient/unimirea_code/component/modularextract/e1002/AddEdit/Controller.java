package ru.tandemservice.uniclient.unimirea_code.component.modularextract.e1002.AddEdit;

import org.tandemframework.core.component.IBusinessComponent;
import ru.tandemservice.movestudent.component.modularextract.abstractextract.CommonModularStudentExtractAddEdit.CommonModularStudentExtractAddEditController;
import ru.tandemservice.movestudent.dao.MoveStudentDaoFacade;
import ru.tandemservice.uniclient.unimirea_code.entity.TestStuExtract;

/**
 * Created by ocean on 29.03.2016.
 */
public class Controller extends CommonModularStudentExtractAddEditController<TestStuExtract,IDAO, Model> {

    public void onChangeGroup(IBusinessComponent component)
    {
        MoveStudentDaoFacade.getCommonExtractUtil().handleGroupChange(getModel(component).getEduModel());
    }

}
