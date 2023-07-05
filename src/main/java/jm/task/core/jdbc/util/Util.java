package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;


public class Util {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getConnection() {
        try {
            Properties properties = new Properties();

            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/kata1.1.4");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "root123");

            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            properties.put(Environment.HBM2DDL_AUTO, "");

            sessionFactory = new Configuration()
                    .setProperties(properties)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public static void closeFactory() {
        sessionFactory.close();
    }
}
