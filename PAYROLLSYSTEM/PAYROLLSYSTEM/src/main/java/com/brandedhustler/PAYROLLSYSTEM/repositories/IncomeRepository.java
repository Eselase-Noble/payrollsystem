package com.brandedhustler.PAYROLLSYSTEM.repositories;

import com.brandedhustler.PAYROLLSYSTEM.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The PRSYSTEM is payroll management system
 * @author  BrandedHustler
 * @version 1.0
 * @since   2022-12-05
 */

public interface IncomeRepository extends JpaRepository<Income, Integer> {


}
