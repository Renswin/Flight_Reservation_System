import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Ticket {
    private long PNR;
    private Flight flight;
    private Passenger passenger;
    private int seatNumber;
    protected double price;
    protected String status;

    public abstract void setPrice(double price);

    public Ticket(long PNR, Flight flight, Passenger passenger, int seatNumber) {
        this.PNR = PNR;
        this.flight = flight;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDepartureDateTime() {
        return flight.getDepartureDateTime();
    }


    public Duration getDurationOfJourney(LocalDateTime localDateTime, LocalDateTime localDateTime2) {
        return Duration.between(localDateTime, localDateTime2);
    }

    public void printDuration() {
        Duration duration = getDurationOfJourney(flight.getDepartureDateTime(), flight.getArrivalDateTime());
        System.out.println(duration.toMinutes());
    }

    public long getPNRNumber() {
        return PNR;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }
}
