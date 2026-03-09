package com.portfolio.repository;

import com.portfolio.entity.Asset;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository
        extends JpaRepository<Asset, Long> {
    Optional<Asset> findByTicker(String ticker);
}