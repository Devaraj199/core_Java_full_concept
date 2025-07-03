package org.coreconcepts.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionApiExample {
    public static void main(String[] args) {
        try {

            Class c = Class.forName("org.coreconcepts.reflection.Emp");
            Class[] classes = c.getDeclaredClasses();
            for(Class class1 : classes) {
                System.out.println("class: "+class1);
                System.out.println("Name of class: "+class1.getName());
            }
            Constructor[] constructors = c.getDeclaredConstructors();
            for(Constructor constructor : constructors) {
                System.out.println("Name of Constructor : "+constructor);

                System.out.println("Count of constructor parameter : "+constructor.getParameterCount());

                Parameter[] parameters = constructor.getParameters();
                for(Parameter parameter : parameters) {
                    System.out.println("Constructor's parameter : "+parameter);
                }
                System.out.println();
            }
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }
}

class Emp{
    private int eid;
    private double esal;
    private String ename;
    Emp(){
    }
    public Emp(int eid, double esal, String ename){
        super();
        this.eid = eid;
        this.esal = esal;
        this.ename = ename;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public double getEsal() {
        return esal;
    }

    public void setEsal(double esal) {
        this.esal = esal;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
    class A {

    }
}
