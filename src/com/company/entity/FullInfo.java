package com.company.entity;

public class FullInfo {
    private Batch batch;
    private Production production;
    private Factory factory;

    public FullInfo(Batch batch, Production production, Factory factory) {
        this.batch = batch;
        this.production = production;
        this.factory = factory;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }



    public String toLongString() {
        return "FullInfo{" +
                "batch=" + batch +
                ", production=" + production +
                ", factory=" + factory +
                '}';
    }
    @Override
    public String toString() {
        return "Factory{" +
                "id=" + factory.getId() +
                ", shortName='" + factory.getShortName() +
                '}'+
                "Batch{" +
                " batchNumber=" + batch.getBatchNumber() +
                ", batchValue=" + batch.getBatchValue() +
                '}'+
                "Production{" +
                ", name='" + production.getName()+
                ", createdAt=" + production.getCreatedAt() +
                '}';
    }
}
