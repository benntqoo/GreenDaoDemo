package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyDaoGenerator {
    private static int DBVersion = 1;
    private static String PackagePath = "greendao";

    public static void main(String[] args) {
        try {
            //数据库版本号与自动生成代码的包路径
            Schema schema = new Schema(DBVersion, PackagePath);
            getSchema(schema);
            // 最后我们将使用 DAOGenerator 类的 generateAll() 方法自动生成代码，此处你需要根据自己的情况更改输出目录（既之前创建的 java-gen)。
            // 其实，输出目录的路径可以在 build.gradle 中设置，有兴趣的朋友可以自行搜索，这里就不再详解。
            new DaoGenerator().generateAll(schema, "/home/ben/Workspace/Test/GreenDaoDemo/GreenDaoDemo/app/src/main/java-gen");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getSchema(Schema schema) {
        Entity student = schema.addEntity("student");
        student.addStringProperty("name").unique().notNull();
        student.addIntProperty("point").notNull();
        student.addStringProperty("kinds").notNull();
    }
}
