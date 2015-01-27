package springapp.services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WA_MESSAGE")
public class Message {

    @Id
    @GeneratedValue
    Integer number;

    @Column
    String text;

    public Message() {
        super();
    }

    public Message(String text) {
        super();
        this.text = text;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}