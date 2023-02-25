package test.java.com.test.raposa;
//Assessment Test #2
public class TV {
    private String make;
    private String model;

    public TV(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public boolean equals(TV other) {
        return make.equals(other.make) && model.equals(other.model);
    }

    public int hashCode() {
        return make.length() * 10 + model.length();
    }
}