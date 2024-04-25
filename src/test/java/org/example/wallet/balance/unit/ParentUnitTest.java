package org.example.wallet.balance.unit;

import org.example.wallet.balance.da.repository.WalletRepository;
import org.example.wallet.balance.message.LocaleMessageResource;
import org.example.wallet.balance.service.WalletService;
import org.example.wallet.balance.service.WalletStoreComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
@EnableAutoConfiguration
@ExtendWith(MockitoExtension.class)
public class ParentUnitTest {
    @InjectMocks
    protected WalletService walletService;

    @Mock
    protected WalletRepository walletRepositoryMock;

    @Mock
    protected WalletStoreComponent walletStoreComponentMock;

    @BeforeEach
    public void setup() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        LocaleMessageResource messages = new LocaleMessageResource(messageSource);
        walletService = new WalletService(walletRepositoryMock, walletStoreComponentMock, messages);
        ReflectionTestUtils.setField(walletService, "minimumBalance", 0);
    }
}
