package com.SplitSmart.Model;

import java.util.Objects;

public class Connector implements IConnector
{
    public Connector()
    {

    }

    private int ConnId;
    private int ReceiptId;
    private int PersonId;
    private float SubTotal;
    private boolean IsPayed;

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

    @Override
    public String toString() {
        return "This connection has{" +
                "Id number: " + ConnId +
                ", Id of the receipt: " + ReceiptId +
                ", Id of the person: " + PersonId +
                ", Subtotal of the receipt: " + SubTotal +
                ", Is it already payed: " + IsPayed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Connector)) return false;
        Connector connector = (Connector) o;
        return ConnId == connector.ConnId && ReceiptId == connector.ReceiptId && PersonId == connector.PersonId && Float.compare(connector.SubTotal, SubTotal) == 0 && IsPayed == connector.IsPayed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ConnId, ReceiptId, PersonId, SubTotal, IsPayed);
    }
}
