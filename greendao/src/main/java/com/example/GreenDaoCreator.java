package com.example;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDaoCreator {
    private static int DBVersion = 1;
    private static String PackagePath = "greendao";

    public static void main(String[] args) throws IOException {
        try {

            Schema schema = new Schema(DBVersion, PackagePath);
            getSchema(schema);
            new DaoGenerator().generateAll(schema, "/home/ben/Workspace/Test/GreenDoaTest/app/src/main/java/com/example/ben/myapplication");

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

    private static void generateDaoFiles(Schema schema) {
        try {
            DaoGenerator generator = new DaoGenerator();
            //建立到指定目錄
            String homePath = System.getProperty("user.home");
            generator.generateAll(schema, "/home/ben/Workspace/Test/GreenDoaTest/app/src/main/java/com/example/ben/myapplication/greendao");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
