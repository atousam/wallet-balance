package org.example.wallet.balance;

import org.example.wallet.balance.dto.fetch.WalletBalanceResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
public class GetBalanceIntegrationTest extends ParentIntegrationTest {
    @Test
    public void success() {
        String url = "http://localhost:" + port + "/api/wallet/balance/v1";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("user_id", "1");
        WalletBalanceResponseDto response = restTemplate.getForObject(builder.toUriString(),
                        WalletBalanceResponseDto.class);
        Assertions.assertNotNull(response.getBalance());
    }
}
