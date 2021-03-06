package com.SplitSmart.Logic.DataAssembler;

import com.SplitSmart.Model.Person;
import com.SplitSmart.Repository.ConnectorRepository;
import com.SplitSmart.Repository.Data.SplitSmartContext;
import com.SplitSmart.Repository.PersonRepository;
import com.SplitSmart.Repository.ReceiptRepository;

public abstract class Assembler {
    protected final SplitSmartContext ctx;
    protected final PersonRepository perRepo;
    protected final ReceiptRepository recRepo;
    protected final ConnectorRepository connRepo;

    protected final Person user;

    protected Assembler(SplitSmartContext ctx, Person user) {
        this.ctx = ctx;
        this.perRepo = new PersonRepository(ctx);
        this.recRepo = new ReceiptRepository(ctx);
        this.connRepo = new ConnectorRepository(ctx);

        this.user = user;
    }
}
