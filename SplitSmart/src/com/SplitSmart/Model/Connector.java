package com.SplitSmart.Model;

public class Connector
{
    public int ConnId;
    public int ReceiptId;
    public int PersonId;
    public float SubTotal;
    public boolean IsPayed;



    public int getConnId() { return ConnId; }
    public void setConnId(int connId) { this.ConnId = connId; }

    public int getReceiptId() { return ReceiptId; }
    public void setReceiptId(int receiptId) { this.ReceiptId = receiptId; }

    public int getPersonId() { return PersonId; }
    public void setPersonId(int personId) { this.PersonId = personId; }

    public float getSubTotal() { return SubTotal; }
    public void setSubTotal(float subTotal) { this.SubTotal = subTotal; }

    public boolean getIsPlayed() { return IsPayed; }
    public void setIsPlayed(boolean isPlayed) { this.IsPayed = isPlayed; }
}
