import java.util.*;

public class UberApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please Sign In");

        System.out.print("\nFirst Name: ");
        String name = input.nextLine();
        System.out.print("\nLast Name: ");
        String surname = input.nextLine();
        System.out.print("\nEmail Address: ");
        String email = input.nextLine();
        System.out.print("\nCellphone Number: ");
        String cellnum = input.nextLine();
        System.out.print("\nAmount to load on Account: ");
        int acc = input.nextInt();

        Passenger client = new Passenger(email,name,surname, cellnum, acc);
        
        input.nextLine();
        System.out.println("\n\n******Welcome to Uber App******\n");
        System.out.println("Please enter your Current location:");
        String startPoint = input.nextLine();
        System.out.println("Please enter your End location:");
        String endPoint = input.nextLine();    

        UberRide uberRide = new UberRide(startPoint, endPoint, client);
        
        System.out.println("Please enter your Uber Prefference: ");
        String type = input.nextLine();
        
        input.close();
        
        uberRide.assignDriver(type);

        System.out.println("\nCalculating cost...");
        uberRide.calculateCost();
        
        System.out.println("\nFinding you a driver...");
        System.out.println("Assigned driver: " + uberRide.getDriver().getName() + " " + uberRide.getDriver().getSurname());
        System.out.println("Assigned car: " + uberRide.getDriver().getCar());
        
        System.out.println("\nYour ride is complete. Processing payment...");
        uberRide.completePayment();        
    }
}