package com.SplitSmart.Model;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Collection;
import java.util.Objects;

public class Receipt implements IReceipt
{
    public Receipt()
    {

    }

    private int RecId;
    private String RecName;
    private String Description;
    private LocalDate Date;
    private float TotalCost;
    private boolean IsEqualSplit; //true if split is equal
    private int PayingPersonId;

    public Receipt(int recId, String recName, LocalDate date, float totalCost, boolean isEqualSplit, int payingPersonId)
    {
        this.RecId = recId;
        this.RecName = recName;
        this.Date = date;
        this.TotalCost = totalCost;
        this.IsEqualSplit = isEqualSplit;
        this.PayingPersonId = payingPersonId;
    }



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

    @Override
    public String toString() {
        return "Here are the details of your receipt{" +
                "Id: " + RecId +
                ", Name: " + RecName + '\'' +
                ", Description: " + Description + '\'' +
                ", Date of purchase: " + Date +
                ", Total cost of purchase: " + TotalCost +
                ", Is it split equally between people: " + IsEqualSplit +
                ", Id of the person who payed for it:" + PayingPersonId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Receipt)) return false;
        Receipt receipt = (Receipt) o;
        return RecId == receipt.RecId && Float.compare(receipt.TotalCost, TotalCost) == 0 && IsEqualSplit == receipt.IsEqualSplit && PayingPersonId == receipt.PayingPersonId && RecName.equals(receipt.RecName) && Objects.equals(Description, receipt.Description) && Date.equals(receipt.Date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(RecId, RecName, Description, Date, TotalCost, IsEqualSplit, PayingPersonId);
    }

    /*
    public Receipt()
    {
        this.Connectors = new HashSet<Connector>();
        this.People = new HashSet<Person>();
    }


    public virtual ArrayList<Connector> Connectors;

    public virtual ArrayList<Person> People { get; }
    */
}
