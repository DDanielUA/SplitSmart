package com.SplitSmart.Model;

public interface IConnector
{
    public int getConnId();

    public int getReceiptId();

    public int getPersonId();

    public float getSubTotal();

    public boolean getIsPayed();
}
