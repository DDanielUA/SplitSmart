package com.SplitSmart.Model;

import java.time.LocalDate;

public class ConnectorFactory
{
    public Connector getConnector(int connId, int receiptId, int personId, float subTotal)
    {
        Connector defaultConnector = new Connector();

        defaultConnector.setConnId(connId);
        defaultConnector.setReceiptId(receiptId);
        defaultConnector.setPersonId(personId);
        defaultConnector.setSubTotal(subTotal);
        defaultConnector.setIsPlayed(false);

        return defaultConnector;
    }
}
