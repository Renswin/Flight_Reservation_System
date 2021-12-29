import java.util.List;

public class RegularTicket extends Ticket {

    private List<String> Services;

    public RegularTicket(long PNRNumber, Flight flight, Passenger passenger, int seatNumber, double price,
                         List<String> Services) {
        super(PNRNumber, flight, passenger, seatNumber);

        setPrice(price);
        setStatus("cancelled");
        this.Services = Services;

    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getServices() {
        return Services;
    }

    public void setServices(int index, String service) {
        Services.set(index, service);
    }

    public void addService(String service) {
        Services.add(service);
    }

    public void deleteService(String service) {
        Services.remove(service);
    }

}
