package net.mofed.reportracking.app.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.mofed.reportracking.app.model.MasterTransaction;


@Repository


public interface MasterTransactionRepository extends JpaRepository<MasterTransaction, Integer>
{
	
	@Query("SELECT p FROM MasterTransaction p WHERE CONCAT(p.id, ' ', p.transactiondocumentid) LIKE %?1%")
	public List<MasterTransaction> findByDirectorate(String keyword);

	
      }
