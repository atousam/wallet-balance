package org.example.wallet.balance.exception;

/**
 * @author Atousa Mirhosseini
 * @since 24 Apr, 2024
 */
public class UserNotFoundException extends BusinessException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
