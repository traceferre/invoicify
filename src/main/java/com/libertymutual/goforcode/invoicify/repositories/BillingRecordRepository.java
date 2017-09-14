package com.libertymutual.goforcode.invoicify.repositories;

import org.springframework.stereotype.Repository;
import com.libertymutual.goforcode.invoicify.models.BillingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BillingRecordRepository extends JpaRepository<BillingRecord, Long> {
	
}
