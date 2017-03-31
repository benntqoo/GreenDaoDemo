package com.example.ben.greendaodemo.Helper;

import android.content.Context;

import de.greenrobot.dao.async.AsyncSession;
import greendao.DaoMaster;
import greendao.DaoSession;
import greendao.studentDao;

/**
 * Created by ben on 2017/3/31.
 */

public class DBHelper {
    private static final String DB_NAME = "launcher.db";
    private static DBHelper INSTANCE = null;
    private DaoSession daoSession;
    private AsyncSession asyncSession;

    private DBHelper(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);

        DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());

        daoSession = daoMaster.newSession();
        asyncSession = daoSession.startAsyncSession();
    }

    public static DBHelper getInstance(Context context) {
        if (INSTANCE == null)
            INSTANCE = new DBHelper(context);
        return INSTANCE;
    }

    public studentDao getStudentDao() {
        return daoSession.getStudentDao();
    }
}
