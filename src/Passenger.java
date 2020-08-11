//I understand how inheritance works.
public class Passenger extends Person {

    //Instance variables
    private String email;

    //Constructor
    //I am able to create contructors and understand what a constructor does
    public Passenger(final String email, final String name, final String surname, final String phone_number, final int cash) {
        super(name, surname, phone_number, cash);
        this.email = email;
    }
    // Methods
    // I know how to create Setters and Getters
    public void setEmail(final String email) { this.email = email; }

    public String getEmail() { return this.email;  }

    //I know how to create a toString() function and understand what it does.
    public String toString(){ return super.toString() + " and with E-mail:" +this.email;  }    

}