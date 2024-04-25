package org.example.wallet.balance.da.repository;

import org.example.wallet.balance.da.entity.WalletTransactionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
@Repository
public interface WalletTransRepository extends CrudRepository<WalletTransactionEntity, Long> {

    @Query("select t from WalletTransactionEntity t where t.creationDate >= :startTime and t.creationDate <= :endTime")
    List<WalletTransactionEntity> getTransactionsOfDay(@Param("startTime") Long startTime, @Param("endTime") Long endTime);
}
