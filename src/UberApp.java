import java.util.Scanner;

public class UberApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please Sign In\n");

        System.out.print("First Name: ");
        String name = input.nextLine();
        System.out.print("Last Name: ");
        String surname = input.nextLine();
        System.out.print("Email Address: ");
        String email = input.nextLine();
        System.out.print("Cellphone Number: ");
        String cellnum = input.nextLine();
        System.out.print("Amount to load on Account: ");
        int acc = input.nextInt();

        //I have the ability to call created objects
        Passenger client = new Passenger(email,name,surname, cellnum, acc);
        
        input.nextLine();
        System.out.println("\n******Welcome to Uber App******\n");
        System.out.println("Please enter your Current location:");
        String startPoint = input.nextLine();
        System.out.println("Please enter your End location:");
        String endPoint = input.nextLine();    

        UberRide uberRide = new UberRide(startPoint, endPoint, client);
        

        //I have the ability to use System.out.println() to debug
        System.out.println("Please enter your Uber Prefference: ");
        String type = input.nextLine();
        
        input.close();
        uberRide.assignDriver(type);

        System.out.println("\nCalculating cost...");
        uberRide.calculateDistance();
        uberRide.calculateCost();
        
        System.out.println("\nFinding you a driver...");
        System.out.println("Assigned driver: " + uberRide.getDriver().getName() + " " + uberRide.getDriver().getSurname());
        System.out.println("Assigned car: " + uberRide.getDriver().getCar());
        
        System.out.println("\nYour ride is complete. Processing payment...");
        uberRide.completePayment();        
    }
}