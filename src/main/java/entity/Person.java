package entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author H. Lackinger
 */
@XmlRootElement
public class Person {
    private int id;
    private String firstname;
    private String lastname;
    private String gender;
    private String email;
    private String country;
    private int age;
    private boolean registered;

    public Person() {
    }

    public Person(int id, String firstname, String lastname, String gender, String email, String country, int age, boolean registered) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
        this.country = country;
        this.age = age;
        this.registered = registered;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String writeable() {
        return this.id + ";" + this.firstname + ";" + this.lastname + ";" + this.gender + ";" + this.email + ";" + this.country + ";" + this.age + ";" + this.registered+"\n";
    }


}
