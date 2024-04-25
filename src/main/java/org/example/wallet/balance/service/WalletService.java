package org.example.wallet.balance.service;

import lombok.RequiredArgsConstructor;
import org.example.wallet.balance.da.entity.WalletEntity;
import org.example.wallet.balance.da.entity.WalletTransType;
import org.example.wallet.balance.da.entity.WalletTransactionEntity;
import org.example.wallet.balance.da.repository.WalletRepository;
import org.example.wallet.balance.dto.add.WalletAddBalanceRequestDto;
import org.example.wallet.balance.dto.add.WalletAddBalanceResponseDto;
import org.example.wallet.balance.dto.fetch.WalletBalanceResponseDto;
import org.example.wallet.balance.exception.NotEnoughBalanceException;
import org.example.wallet.balance.exception.UserNotFoundException;
import org.example.wallet.balance.message.LocaleMessageResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Atousa Mirhosseini
 * @since 24 Apr, 2024
 */
@RequiredArgsConstructor
@Service
public class WalletService {
    private final WalletRepository walletRepository;
    private final WalletStoreComponent walletStoreComponent;
    private final LocaleMessageResource messages;
    private final static AtomicLong refCounter = new AtomicLong(1000000l);

    @Value("${wallet.config.balance.min}")
    private Integer minimumBalance;

    public WalletBalanceResponseDto getWalletBalance(Long userId) {
        Long balance = findWalletOfUser(userId).getBalance();
        return WalletBalanceResponseDto.builder()
                .balance(balance)
                .build();
    }

    public WalletAddBalanceResponseDto addBalance(WalletAddBalanceRequestDto requestDto) {
        WalletEntity wallet = findWalletOfUser(requestDto.getUserId());
        Long newBalance = wallet.getBalance() + requestDto.getAmount();
        validateBalance(newBalance);
        wallet.setBalance(newBalance);
        WalletTransactionEntity transaction = new WalletTransactionEntity(findTransType(requestDto.getAmount()),
                Long.valueOf(requestDto.getAmount()), wallet.getUser());
        walletStoreComponent.save(wallet, transaction);
        return WalletAddBalanceResponseDto.builder()
                .referenceId(refCounter.getAndAdd(1))
                .build();
    }

    private void validateBalance(Long newBalance) {
        if (newBalance < minimumBalance)
            throw new NotEnoughBalanceException(messages.getMessage("not.enough.balance"));
    }

    private WalletEntity findWalletOfUser(Long userId) {
        return walletRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(messages.getMessage("user.not.found")));
    }

    private WalletTransType findTransType(Integer amount) {
        return amount > 0 ? WalletTransType.DEPOSIT : WalletTransType.WITHDRAW;
    }
}
