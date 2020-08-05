public class Passenger extends Person {

    //Instance variables
    private String email;

    //Constructor
    public Passenger(final String email, final String name, final String surname, final String phone_number, final int cash) {
        super(name, surname, phone_number, cash);
        this.email = email;
    }
    // Methods
    public void setEmail(final String email) { this.email = email; }

    public String getEmail() { return this.email;  }

    public String toString(){ return super.toString() + " and with E-mail:" +this.email;  }    

}