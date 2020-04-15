package com.company.entity;

import java.sql.Timestamp;

public class Batch {
    private int id;
    private int batchNumber;
    private int batchValue;
    private Timestamp batchDate;
    private int productionId;
    private int factoryId;

    public Batch(int id, int batchNumber, int batchValue, Timestamp batchDate, int productionId, int factoryId) {
        this.id = id;
        this.batchNumber = batchNumber;
        this.batchValue = batchValue;
        this.batchDate = batchDate;
        this.productionId = productionId;
        this.factoryId = factoryId;
    }

    private Batch(int batchNumber, int batchValue, Timestamp batch_date, int productionId, int factoryId) {
        this.batchNumber = batchNumber;
        this.batchValue = batchValue;
        this.batchDate = batch_date;
        this.productionId = productionId;
        this.factoryId = factoryId;
    }

    public int getBatchValue() {
        return batchValue;
    }

    public void setBatchValue(int batchValue) {
        this.batchValue = batchValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Timestamp getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(Timestamp batch_date) {
        this.batchDate = batch_date;
    }

    public int getProductionId() {
        return productionId;
    }

    public void setProductionId(int productionId) {
        this.productionId = productionId;
    }

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public static Batch createItemForSaving(int batchNumber, int batchValue, Timestamp batch_date, int productionId, int factoryId) {
        return new Batch(batchNumber, batchValue, batch_date, productionId, factoryId);
    }

    @Override
    public String toString() {
        return "Batch{" +
                "id=" + id +
                ", batchNumber=" + batchNumber +
                ", batchValue=" + batchValue +
                ", batchDate=" + batchDate +
                ", productionId=" + productionId +
                ", factoryId=" + factoryId +
                '}';
    }
}
