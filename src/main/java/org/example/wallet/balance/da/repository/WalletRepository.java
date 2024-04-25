package org.example.wallet.balance.da.repository;

import org.example.wallet.balance.da.entity.WalletEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Atousa Mirhosseini
 * @since 24 Apr, 2024
 */
@Repository
public interface WalletRepository extends CrudRepository<WalletEntity, Long> {
}
