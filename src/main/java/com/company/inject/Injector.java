package com.company.inject;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    private static final Logger logger = Logger.getLogger(Injector.class);

    public void inject(Object object)
    {
        Class objectClass = object.getClass();
        Field[] objectFields = objectClass.getDeclaredFields();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        for (Field field : objectFields)
        {
            if (field.isAnnotationPresent(Injectable.class))
            {
                try {
                    field.setAccessible(true);
                    String targetClassName = properties.get(field.getType().getName()).toString();
                    Class targetClass = Class.forName(targetClassName);
                    field.set(object, targetClass.newInstance());
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }

            }
        }
    }
}
