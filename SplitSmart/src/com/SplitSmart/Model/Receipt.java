package com.SplitSmart.Model;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Collection;

public class Receipt
{
    /*
    public Receipt()
    {
        this.Connectors = new HashSet<Connector>();
        this.People = new HashSet<Person>();
    }

    
    public virtual ArrayList<Connector> Connectors;

    public virtual ArrayList<Person> People { get; }
    */

    public int RecId; //{ get; set; }
    public String RecName;
    public String Description;
    public LocalDate Date;
    public float TotalCost;
    public boolean IsEqualSplit; //true if split is equal
    public int PayingPersonId;

    public int getRecId() { return RecId; }
    public void setRecId(int id) { this.RecId = id; }

    public String getRecName() { return RecName; }
    public void setRecName(String recName) { this.RecName = recName; }

    public String getDescription() { return Description; }
    public void setDescription(String description) { this.Description = description; }

    public LocalDate getDate() { return  Date; }
    public void setDate(LocalDate date) { this.Date = date; }

    public float getTotalCost() { return TotalCost; }
    public void setTotalCost(float totalCost) { this.TotalCost = totalCost; }

    public boolean getIsEqualSplit() { return IsEqualSplit; }
    public void setIsEqualSplit(boolean isEqualSplit) { this.IsEqualSplit = isEqualSplit; }

    public int getPayingPersonId() { return  PayingPersonId; }
    public void setPayingPersonId(int payingPersonId) { this.PayingPersonId = payingPersonId; }





    /*
    public String getName() {
        return name;
    }

    public String getReservedFor() {
        return reservedFor;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void DeleteReserved(){
        this.reserved = false;
    }

    public void setReserved(String email) {
        this.reserved = true;
        this.reservedFor = email;
    }
     */

}
