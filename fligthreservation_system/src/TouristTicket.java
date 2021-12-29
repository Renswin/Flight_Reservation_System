import java.util.Iterator;
import java.util.List;

public class TouristTicket extends Ticket {

    public static final int MAX_LOCATIONS = 5;

    private Adress hotelAddress;

    private List<String> T_LocationsList;

    public TouristTicket(long PNRNumber, Flight flight, Passenger passenger, int seatNumber, int price,
                         Adress hotelAddress, List<String> T_LocationsList) {
        super(PNRNumber, flight, passenger, seatNumber);
        setPrice(price);
        setStatus("Cancelled");
        this.hotelAddress = hotelAddress;
        this.T_LocationsList = T_LocationsList;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public Adress getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(Adress hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public List<String> getAllTouristLocations() {
        return T_LocationsList;
    }


    public void addLocation(String touristLocation) {
        if (T_LocationsList.size() < MAX_LOCATIONS) {
            T_LocationsList.add(touristLocation);
        }

        else {
            System.out.println("You cannot add more places");
        }
    }

    public void removeLocation(String touristLocation) {

        Iterator iterator = T_LocationsList.iterator();
        String a;

        while (iterator.hasNext()) {
            a = (String) iterator.next();
            if (a.equals(touristLocation)) {
                iterator.remove();
            }
        }
    }
}
