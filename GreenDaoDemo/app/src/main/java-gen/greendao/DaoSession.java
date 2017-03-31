package greendao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import greendao.student;

import greendao.studentDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig studentDaoConfig;

    private final studentDao studentDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        studentDaoConfig = daoConfigMap.get(studentDao.class).clone();
        studentDaoConfig.initIdentityScope(type);

        studentDao = new studentDao(studentDaoConfig, this);

        registerDao(student.class, studentDao);
    }
    
    public void clear() {
        studentDaoConfig.getIdentityScope().clear();
    }

    public studentDao getStudentDao() {
        return studentDao;
    }

}
