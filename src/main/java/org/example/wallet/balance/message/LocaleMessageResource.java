package org.example.wallet.balance.message;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author Atousa Mirhosseini
 * @since 24 Apr, 2024
 */
@RequiredArgsConstructor
@Component
public class LocaleMessageResource {
    private final MessageSource messageSource;
    private Locale locale = new Locale("fa");

    public String getMessage(String key) {
        return messageSource.getMessage(key, null, locale);
    }
}
