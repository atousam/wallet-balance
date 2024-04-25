package org.example.wallet.balance;

import org.example.wallet.balance.dto.add.WalletAddBalanceRequestDto;
import org.example.wallet.balance.dto.add.WalletAddBalanceResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
public class AddBalanceIntegrationTest extends ParentIntegrationTest {
    @Test
    public void success() {
        String url = "http://localhost:" + port + "/api/wallet/balance/v1";
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        WalletAddBalanceRequestDto requestDto = WalletAddBalanceRequestDto.builder()
                .userId(1l)
                .amount(10)
                .build();
        HttpEntity<WalletAddBalanceRequestDto> request = new HttpEntity<>(requestDto, headers);
        ResponseEntity<WalletAddBalanceResponseDto> response = restTemplate
                .exchange(url, HttpMethod.PUT, request, WalletAddBalanceResponseDto.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody().getReferenceId());
    }
}
