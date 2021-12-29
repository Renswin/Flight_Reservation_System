import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {


        boolean isVal = false;
        Scanner sc = new Scanner(System.in);

        int opt = 0;
        Passenger P = null;

        Add_Flights();

        Add_Tickets();

        while (!isVal || opt == 3) {
            System.out.println("Your Welcome in Renswin Airline Booking Services ");
            System.out.println("1 : for logging in.. ");
            System.out.println("2: for new registration..");
            System.out.println("3: for exit..");

            opt = sc.nextInt();

            if (opt == 1) {
                System.out.println("Enter email ID");
                String emailID = sc.next();
                System.out.println("Enter password");
                String password = sc.next();
                isVal = Seats.validateUser(emailID, password);
                if (isVal)
                    System.out.println("Successfully logged in");
            } else if (opt == 2) {
                System.out.println("Enter passenger details: ");
                System.out.println(" Enter name, password, phoneNumber, emailId ");
                String name = sc.next();
                String password = sc.next();
                long phoneNumber = sc.nextLong();
                String emailId = sc.next();

                boolean exists = Seats.emailIDExists(emailId);
                if (exists) {
                    System.out.println("email id already exists ");
                    continue;
                }

                System.out.println("please enter your address-street,city,state");
                String street = sc.next();
                String city = sc.next();
                String state = sc.next();
                Adress address = new Adress(street, city, state);
                P = new Passenger(password, name, phoneNumber, emailId, address);
                Seats.registerPassenger(P);
                System.out.println("Your registration is succesfully done ...... proceed to login ");
            } else {
                System.exit(0);
            }
        }

        while (true) {
            System.out.println("1:  available flights ");
            System.out.println("2: Book flights ");
            System.out.println("3: available tickets... ");
            System.out.println("4:  passenger details..");
            System.out.println("5: Update contact and address details...");
            System.out.println("6:exit");

            opt = sc.nextInt();
            switch (opt) {

                case 1: {
                    Seats.printAvailableFlights();
                }

                case 2: {
                    System.out.println("enter serial number of the flight to be booked ");
                    int index = sc.nextInt();

                    System.out.println("Enter ticket type.. ");
                    System.out.println("1: RegularTicket \n  2:TouristTicket ");
                    String ticketType = sc.next();

                    Seats.bookSeat(index, P, ticketType);
                }

                case 3: {
                    List<Ticket> tickets = Seats.getAllTickets(P);
                    if (tickets != null) {
                        for (Ticket ticket : tickets) {
                            if (!ticket.getStatus().equals("Cancelled"))
                                System.out.println("PNR_number is : " + ticket.getPNRNumber());
                        }
                    } else {
                        System.out.println("tickets not available");
                    }

                    System.out.println();
                    System.out.println("1. print ticket details.. ");
                    System.out.println("2. Cancel a ticket..");
                    System.out.println("3. ticket  status ...");
                    System.out.println("4. Check duration of journey");
                    System.out.println("5. Get the services availed by passenger: ");
                    System.out.println("6. Update special services availed by passenger");
                    System.out.println("7. Update tourist locations");
                    System.out.println("8  .go back..");


                    double PNRNumber = 0;
                    int op = sc.nextInt();
                    switch (op) {
                        case 1: {
                            System.out.println("Enter PNR_number");
                            PNRNumber = sc.nextDouble();
                            Seats.printTicketDetails(P, PNRNumber);
                        }

                        case 2: {
                            System.out.println("Enter the ticket's PNR number to be cancelled");
                            PNRNumber = sc.nextDouble();
                            boolean status = Seats.CancelTicket(PNRNumber, P);
                            if (status)
                                System.out.println("Ticket with PNR number: " + PNRNumber + " successfully cancelled");
                            else
                                System.out.println("Ticket with PNR number: " + PNRNumber + " couldn't be cancelled");
                        }

                        case 3: {
                            System.out.println("Enter the ticket's PNR number to check the status");
                            PNRNumber = sc.nextDouble();
                            String status = Seats.checkStatus(PNRNumber, P);
                            System.out.println("Status is : " + status);
                        }

                        case 4: {
                            System.out.println("Enter PNR number");
                            PNRNumber = sc.nextDouble();
                            Seats.printDuration(PNRNumber, P);
                        }

                        case 5: {
                            System.out.println("Enter PNR number");
                            PNRNumber = sc.nextDouble();
                            Seats.printServices(PNRNumber, P);
                        }

                        case 6: {
                            System.out.println("Enter PNR number");
                            PNRNumber = sc.nextDouble();

                            System.out.println("1.add a service \n 2. update a service \n 3.delete a service?");
                            int op2 = sc.nextInt();
                            Seats.updateServices(op2, PNRNumber, P);
                        }

                        case 7: {
                            System.out.println("Enter PNR number");
                            PNRNumber = sc.nextDouble();

                            System.out.println("Do u want to 1.add a tourist location 2. remove tourist location?");
                            int op2 = sc.nextInt();
                            Seats.updateTouristLocation(op2, PNRNumber, P);
                        }
                    }
                }

                case 4: {
                    Seats.printPassengerDetails(P);
                }

                case 5: {
                    System.out.println("Do u want to update the address? true/false");
                    boolean input = sc.nextBoolean();
                    if (input) {
                        System.out.println("enter street,city, state");
                        String street = sc.next();
                        String city = sc.next();
                        String state = sc.next();
                        Adress address = new Adress(street, city, state);
                        P.updateAdress(address);
                    }

                    System.out.println("Do u want to update the contact details? true/false");
                    input = sc.nextBoolean();
                    if (input) {
                        System.out.println("Enter name, phone number, email ID");
                        String name = sc.next();
                        long phoneNumber = sc.nextLong();
                        String emailId = sc.next();
                        P.updateContact(name, phoneNumber, emailId);
                    }

                }

                default: {
                    System.exit(0);
                }
            }
        }
    }
    /**
     * Creating initial data i.e. flight objects for program execution
     */
    static void Add_Flights() {
        LocalDate departureDate = LocalDate.of(2021, 10, 20);
        LocalTime departureTime = LocalTime.of(10, 35);

        LocalDateTime departureDateTime = LocalDateTime.of(departureDate, departureTime);

        LocalDate arrivalDate = LocalDate.of(2021, 10, 20);
        LocalTime arrivalTime = LocalTime.of(19, 30);

        LocalDateTime arrivalDateTime = LocalDateTime.of(arrivalDate, arrivalTime);

        Flight flight1 = new Flight("1", "Renswin", "Mumbai", "Delhi", departureDateTime, arrivalDateTime, 100,
                0);

        departureDate = LocalDate.of(2021, 10, 21);
        departureTime = LocalTime.of(14, 30);

        departureDateTime = LocalDateTime.of(departureDate, departureTime);

        arrivalDate = LocalDate.of(2021, 10, 21);
        arrivalTime = LocalTime.of(16, 30);

        arrivalDateTime = LocalDateTime.of(arrivalDate, arrivalTime);
        Flight flight2 = new Flight("2", "San", "New Delhi", "Nagpur", departureDateTime, arrivalDateTime, 100,
                0);

        departureDate = LocalDate.of(2021, 8, 29);
        departureTime = LocalTime.of(14, 30);

        departureDateTime = LocalDateTime.of(departureDate, departureTime);

        arrivalDate = LocalDate.of(2021, 8, 29);
        arrivalTime = LocalTime.of(16, 30);

        arrivalDateTime = LocalDateTime.of(arrivalDate, arrivalTime);

        Flight flight3 = new Flight("3", "Indigo", "New Delhi", "Bangalore", departureDateTime, arrivalDateTime, 50, 0);

        departureDate = LocalDate.of(2021, 10, 27);
        departureTime = LocalTime.of(15, 30);

        departureDateTime = LocalDateTime.of(departureDate, departureTime);

        arrivalDate = LocalDate.of(2021, 10, 27);
        arrivalTime = LocalTime.of(17, 00);

        arrivalDateTime = LocalDateTime.of(arrivalDate, arrivalTime);
        Flight flight4 = new Flight("4", "Emerites", "Mumbai", "Dubai", departureDateTime, arrivalDateTime, 150,
                0);

        departureDate = LocalDate.of(2021, 12, 27);
        departureTime = LocalTime.of(5, 00);

        departureDateTime = LocalDateTime.of(departureDate, departureTime);

        arrivalDate = LocalDate.of(2021, 12, 27);
        arrivalTime = LocalTime.of(7, 00);

        Flight flight5 = new Flight("5", "Indianairway", "New Delhi", "LasVegas", departureDateTime, arrivalDateTime, 100, 0);

        List<Flight> flightsAva = new ArrayList<>();
        flightsAva.add(flight1);
        flightsAva.add(flight2);
        flightsAva.add(flight3);
        flightsAva.add(flight4);
        flightsAva.add(flight5);
        Seats.addFlights(flightsAva);

    }

    static void Add_Tickets() {
        //initializing Passenger- ticket 1
        Map<Passenger, List<Ticket>> map = new HashMap<>();
        List<Ticket> ticketListTourist = new ArrayList<>();
        Adress address1 = new Adress("gandhiward", "Ramtek", "Maharashtra");
        Passenger passenger1 = new Passenger("Renswin", "Renuka",9422 , "mahi@gmail.com", address1);

        Adress hotelAddress1 = new Adress("Rainbow", "Mumbai", "Maharashtra");

        Ticket t1 = new TouristTicket(1233, Seats.getAvailableFlights().get(1), passenger1, 25,
                2890, hotelAddress1, Arrays.asList("loc1", "loc2"));
        Ticket t2 = new RegularTicket(1333, Seats.getAvailableFlights().get(0), passenger1, 28,
                2560, Arrays.asList("service1", "service2"));
        ticketListTourist.add(t1);
        ticketListTourist.add(t2);
        map.put(passenger1, ticketListTourist);




        List<Ticket> ticketListRegular = new ArrayList<>();
        Adress address2 = new Adress("Ring road ", "Panvel", "Mumbai");
        Passenger passenger2 = new Passenger("ren123", "San", 2549, "San@gmail.com", address2);
        Ticket t3 = new TouristTicket(15, Seats.getAvailableFlights().get(1), passenger1, 2,
                1000, hotelAddress1, Arrays.asList("loc5", "loc2"));
        Ticket t4 = new RegularTicket(16, Seats.getAvailableFlights().get(0), passenger1, 2,
                20000, Arrays.asList("service3", "service2"));
        ticketListRegular.add(t3);
        ticketListRegular.add(t4);
        map.put(passenger2, ticketListRegular);
        Seats.addPassengerTicket(map);
    }

}
