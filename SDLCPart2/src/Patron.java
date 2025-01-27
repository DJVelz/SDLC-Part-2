/*
 * Name: Dereck Velez Matias
 * Course: CEN 3024C-24204
 * Date: 01/26/2025
 * This class contains the basic information for each patron including their
 * ID, name, address, and owed fines
 */

public class Patron {
    int id;
    String name;
    String address;
    double overdueFine;

    //Constructor
    public Patron(int id, String name, String address, double overdueFine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.overdueFine = overdueFine;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public double getOverdueFine() {
        return overdueFine;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setOverdueFine(double overdueFine) {
        this.overdueFine = overdueFine;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Address: " + address + ", Overdue Fine: " + overdueFine;
    }
}
