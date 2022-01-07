package com.SplitSmart.Model;

import java.time.LocalDate;

public class ReceiptFactory
{
    public Receipt getReceipt(int recId, String recName, String description, float totalCost, boolean isEqualSplit, int payingPersonId)
    {
        Receipt todayReceipt = new Receipt();

        todayReceipt.setRecId(recId);
        todayReceipt.setRecName(recName);
        todayReceipt.setDescription(description);
        todayReceipt.setDate(LocalDate.now());
        todayReceipt.setTotalCost(totalCost);
        todayReceipt.setIsEqualSplit(isEqualSplit);
        todayReceipt.setPayingPersonId(payingPersonId);

        return todayReceipt;
    }
}
