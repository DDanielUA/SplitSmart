package com.SplitSmart.Repository.Interface;

import java.util.List;

public interface IRepositoryBase<T>{
    List<T> GetAll();

    void Insert(T newEntity);

    void Remove(T givenEntity);
}
