package org.example.projektiweek3tehtava.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Employee_en")
public class EmployeeEn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String sukunimi;

    @Column(name = "email")
    private String email;

    public EmployeeEn(int id, String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.sukunimi = lastName;
        this.email = email;

    }

    public EmployeeEn() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

