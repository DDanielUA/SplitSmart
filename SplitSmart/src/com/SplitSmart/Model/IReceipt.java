package com.SplitSmart.Model;

import java.time.LocalDate;

public interface IReceipt
{
    int getRecId();
    void setRecId(int recId);

    String getRecName();
    void setRecName(String recName);

    String getDescription();
    void setDescription(String description);

    LocalDate getDate();
    void setDate(LocalDate date);

    float getTotalCost();
    void setTotalCost(float totalCost);

    boolean getIsEqualSplit();
    void setIsEqualSplit(boolean isEqualSplit);

    int getPayingPersonId();
    void setPayingPersonId(int payingPersonId);
}
