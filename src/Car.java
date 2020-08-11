/* Ontefetse Ditsele
 *
 * An instance of a Vehicle that will be used during the Uber Ride
 * 05 August 2020
 **/

 //I understand Polymorphism & I know how to use it
public class Car implements Vehicle {
 // { I understand how encapsulaton works how interface work.}
    
    //Instance variables
    private final String numberPlate;
    private final String color;
    private final String model;
    private final String type;
    private double base_rate;

    // Constructor
    public Car(final String numberPlate, final String color, final String model, final String type) {
        this.numberPlate = numberPlate;
        this.color = color;
        this.model = model;
        this.type = type;
        if(type.equals("XL")) { this.base_rate = 25.00; }
        else {
            this.base_rate = 10.00;}
    }

    //Methods
    public String getNumberPlate() { return this.numberPlate; }

    public double getBaseRate() { return this.base_rate;  }
    
    public String getColor() { return this.color;  }
    
    public String getModel() { return this.model;  }
    
    public String getVehicleType() { return this.type; }

    public String toString() {
        return this.color + "   "+ this.model + "Number plate:" + this.numberPlate; }
 }