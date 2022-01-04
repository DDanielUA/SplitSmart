package com.SplitSmart.Repository;

import com.SplitSmart.Model.Receipt;

public class ReceiptRepository extends RepositoryBase<Receipt> {

    public ReceiptRepository(SplitSmartContext givenCtx){
        super(givenCtx, "Receipt");
    }

    @Override
    public Receipt GetOne(int id) {
        for (int i = 0; i < this.ctx.ReceiptSet.size(); i++){
            Receipt tmp = this.ctx.ReceiptSet.get(i);
            if (tmp.getRecId() == id){
                return tmp;
            }
        }
        return null;
    }
}
