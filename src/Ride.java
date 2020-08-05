import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import com.google.gson.*;
/**
 * Abstract class
 * 
 * To allow the extention of different types of Rides
 */

 public abstract class Ride {

    //variables
    public final String startingPoint;
    protected final String endingPoint;

    public Ride(final String startingPoint, final String endingPoint) {
      this.startingPoint = startingPoint;
      this.endingPoint = endingPoint;
   }

   //Methods that have to @Override

   public abstract void calculateDistance();
   public abstract Driver assignDriver(final String type);
   public abstract void calculateCost();
   public abstract void completePayment();

   
   //Class Methods to assist all sub-ride Classes;
   
   protected static String retrieveDistanceAsString(final String jsonString) {
      final GsonBuilder builder = new GsonBuilder();
      builder.setPrettyPrinting();
      final Gson gson = builder.create();
      JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class); 
      JsonArray jsonArray = jsonObject.getAsJsonArray("rows");
         
      JsonElement je = null;
      Iterator<JsonElement> iterator = jsonArray.iterator();
       while(iterator.hasNext()) {
           je = iterator.next();
           jsonArray = je.getAsJsonObject().getAsJsonArray("elements");
       }
  
       iterator = jsonArray.iterator();
       while(iterator.hasNext()) {
           je = iterator.next();
           jsonObject = je.getAsJsonObject().get("distance").getAsJsonObject();
       }
  
       return jsonObject.get("value")+"";
        }

   protected double getDistance(final String startingPoint, final String endingPoint) throws IOException {
      final URL urlForGetRequest = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins="
              + startingPoint + ",SA&destinations=" + endingPoint
              + ",SA&departure_time=now&key=AIzaSyCs2UIPeA_ygj6aDL45ta9ZdJu3Mo1PIOs");
      String readLine = null;
      final HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
      conection.setRequestMethod("GET");
      final int responseCode = conection.getResponseCode();

      double distance = 0.0;
      if (responseCode == HttpURLConnection.HTTP_OK) {
          final BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
          final StringBuffer response = new StringBuffer();
          while ((readLine = in.readLine()) != null) {
              response.append(readLine);
          }
          in.close();
          final String distanceAsString = retrieveDistanceAsString(response.toString());
          distance = Double.parseDouble(distanceAsString);
      } else {
          System.out.println("GET NOT WORKED");
      }
      return distance;
  }
}