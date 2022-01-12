package com.SplitSmart.Model;

public interface IConnector
{
    int getConnId();
    void setConnId(int connId);

    int getReceiptId();
    void setReceiptId(int receiptId);

    int getPersonId();
    void setPersonId(int personId);

    float getSubTotal();
    void setSubTotal(float subTotal);

    boolean getIsPayed();
    void setIsPayed(boolean isPayed);
}
