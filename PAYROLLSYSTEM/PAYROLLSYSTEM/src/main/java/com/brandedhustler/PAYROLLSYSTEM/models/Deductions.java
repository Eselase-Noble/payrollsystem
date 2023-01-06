package com.brandedhustler.PAYROLLSYSTEM.models;

import jakarta.persistence.*;

public class Deductions {
    @Id
    @SequenceGenerator(
            name = "deduction_sequence",
            sequenceName = "deduction_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "deduction_sequence"
    )

    private Integer deductionID;

    @Column(name = "PAYE")
    private Double paye;

    @Column(name = "SSNIT")
    private Double ssnit5;

    @OneToOne(mappedBy = "", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Employee  employee;
}
