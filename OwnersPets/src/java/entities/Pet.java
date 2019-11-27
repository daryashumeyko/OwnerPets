package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pet {
    private long id;
    private String name;
    private Date birthDate; 
    private String type;
    private long petOwnerId;
    
    public Pet(long id, String name, Date birthDate, String type, long petOwnerId){
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
        this.petOwnerId = petOwnerId;
    }
    
    public Pet(){
    }
    
    public Pet(String name, Date birthDate, String type, long petOwnerId){
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
        this.petOwnerId = petOwnerId;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.birthDate = simpleDateFormat.parse(birthDate);
        } catch (ParseException e) {
            System.out.println("Date is incorrect");
        }
     }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPetOwnerId() {
        return petOwnerId;
    }
    public void setPetOwnerId(long petOwnerId) {
        this.petOwnerId = petOwnerId;
    }
    
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", type='" + type + '\'' +
                ", petOwnerId='" + petOwnerId + '\'' +
                '}';
    }
}
