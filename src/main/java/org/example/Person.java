package org.example;

public class Person {
    private final String name;
    private final int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge(){
       return age;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name + " - " + age;
    }

}
