package com.brandedhustler.PAYROLLSYSTEM.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAYE")
@NoArgsConstructor
@AllArgsConstructor
public class PAYE {

    @Id
    @Column(name = "PAYE_ID")
    private Integer payeID;

    @Column(name = "First_365")
    private Double first365;

    @Column(name = "Next_110")
    private Double next110;

    @Column(name = "Next_360")
    private Double next360;

    @Column(name = "Next_3000")
    private Double next3000;

    @Column(name = "Next_16395")
    private Double next16395;

    @Column(name = "Next20k")
    private Double next20k;

    public Integer getPayeID() {
        return payeID;
    }

    public void setPayeID(Integer payeID) {
        this.payeID = payeID;
    }

    public Double getFirst365() {
        return first365;
    }

    public void setFirst365(Double first365) {
        this.first365 = first365;
    }

    public Double getNext110() {
        return next110;
    }

    public void setNext110(Double next110) {
        this.next110 = next110;
    }

    public Double getNext360() {
        return next360;
    }

    public void setNext360(Double next360) {
        this.next360 = next360;
    }

    public Double getNext3000() {
        return next3000;
    }

    public void setNext3000(Double next3000) {
        this.next3000 = next3000;
    }

    public Double getNext16395() {
        return next16395;
    }

    public void setNext16395(Double next16395) {
        this.next16395 = next16395;
    }

    public Double getNext20k() {
        return next20k;
    }

    public void setNext20k(Double next20k) {
        this.next20k = next20k;
    }

    @Override
    public String toString() {
        return "PAYE{" +
                "payeID=" + payeID +
                ", first365=" + first365 +
                ", next110=" + next110 +
                ", next360=" + next360 +
                ", next3000=" + next3000 +
                ", next16395=" + next16395 +
                ", next20k=" + next20k +
                '}';
    }
}
