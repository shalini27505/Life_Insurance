package application;

public class Patient {
	private int id;
    private String iname;
    private String name;
    private int age;
    private int year;
    private String number;
    private double payment;

    public Patient(int id, String iname, String name, int age, int year, String number, double payment) {
        this.id= id;
        this.iname = iname;
        this.name = name;
        this.age = age;
        this.year = year;
        this.number =  number;
        this.payment = payment;
       
    }
    public int getId() {
        return id;
    }

    public String getIname() {
        return iname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getYear() {
        return year;
    }

    public String getNumber() {
        return number;
    }

    public double getPayment() {
        return payment;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
}
