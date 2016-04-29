package ru.tandemservice.uniclient.unimirea_code.component.modularextract.e1002.AddEdit;

import org.tandemframework.shared.commonbase.base.bo.Declinable.logic.GrammaCase;
import ru.tandemservice.movestudent.component.modularextract.abstractextract.CommonModularStudentExtractAddEdit.CommonModularStudentExtractAddEditDAO;
import ru.tandemservice.uniclient.unimirea_code.entity.TestStuExtract;

/**
 * Created by ocean on 29.03.2016.
 */
public class DAO extends CommonModularStudentExtractAddEditDAO<TestStuExtract,Model> implements IDAO {

    @Override
    protected TestStuExtract createNewInstance()
    {
        return new TestStuExtract();
    }

    @Override
    protected GrammaCase getStudentTitleCase()
    {
        return GrammaCase.ACCUSATIVE;
    }

    @Override
    public void prepare(Model model)
    {

    }

}
