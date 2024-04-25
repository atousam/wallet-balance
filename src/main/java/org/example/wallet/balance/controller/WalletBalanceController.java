package org.example.wallet.balance.controller;

import lombok.RequiredArgsConstructor;
import org.example.wallet.balance.audit.ActionType;
import org.example.wallet.balance.audit.LogAction;
import org.example.wallet.balance.dto.add.WalletAddBalanceRequestDto;
import org.example.wallet.balance.dto.add.WalletAddBalanceResponseDto;
import org.example.wallet.balance.dto.fetch.WalletBalanceResponseDto;
import org.example.wallet.balance.service.WalletService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Atousa Mirhosseini
 * @since 24 Apr, 2024
 */
@RequiredArgsConstructor
@RequestMapping("/wallet/balance/v1")
@RestController
public class WalletBalanceController {
    private final WalletService walletService;

    @LogAction(action = ActionType.GET_BALANCE)
    @GetMapping
    public WalletBalanceResponseDto getBalance(@RequestParam(value = "user_id") Long userId) {
        return walletService.getWalletBalance(userId);
    }

    @LogAction(action = ActionType.CHANGE_BALANCE)
    @PutMapping
    public WalletAddBalanceResponseDto addBalance(@RequestBody WalletAddBalanceRequestDto requestDto) {
        return walletService.addBalance(requestDto);
    }
}
