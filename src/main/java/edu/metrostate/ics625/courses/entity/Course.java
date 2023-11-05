
package edu.metrostate.ics625.courses.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author Tom Coffee
 */
@Entity
public class Course {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String number;
    private String title;
    private boolean offered;

    public Course() {
    }
    
    public Course(String number, String title, boolean offered) {
        this.number = number;
        this.title = title;
        this.offered = offered;
    }    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getOffered() {
        return offered;
    }

    public void setOffered(boolean offered) {
        this.offered = offered;
    }

    public String toString(){
        return String.format("%3d %-20s %-15s %-5s", id, number, title, offered);
    }
    
}
