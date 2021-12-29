public class Contact {
    String P_moblie;
    String P_email;

    Contact(String P_moblie,String passenger_email){
        this.P_moblie = P_moblie;
        this.P_email = passenger_email;

    }
    public String getPassenger_moblie() {
        return P_moblie;
    }

    public void setPassenger_moblie(String passenger_moblie) {
        this.P_moblie = passenger_moblie;
    }

    public String getPassenger_email() {
        return P_email;
    }

    public void setPassenger_email(String passenger_email) {
        this.P_email = passenger_email;
    }
    public  void print(){
        System.out.println("Moblie: "+P_moblie);
        System.out.println("Email:  "+P_email);
    }
}

