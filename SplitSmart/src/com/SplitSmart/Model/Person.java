package com.SplitSmart.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Person implements IPerson
{
    public Person()
    {

    }

    private int PersonId;
    private String Name;
    private String Phone;
    private String Email;

    public int getPersonId() { return PersonId; }
    public void setPersonId(int personId) { this.PersonId = personId; }

    public String getName() { return Name; }
    public void setName(String name) { this.Name = name; }

    public String getPhone() { return Phone; }
    public void setPhone(String phone) { this.Phone = phone; }

    public String getEmail() { return  Email; }
    public void setEmail(String email) { this.Email = email; }

    public ArrayList<Connector> Connections = new ArrayList<>();

    @Override
    public String toString() {
        return "Information about this person:{" +
                "Id number: " + PersonId +
                ", Name: '" + Name + '\'' +
                ", Phone number: " + Phone + '\'' +
                ", Email: " + Email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return PersonId == person.PersonId && Name.equals(person.Name) && Phone.equals(person.Phone) && Objects.equals(Email, person.Email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PersonId, Name, Phone, Email);
    }
}
