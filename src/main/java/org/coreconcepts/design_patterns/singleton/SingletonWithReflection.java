package org.coreconcepts.design_patterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonWithReflection {
    public static void main(String[] args) throws Exception {
        User user = User.getInstance();
        User user1 = User.getInstance();
        System.out.println(user1 == user);

        Constructor<User> instance = User.class.getDeclaredConstructor();
        instance.setAccessible(true);
        User user2 = instance.newInstance();
        System.out.println(user1 == user2);

    }
}
class User {
    private static User user;
    private User() {
        if(user!=null){
            throw new RuntimeException("Cant create multiple instance of singleton");
        }
        System.out.println("Constructor being called");
    }

    public static User getInstance() {
       if(user == null){
           user = new User();
       }
        return user;
    }
}
