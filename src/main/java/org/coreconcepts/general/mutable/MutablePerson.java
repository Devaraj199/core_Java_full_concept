package org.coreconcepts.general.mutable;

import java.util.List;

public class MutablePerson {
    private String name;
    private int age;
    private List<String> hobbies;
//    private Address address;

    public MutablePerson(String name, int age,List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
//        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    @Override
    public String toString() {
        return "MutablePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}
