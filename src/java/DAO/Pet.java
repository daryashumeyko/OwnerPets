package DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pet {
    private long id;
    private String name;
    private Date birthDate;
    private String type;
    private long petOwnerId;
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
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
}
