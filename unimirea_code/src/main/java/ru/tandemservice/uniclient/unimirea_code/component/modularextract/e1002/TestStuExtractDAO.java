package ru.tandemservice.uniclient.unimirea_code.component.modularextract.e1002;

import ru.tandemservice.uni.dao.UniBaseDao;
import ru.tandemservice.uniclient.unimirea_code.entity.TestStuExtract;
import ru.tandemservice.unimove.dao.IExtractComponentDao;

import java.util.Map;

/**
 * Created by ocean on 29.03.2016.
 */
public class TestStuExtractDAO extends UniBaseDao implements IExtractComponentDao<TestStuExtract> {
    @Override
    public void doCommit(TestStuExtract testStuExtract, Map map) {
        String test = "Test";
    }
    @Override
    public void doRollback(TestStuExtract costsChangesStuExtract, Map map) {

    }
}
