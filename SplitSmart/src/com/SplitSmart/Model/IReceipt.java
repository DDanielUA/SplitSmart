package com.SplitSmart.Model;

import java.time.LocalDate;

public interface IReceipt
{
    public int getRecId();

    public String getRecName();

    public String getDescription();

    public LocalDate getDate();

    public float getTotalCost();

    public boolean getIsEqualSplit();

    public int getPayingPersonId();
}
