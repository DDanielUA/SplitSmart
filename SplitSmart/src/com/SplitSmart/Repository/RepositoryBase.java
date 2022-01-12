package com.SplitSmart.Repository;

import com.SplitSmart.Repository.Data.SplitSmartContext;
import com.SplitSmart.Repository.Interface.IRepositoryBase;

import java.util.ArrayList;

public abstract class RepositoryBase<T> implements IRepositoryBase<T> {

    protected SplitSmartContext ctx;

    private ArrayList<T> set;

    public RepositoryBase(SplitSmartContext givenCtx, String typeClass){
        ctx = givenCtx;

        // This is the closest I will get to the generic runtime class :/
        switch (typeClass){
            case "Person" -> set = (ArrayList<T>) ctx.PersonSet;
            case "Receipt" -> set = (ArrayList<T>) ctx.ReceiptSet;
            case "Connector" -> set = (ArrayList<T>) ctx.ConnectorSet;
        }
    }

    public abstract T GetOne(int id);

    @Override
    public ArrayList<T> GetAll() {
        return this.set;
    }

    @Override
    public void Insert(T newEntity) {
        this.set.add(newEntity);
        this.ctx.SaveSets();
    }

    /*
    [Obsolete]
    public abstract void Update(T modEntity);
     */

    @Override
    public void Remove(T givenEntity) {
        this.set.remove(givenEntity);
        this.ctx.SaveSets();
    }
}
