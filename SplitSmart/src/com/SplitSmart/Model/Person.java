package com.SplitSmart.Model;

import java.util.ArrayList;
import java.util.Objects;

public class Person implements IPerson
{
    public Person(){}

    public Person(int personId, String name, String phone, String email)
    {
        this.personId = personId;
        this.name = name;
        this.phone= phone;
        this.email = email;
    }

    private int personId;
    private String name;
    private String phone;
    private String email;

    public int getPersonId() { return personId; }
    public void setPersonId(int personId) { this.personId = personId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public ArrayList<Connector> Connections = new ArrayList<>();

    public void markAsUnknown(){
        this.personId = -1;
        this.name = "!Unknown!";
        this.email = "";
        this.phone = "";
    }

    @Override
    public String toString() {
        return "Information about this person:{" +
                "Id number: " + personId +
                ", Name: '" + name + '\'' +
                ", Phone number: " + phone + '\'' +
                ", Email: " + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return personId == person.personId && name.equals(person.name) && phone.equals(person.phone) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, name, phone, email);
    }
}
