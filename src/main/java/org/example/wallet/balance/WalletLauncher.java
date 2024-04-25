package org.example.wallet.balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Atousa Mirhosseini
 * @since 24 Apr, 2024
 */

@EnableScheduling
@SpringBootApplication
public class WalletLauncher {
    public static void main(String[] args) {
        SpringApplication.run(WalletLauncher.class, args);
    }
}
