package org.example.wallet.balance.dto.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
@Builder
@Getter
public class ErrorResponseDto {
    private String message;
}
