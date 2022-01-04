package com.SplitSmart.Repository;

import com.SplitSmart.Model.Connector;

public class ConnectorRepository extends RepositoryBase<Connector> {

    public ConnectorRepository(SplitSmartContext givenCtx){
        super(givenCtx, "Connector");
    }

    @Override
    public Connector GetOne(int id) {
        for (int i = 0; i < this.ctx.ConnectorSet.size(); i++){
            Connector tmp = this.ctx.ConnectorSet.get(i);
            if (tmp.getConnId() == id){
                return tmp;
            }
        }
        return null;
    }
}
