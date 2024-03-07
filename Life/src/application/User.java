package application;

public class User {

    private int user_id;
    private String password;
    private String first;
    private String last;
    private String email;
    private String city;
    private String street;
    private String gender;

    // Constructor
    public User(int user_id, String password, String first, String last, String email, String city, String street, String gender) {
        this.user_id = user_id;
        this.password = password;
        this.first = first;
        this.last = last;
        this.email = email;
        this.city = city;
        this.street = street;
        this.gender = gender;
    }

    // Getters and Setters

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
