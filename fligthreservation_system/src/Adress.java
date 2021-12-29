public class Adress {
    public String Street;
    public String City;
    public String State;

    public Adress(String Street,String City,String State){
        this.Street = Street;
        this.City = City;
        this.State = State;

    }


    @Override
    public String toString() {
        return "Address : Street=" + Street + ", City=" + City + ", State=" + State + " ";
    }


}
