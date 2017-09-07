package com.next.gallery.client.server;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by centos on 8/28/17.
 */
public class User {
    public  static Map<String, String> USERS = new HashMap<>();

    static {
        USERS.put("ng@aasys.com", "hello");
    }

    public  static boolean login(String  email, String password) {
        String pass = USERS.get(email);
        return pass != null && pass.equals(password);
    }

    public static boolean register(String  email, String password) {
        String pass = USERS.get(email);
        if (pass != null) {
            USERS.put(email, password);
            return true;
        } else {
            return  false;
        }
    }

}
