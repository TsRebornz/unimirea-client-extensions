package ru.tandemservice.uniclient.unimirea_code.component.listextract.e1000.ParagraphAddEdit;

import org.tandemframework.hibsupport.builder.MQBuilder;
import org.tandemframework.hibsupport.builder.expression.MQExpression;
import ru.tandemservice.movestudent.component.listextract.abstractextract.ListParagraphAddEdit.AbstractListParagraphAddEditDAO;
import ru.tandemservice.movestudent.utils.GroupSelectModel;
import ru.tandemservice.uni.entity.employee.Student;
import ru.tandemservice.uniclient.unimirea_code.entity.GiveBadgeCommonListExtract;

/**
 * Created by ocean on 26.04.2016.
 */
public class DAO extends AbstractListParagraphAddEditDAO<GiveBadgeCommonListExtract, Model > implements IDAO {
    @Override
    public void prepare(Model model){
        super.prepare(model);
        model.setGroupListModel(new GroupSelectModel(model, model.getParagraph().getOrder().getOrgUnit()));

        // заполняем поля по умолчанию
        if (model.getParagraphId() != null)
        {
            GiveBadgeCommonListExtract extract = model.getFirstExtract();
            model.setCourse(extract.getCourse());
            model.setGroup(extract.getGroup());
        }
    }



    @Override
    protected void patchListDataSource(MQBuilder builder, Model model) {
        builder.add(MQExpression.eq(STUDENT_ALIAS, Student.L_GROUP, model.getGroup()));
    }

    @Override
    protected GiveBadgeCommonListExtract createNewInstance(Model model) {
        return new GiveBadgeCommonListExtract();
    }

    @Override
    protected void fillExtract(GiveBadgeCommonListExtract extract, Student student, Model model) {
        extract.setCourse(model.getCourse());
        extract.setGroup(model.getGroup());
    }
}
