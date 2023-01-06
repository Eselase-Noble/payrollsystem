package com.brandedhustler.PAYROLLSYSTEM.models;

import com.brandedhustler.PAYROLLSYSTEM.models.Employee;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

/**
 * The PRSYSTEM is payroll management system
 * @author  BrandedHustler
 * @version 1.0
 * @since   2022-12-05
 */

@Table
@Entity
@NoArgsConstructor
public class Income {


    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Integer incomeID;


    @OneToOne
    @JoinColumn(name = "Employee_ID", referencedColumnName = "Employee_ID")
    private Employee employee;

    @Column(name = "BasicSalaryGHS")
    private Double getBasicSalaryGHS;

    @Column(name = "Rent_Allowance")
    private Double rentALlowance;

    @Column(name = "Transport_Allowance")
    private Double transportALlowance;

    @Column(name = "Other_Allowance")
    private Double otherAllowance;

    @Column(name = "SSNIT_13")
    private Double ssnit13;

    @Column(name = "Taxable_Income")
    private Double taxableIncome;

    @Column(name = "Net_Income")
    private Double netIncome;


    public Integer getIncomeID() {
        return incomeID;
    }

    public void setIncomeID(Integer incomeID) {
        this.incomeID = incomeID;
    }


    public Double getGetBasicSalaryGHS() {
        return getBasicSalaryGHS;
    }

    public void setGetBasicSalaryGHS(Double getBasicSalaryGHS) {
        this.getBasicSalaryGHS = getBasicSalaryGHS;
    }

    public Double getRentALlowance() {
        return rentALlowance;
    }

    public void setRentALlowance(Double rentALlowance) {
        this.rentALlowance = rentALlowance;
    }

    public Double getTransportALlowance() {
        return transportALlowance;
    }

    public void setTransportALlowance(Double transportALlowance) {
        this.transportALlowance = transportALlowance;
    }

    public Double getOtherAllowance() {
        return otherAllowance;
    }

    public void setOtherAllowance(Double otherAllowance) {
        this.otherAllowance = otherAllowance;
    }

    public Double getSsnit13() {
        return ssnit13;
    }

    public void setSsnit13(Double ssnit13) {
        this.ssnit13 = ssnit13;
    }

    public Double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(Double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public Double getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(Double netIncome) {
        this.netIncome = netIncome;
    }


    @Override
    public String toString() {
        return "Income{" +
                "incomeID=" + incomeID +
                ", employeeID=" + employee +
                ", getBasicSalaryGHS=" + getBasicSalaryGHS +
                ", rentALlowance=" + rentALlowance +
                ", transportALlowance=" + transportALlowance +
                ", otherAllowance=" + otherAllowance +
                ", ssnit13=" + ssnit13 +
                ", taxableIncome=" + taxableIncome +
                ", netIncome=" + netIncome +
                '}';
    }
}
