/** 
 * Ontefetse Ditsele 
 * 
 * 05 August 2020
* To be used to extend any type of person from drivers & passengers
*/ 

public class Person {

    //Instance variables
    private String name;
    private String surname;
    private String phone_number;
    private double cash;

    //Constructor
    public Person(final String name, final String surname, final String phone_number, final double cash) {
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
        this.cash = cash;
    }

    // Methods : Setters
    public void setName(final String name) {
        this.name = name;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(final String phone_number) {
        this.phone_number = phone_number;
    }

    public void setCash(final double cash) {
        this.cash = cash;
    }

    //Methods : Getters
    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }
    
    public String getPhoneNumber(){
        return this.phone_number;
    }
    
    public double getCash(){
        return this.cash;
    }

    public String toString() {
        return this.name + " " + this.surname;
    }
}