package com.portfolio.repository;

import com.portfolio.entity.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountIdOrderByTransactionDateDesc(Long accountId);

    List<Transaction> findByAccountIdAndAssetIdOrderByTransactionDateDesc(
            Long accountId, Long assetId);
}