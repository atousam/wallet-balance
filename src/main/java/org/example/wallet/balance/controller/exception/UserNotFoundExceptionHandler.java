package org.example.wallet.balance.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.example.wallet.balance.dto.error.ErrorResponseDto;
import org.example.wallet.balance.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
@Slf4j
@RestControllerAdvice
public class UserNotFoundExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleServiceExceptions(UserNotFoundException e) {
        log.warn("User not found:{}", e.getMessage());
        ErrorResponseDto responseDto = ErrorResponseDto.builder()
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }
}
