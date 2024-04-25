package org.example.wallet.balance.controller.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.wallet.balance.dto.error.ErrorResponseDto;
import org.example.wallet.balance.exception.BusinessException;
import org.example.wallet.balance.exception.UserNotFoundException;
import org.example.wallet.balance.message.LocaleMessageResource;
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
@RequiredArgsConstructor
public class GeneralExceptionHandlerController {
    private final LocaleMessageResource messageResource;

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorResponseDto> handleServiceExceptions(BusinessException e) {
        log.warn("Process was not successful with message:{}", e.getMessage());
        ErrorResponseDto responseDto = ErrorResponseDto.builder()
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponseDto> handleUnhandledExceptions(Exception e) {
        log.error("Unhandled exception, ", e);
        ErrorResponseDto responseDto = ErrorResponseDto.builder()
                .message(messageResource.getMessage("general.unhandled.exception"))
                .build();
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
