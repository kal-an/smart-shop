package ru.kalan.smartshop.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.kalan.smartshop.order.OrderController;
import ru.kalan.smartshop.product.ProductController;
import ru.kalan.smartshop.user.UserController;

@Slf4j
@RestControllerAdvice(assignableTypes = {
        OrderController.class,
        ProductController.class,
        UserController.class})
public class ErrorHandler {

    @ExceptionHandler({NotFoundEntityException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(final NotFoundEntityException e) {
        log.error("Error {}", e.getMessage());
        return new ErrorResponse(e.getMessage());
    }
}
