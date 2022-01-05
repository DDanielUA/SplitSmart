package com.SplitSmart.Repository;

import com.SplitSmart.Model.Person;
import com.SplitSmart.Repository.Data.SplitSmartContext;

public class PersonRepository extends RepositoryBase<Person> {

    public PersonRepository(SplitSmartContext givenCtx){
        super(givenCtx, "Person");
    }

    @Override
    public Person GetOne(int id) {
        for (int i = 0; i < this.ctx.PersonSet.size(); i++){
            Person tmp = this.ctx.PersonSet.get(i);
            if (tmp.getPersonId() == id){
                return tmp;
            }
        }
        return null;
    }

    /*
    [Obsolete]
    @Override
    public void Update(Person modEntity) {
        if (modEntity != null){
            int index = -1;

            for (int i = 0; i < this.ctx.PersonSet.size(); i++){
                Person tmp = this.ctx.PersonSet.get(i);
                if (tmp.getPersonId() == modEntity.getPersonId()){
                    index = i;
                    break;
                }
            }
            if (index != -1){
                this.ctx.PersonSet.set(index, modEntity);
            }
        }
    }
     */
}
