package org.example.wallet.balance.exception;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
public class NotEnoughBalanceException extends BusinessException {
    public NotEnoughBalanceException(String message) {
        super(message);
    }
}
