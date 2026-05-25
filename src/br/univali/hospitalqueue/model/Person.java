package br.univali.hospitalqueue.model;

/**
 * Represents a generic person with a name.
 * Serving as the base class for clinical entities.
 * * @author Miguel Vanelli
 * @version 1.0
 */
public class Person {
    
    /** The name of the person. */
    private String name;

    /**
     * Constructs a new Person with the specified name.
     *
     * @param name the name of the person
     */
    public Person(String name){
        setName(name);
    }

    /**
     * Gets the person's name.
     *
     * @return the name of the person
     */
    public String getName(){
        return name;
    }

    /**
     * Sets the person's name.
     *
     * @param name the new name to set
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Returns a string representation of the person.
     *
     * @return a formatted string indicating the person's name
     */
    @Override
    public String toString(){
        return String.format("Person [name = %s]", getName());
    }
}