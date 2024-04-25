package org.example.wallet.balance.dto.fetch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Atousa Mirhosseini
 * @since 24 Apr, 2024
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletBalanceResponseDto {
    private Long balance;
}
