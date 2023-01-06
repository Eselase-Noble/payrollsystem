package com.brandedhustler.PAYROLLSYSTEM.repositories;

import com.brandedhustler.PAYROLLSYSTEM.models.PAYE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The PRSYSTEM is payroll management system
 * @author  BrandedHustler
 * @version 1.0
 * @since   2022-12-06
 */

@Repository
public interface PAYERepository extends JpaRepository<PAYE, Integer> {

}
