package com.SplitSmart.Application.MainScene.Model;

import com.SplitSmart.Model.Receipt;

public class NewReceiptResult {
    private final Receipt newReceipt;
    private final String participants;
    private final String participantsDist;

    public NewReceiptResult(Receipt receipt, String participants, String participantsDist){
        this.newReceipt = receipt;
        this.participants = participants;
        this.participantsDist = participantsDist;
    }

    public Receipt getReceipt(){
        return this.newReceipt;
    }

    public String getParticipants(){
        return this.participants;
    }

    public String getParticipantsShares(){
        return this.participantsDist;
    }
}
