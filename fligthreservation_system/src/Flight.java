import java.time.LocalDateTime;

public class Flight {
    private String flight_Number;
    private String Airline_Name;
    private int capacity;
    private int noOfSeatsBooked;
    private String departure_Location;
    private String destinationLocation;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;

    public Flight(String flightNumber, String Airline_Name, String departure_Location, String destinationLocation,
                  LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, int capacity, int noOfSeatsBooked) {
        this.flight_Number = flightNumber;
        this.Airline_Name = Airline_Name;
        this.destinationLocation = destinationLocation;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.capacity = capacity;
        this.departure_Location= departure_Location;
        this.destinationLocation =  destinationLocation;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.noOfSeatsBooked = noOfSeatsBooked;


    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public String getAirlineName() {
        return Airline_Name;
    }

    public void setAirlineName(String Airline_Name) {
        this.Airline_Name = Airline_Name;
    }

    public String getFlightNumber() {
        return flight_Number;
    }

    public void setFlightNumber(String flightNumber) {
        this.flight_Number = flightNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setNoOfSeatsBooked(int noOfSeatsBooked) {
        this.noOfSeatsBooked = noOfSeatsBooked;
    }

    public int getNoOfSeatsBooked() {
        return noOfSeatsBooked;
    }

    public int getCurrentCapacity() {
        return capacity - noOfSeatsBooked;
    }

    public String getDepartureLocation() {
        return departure_Location;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }
}
