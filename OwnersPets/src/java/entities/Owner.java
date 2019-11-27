package entities;

public class Owner {
    private long id;
    private String name;
    private String address;

    public Owner(long id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    public Owner(String name, String address){
        this.name = name;
        this.address = address;
    }

    public Owner(){
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
        public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}