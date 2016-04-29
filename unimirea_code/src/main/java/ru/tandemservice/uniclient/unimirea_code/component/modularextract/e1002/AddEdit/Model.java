package ru.tandemservice.uniclient.unimirea_code.component.modularextract.e1002.AddEdit;

import ru.tandemservice.movestudent.component.modularextract.CommonExtractModel;
import ru.tandemservice.movestudent.component.modularextract.abstractextract.CommonModularStudentExtractAddEdit.CommonModularStudentExtractAddEditModel;
import ru.tandemservice.uniclient.unimirea_code.entity.TestStuExtract;

/**
 * Created by ocean on 29.03.2016.
 */
public class Model extends CommonModularStudentExtractAddEditModel<TestStuExtract> {
    private CommonExtractModel _eduModel;

    public CommonExtractModel getEduModel()
    {
        return _eduModel;
    }

    public void setEduModel(CommonExtractModel eduModel)
    {
        _eduModel = eduModel;
    }
}
