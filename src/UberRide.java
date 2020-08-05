import java.io.IOException;
import java.util.Random;

public class UberRide extends Ride {

    //instance variables
    private double price;
    private Driver driver;
    private Passenger passenger;
    private double distance;


    public UberRide(final String startpoint, final String endpoint, final Passenger passenger) {
        super(endpoint, endpoint);
        this.driver = null;         
        this.passenger = passenger;
        this.distance = 0.0;
    }
    public double getDistance(){ return this.distance; }
    public double getCost(){ return this.price; }

    public Driver assignDriver(final String type) {
        /**
         * Read data from csv create car object using last 4 columns create driver
         * object using first 5 columns add driver to Driver[]
         */

        final Database DB = new Database();
        DB.getDriversArray();
        final Driver[] drivers = DB.getArrayByVehicleType(type);
        final Random ran = new Random();
        
        final int randomIndex = ran.nextInt(drivers.length - 1);
        this.driver = drivers[randomIndex];

        return drivers[randomIndex];
    }

    public void completePayment(){
        /**
         *Credit money to driver & Debit money from passenger
         */

        final double driverBalance = this.driver.getCash();
        this.driver.setCash(driverBalance + this.price);
        System.out.println("Adding R" + (int) this.price + " to driver account. Account bal: R" + this.driver.getCash());

        final double passengerBalance = this.passenger.getCash();
        this.passenger.setCash(passengerBalance - this.price);
        System.out.println(
                "Deducting R" + (int) this.price + " from passenger account. Account bal: R" + passenger.getCash());
    }

    public void calculateDistance(){

        try {
            this.distance = super.getDistance(this.startingPoint, this.endingPoint);
        
        }catch (final IOException ex) { System.out.println(ex.toString()); }

        this.distance /= 1000;
        System.out.println("The distance is: " + this.distance + " km");

    }

    public void calculateCost(){
        double cost = 0.0;        cost = this.distance * this.driver.getCar().getBaseRate();
        this.price = cost;
        System.out.println("The cost is: R" + (int) this.price);
    
    }
	public Driver getDriver() {
		return this.driver;
    }
}