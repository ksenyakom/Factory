package academy.belhard.entity;

public class Factory {
    private int id;
    private String fullName;
    private String shortName;
    private String city;
    private int workersAmount;

    public Factory(int id, String fullName, String shortName, String city, int workersAmount) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.city = city;
        this.workersAmount = workersAmount;
    }

    private Factory(String fullName, String shortName, String city, int workersAmount) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.city = city;
        this.workersAmount = workersAmount;
    }
     public static Factory createItemForSaving(String fullName, String shortName, String city, int workersAmount) {
        return new Factory( fullName, shortName, city, workersAmount);
     }

    public int getId() {
        return id;
    }



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getWorkersAmount() {
        return workersAmount;
    }

    public void setWorkersAmount(int workersAmount) {
        this.workersAmount = workersAmount;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", city='" + city + '\'' +
                ", workersAmount=" + workersAmount +
                '}';
    }
}
