package ru.tandemservice.uniclient.unimirea_code.base.ext.Employee.ui.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tandemframework.caf.ui.config.BusinessComponentExtensionManager;
import org.tandemframework.caf.ui.config.presenter.PresenterExtension;
import org.tandemframework.caf.ui.config.tab.TabPanelExtension;
import org.tandemframework.shared.employeebase.base.bo.Employee.ui.View.EmployeeView;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipationEmp.ui.List.EntParticipationEmpList;

/**
 * Created by ocean on 28.04.2016.
 */
@Configuration
public class EmployeeViewExt extends BusinessComponentExtensionManager {
    public static final String ADDON_NAME = "unimirea_code" + EmployeeViewExtUI.class.getSimpleName();
    public static final String ENT_PARTICIPATION_EMP_TAB = "entertainmentParticipationEmployeeTab";

    @Autowired
    private EmployeeView _empView;

    @Bean
    public PresenterExtension presenterExtension(){
        return presenterExtensionBuilder(_empView.presenterExtPoint())
                .addAddon(uiAddon(ADDON_NAME,EmployeeViewExtUI.class))
                .create();
    }

    @Bean
    public TabPanelExtension tabPanelExtension(){

        return tabPanelExtensionBuilder(_empView.employeePubTabPanelExtPoint())
                .addTab(componentTab(ENT_PARTICIPATION_EMP_TAB,EntParticipationEmpList.class )
                .parameters("mvel:['employeeId':presenter.employee.id]")
                .permissionKey("entertainmentEmpView"))
                .create();
    }

}
