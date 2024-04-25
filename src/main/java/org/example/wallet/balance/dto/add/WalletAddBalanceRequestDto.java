package org.example.wallet.balance.dto.add;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
@Getter
@Builder
public class WalletAddBalanceRequestDto {
    private Integer amount;

    @JsonProperty("user_id")
    private Long userId;
}
