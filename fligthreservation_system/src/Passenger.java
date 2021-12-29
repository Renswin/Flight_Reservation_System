public class Passenger {

    private static int idCounter;
    private int id;
    private String password;
    private Adress address;
    private Contact C = new Contact();

    public Passenger(String password, String name, long phoneNumber, String emailId, Adress address) {
        this.password = password;
        this.address = address;
        this.C.name = name;
        this.C.phoneNumber = phoneNumber;
        this.C.emailId = emailId;

        this.id = idCounter;
        idCounter++;
    }

    public Adress getAddress() {
        return address;
    }

    public Contact getContact() {
        return C;
    }

    public void updateAdress(Adress address) {
        this.address = address;
    }

    public void updateContact(String name, long phoneNumber, String emailId) {
        this.C.name = name;
        this.C.phoneNumber = phoneNumber;
        this.C.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailID() {
        return C.emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public static int getPassengerCount() {
        return idCounter;
    }

    private static class Contact {
        private String name;
        private long phoneNumber;

        @Override
        public String toString() {
            return "Contact :name=" + name + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + " ";
        }

        private String emailId;
    }

}
