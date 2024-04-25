package org.example.wallet.balance.unit;

import org.example.wallet.balance.da.entity.UserEntity;
import org.example.wallet.balance.da.entity.WalletEntity;
import org.example.wallet.balance.dto.fetch.WalletBalanceResponseDto;
import org.example.wallet.balance.exception.UserNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
public class GetBalanceUnitTest extends ParentUnitTest {

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
        WalletBalanceResponseDto responseDto = walletService.getWalletBalance(1l);
        Assertions.assertEquals(100l, responseDto.getBalance());
    }

    @Test
    public void testInvalidUser() {
        Assertions.assertNotNull(walletRepositoryMock);
        Mockito.when(walletRepositoryMock.findById(1l)).thenReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class, () -> walletService.getWalletBalance(1l));
    }
}
