package br.univali.hospitalqueue.model;

public class Person {
    private String name;

    public Person(String name){
        setName(name);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("Person [name = %s]", getName());
    }
}