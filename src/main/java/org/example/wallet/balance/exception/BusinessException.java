package org.example.wallet.balance.exception;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
