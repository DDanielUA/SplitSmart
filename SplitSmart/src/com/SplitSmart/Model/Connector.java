package com.SplitSmart.Model;

import java.util.Objects;

public class Connector implements IConnector
{
    public Connector(int connId, int receiptId, int personId, float subTotal, boolean isPayed)
    {
        this.connId = connId;
        this.receiptId = receiptId;
        this.personId = personId;
        this.subTotal = subTotal;
        this.isPayed = isPayed;
    }

    private int connId;
    private int receiptId;
    private int personId;
    private float subTotal;
    private boolean isPayed;

    public int getConnId() { return connId; }
    public void setConnId(int connId) { this.connId = connId; }

    public int getReceiptId() { return receiptId; }
    public void setReceiptId(int receiptId) { this.receiptId = receiptId; }

    public int getPersonId() { return personId; }
    public void setPersonId(int personId) { this.personId = personId; }

    public float getSubTotal() { return subTotal; }
    public void setSubTotal(float subTotal) { this.subTotal = subTotal; }

    public boolean getIsPayed() { return isPayed; }
    public void setIsPayed(boolean isPayed) { this.isPayed = isPayed; }

    @Override
    public String toString() {
        return "This connection has{" +
                "Id number: " + connId +
                ", Id of the receipt: " + receiptId +
                ", Id of the person: " + personId +
                ", Subtotal of the receipt: " + subTotal +
                ", Is it already payed: " + isPayed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Connector)) return false;
        Connector connector = (Connector) o;
        return connId == connector.connId && receiptId == connector.receiptId && personId == connector.personId && Float.compare(connector.subTotal, subTotal) == 0 && isPayed == connector.isPayed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(connId, receiptId, personId, subTotal, isPayed);
    }
}
