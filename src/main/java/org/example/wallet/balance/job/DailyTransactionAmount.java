package org.example.wallet.balance.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.wallet.balance.da.entity.WalletTransactionEntity;
import org.example.wallet.balance.da.repository.WalletTransRepository;
import org.example.wallet.balance.util.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DailyTransactionAmount {

    private final WalletTransRepository walletTransRepository;

    @Scheduled(cron = "${wallet.config.cron.daily-amount}")
    public void calculateDailyAmount() {
        LocalDate targetDay = DateUtil.getPreviousDate();
        List<WalletTransactionEntity> transactionEntities = getListOfTransactions(targetDay);
        Long sum = calculateSum(transactionEntities);
        log.info("Total amount at day {} is {}", targetDay, sum);
    }

    private List<WalletTransactionEntity> getListOfTransactions(LocalDate targetDay) {
        Long startTime = DateUtil.getStartTimestampOfDay(targetDay);
        Long endTime = DateUtil.getEndTimestampOfDay(startTime);
        return walletTransRepository.getTransactionsOfDay(startTime, endTime);
    }

    private Long calculateSum(List<WalletTransactionEntity> transactionEntities) {
        return transactionEntities.stream()
                .mapToLong(WalletTransactionEntity::getAmount)
                .sum();
    }
}
