package com.example.timesrunningoutbackend;
import javax.persistence.*;

//@Entity
//@Table(name = "Words")
public class Word {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String value;

    public Word() {
    }

    public Word(int id, String value) {
        this.value = value;
        this.ID = id;//take this out when jpa added
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
