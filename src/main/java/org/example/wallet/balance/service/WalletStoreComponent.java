package org.example.wallet.balance.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.wallet.balance.da.entity.WalletEntity;
import org.example.wallet.balance.da.entity.WalletTransactionEntity;
import org.example.wallet.balance.da.repository.WalletRepository;
import org.example.wallet.balance.da.repository.WalletTransRepository;
import org.springframework.stereotype.Component;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
@RequiredArgsConstructor
@Component
public class WalletStoreComponent {
    private final WalletRepository walletRepository;
    private final WalletTransRepository transRepository;

    @Transactional
    public void save(WalletEntity wallet, WalletTransactionEntity walletTransaction) {
        walletRepository.save(wallet);
        transRepository.save(walletTransaction);
    }
}
