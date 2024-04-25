package org.example.wallet.balance.unit;

import org.example.wallet.balance.da.entity.UserEntity;
import org.example.wallet.balance.da.entity.WalletEntity;
import org.example.wallet.balance.dto.add.WalletAddBalanceRequestDto;
import org.example.wallet.balance.dto.add.WalletAddBalanceResponseDto;
import org.example.wallet.balance.exception.NotEnoughBalanceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
public class ChangeBalanceUnitTest extends ParentUnitTest {

    @Test
    public void testSuccessBalance() {
        Assertions.assertNotNull(walletRepositoryMock);
        WalletEntity wallet = new WalletEntity();
        wallet.setId(1l);
        wallet.setBalance(100l);
        UserEntity user = new UserEntity();
        user.setId(1l);
        user.setUsername("test1");
        user.setWallet(wallet);
        wallet.setUser(user);
        Mockito.when(walletRepositoryMock.findById(1l)).thenReturn(Optional.of(wallet));
        WalletAddBalanceRequestDto walletAddBalanceRequestDto = WalletAddBalanceRequestDto.builder()
                .amount(10)
                .userId(1l)
                .build();
        WalletAddBalanceResponseDto responseDto = walletService.addBalance(walletAddBalanceRequestDto);
        Assertions.assertNotNull(responseDto.getReferenceId());
    }

    @Test
    public void testNotEnoughBalance() {
        Assertions.assertNotNull(walletRepositoryMock);
        WalletEntity wallet = new WalletEntity();
        wallet.setBalance(0l);
        WalletAddBalanceRequestDto walletAddBalanceRequestDto = WalletAddBalanceRequestDto.builder()
                .amount(-10)
                .userId(1l)
                .build();
        Mockito.when(walletRepositoryMock.findById(1l)).thenReturn(Optional.of(wallet));
        Assertions.assertThrows(NotEnoughBalanceException.class, () -> walletService.addBalance(walletAddBalanceRequestDto));
    }
}
