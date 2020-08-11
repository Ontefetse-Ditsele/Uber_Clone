
/** Ontefetse Ditsele
 * 
 *  Driver a Subclass of Person
 * With new astributes of a Driver but still a Person. 
*/

public class Driver extends Person {

    //Instance variables
    Car car;
    String licenseID;
    
    /**constructor
     *
     * I am able to use another class type variable in another class.
     * I have  the ability to add one class object to other new class.
     */
    Driver(final Car car, final String licenseID, final String name, final String surname, final String phone_number,
            final int cash) {
        super(name, surname, phone_number, cash);
        this.car = car;
        this.licenseID = licenseID;
    }

    // Set Methods
    public void setCar(final Car car) {
        this.car = car;
    }

    public void setlicenseID(final String licenseID) {  this.licenseID = licenseID;  }

    public Car getCar(){ return this.car; }

    public String getlicenseID(){ return  this.licenseID; }

    public String toString(){ return super.toString() + this.car + "with LicenseID :"+ this.licenseID;
    }
}