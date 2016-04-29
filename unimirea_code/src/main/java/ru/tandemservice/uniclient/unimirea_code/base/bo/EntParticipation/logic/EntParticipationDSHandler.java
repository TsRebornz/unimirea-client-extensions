package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic;

import org.tandemframework.caf.command.io.DSInput;
import org.tandemframework.caf.command.io.DSOutput;
import org.tandemframework.caf.logic.ExecutionContext;
import org.tandemframework.caf.logic.datasource.output.DQLSelectOutputBuilder;
import org.tandemframework.caf.logic.handler.DefaultSearchDataSourceHandler;
import org.tandemframework.core.entity.OrderDirection;
import org.tandemframework.hibsupport.dql.DQLExpressions;
import org.tandemframework.hibsupport.dql.DQLSelectBuilder;
import org.tandemframework.shared.employeebase.base.entity.Employee;
import org.tandemframework.shared.employeebase.base.entity.OrgUnitTypePostRelation;
import ru.tandemservice.uni.util.FilterUtils;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.List.EntParticipationListUI;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;

import java.util.List;

/**
 * Created by ocean on 15.10.2015.
 */
public class EntParticipationDSHandler extends DefaultSearchDataSourceHandler
{
    public static final String TYPEUNIT = "entName";
    public static final String LAST_NAME = "lastName";
    public static final String FIRST_NAME = "firstName";
    public static final String MID_NAME = "midName";
    public static final Long POST_RELATION_ID = null;
    //public static final String PROP_POST_LIST = ""



    public EntParticipationDSHandler(String ownerId){
        super(ownerId);
    }

    //public DSOutput getPostRelationList

    protected DSOutput execute(DSInput input, ExecutionContext context) {
        String entTypeUnit = context.get(TYPEUNIT);

        String lastName = context.get(LAST_NAME);
        String firstName = context.get(FIRST_NAME);
        String midName = context.get(MID_NAME);
        List postList = context.get(EntParticipationListUI.PROP_POST_LIST);
        //List<String> employeePost = new List<String>();
        //OrgUnitTypePostRelation postRelation;



        //String post_relation = context.
        //Long


        DQLSelectBuilder dql = new DQLSelectBuilder().fromEntity(EntertainmentPrtcption.class, "e");
        dql.column(DQLExpressions.property("e"));

        FilterUtils.applySelectFilter(dql, "e", EntertainmentPrtcption.unit().titile().s() , entTypeUnit);
        //FilterUtils.applySelectFilter(dql, "e", EntertainmentPrtcption.unit().type().title() , entTypeUnit);

        FilterUtils.applySimpleLikeFilter(dql, "e", EntertainmentPrtcption.type().employee().person().identityCard().firstName() , firstName );
        FilterUtils.applySimpleLikeFilter(dql, "e", EntertainmentPrtcption.type().employee().person().identityCard().middleName() , midName  );
        FilterUtils.applySimpleLikeFilter(dql, "e", EntertainmentPrtcption.type().employee().person().identityCard().lastName() , lastName );

        //FilterUtils.applySimpleLikeFilter(dql,"e" , EntertainmentPrtcption.type().postRelation().id().s() , employee_post);
        if(null != postList && !postList.isEmpty()){
            dql.where(DQLExpressions.in(DQLExpressions.property("e", EntertainmentPrtcption.type().postRelation().id()),postList ));
        }


        //dql.order(DQLExpressions.property("e", input.getEntityOrder().getKeyString()), OrderDirection.valueOf(input.getEntityOrder().getDirection().name()));

        //DQLSelectBuilder ��������, ������ �������
        DSOutput output = DQLSelectOutputBuilder.get(input, dql, this.getSession()).pageable(true).build();


        return output;
    }
}
