package FoodDeliverySystem.data;


public class User {

    private int id;

    private String name;

    private final String email;

    private final String phoneNumber;

    private final Address address;

    User(int id, String name, String email, String phoneNumber, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }
}
