package org.example.wallet.balance.dto.add;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class WalletAddBalanceResponseDto {
    @JsonProperty("reference_id")
    private Long referenceId;
}
