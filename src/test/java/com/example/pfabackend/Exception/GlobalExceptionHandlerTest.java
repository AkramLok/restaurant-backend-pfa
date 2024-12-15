package com.example.pfabackend.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.pfabackend.payload.response.MessageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

class GlobalExceptionHandlerTest {
    @Test
    void testHandleGeneralException() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

        ResponseEntity<?> actualHandleGeneralExceptionResult = globalExceptionHandler
                .handleGeneralException(new Exception("foo"));

        Object body = actualHandleGeneralExceptionResult.getBody();
        assertTrue(body instanceof MessageResponse);
        HttpStatusCode statusCode = actualHandleGeneralExceptionResult.getStatusCode();
        assertTrue(statusCode instanceof HttpStatus);
        assertEquals("An error occurred: foo", ((MessageResponse) body).getMessage());
        assertEquals(500, actualHandleGeneralExceptionResult.getStatusCode().value());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
        assertTrue(actualHandleGeneralExceptionResult.hasBody());
        assertTrue(actualHandleGeneralExceptionResult.getHeaders().isEmpty());
    }

    @Test
    void testHandleMaxUploadSizeExceededException() {
        // Arrange
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

        // Act
        ResponseEntity<?> actualHandleMaxUploadSizeExceededExceptionResult = globalExceptionHandler
                .handleMaxUploadSizeExceededException(new MaxUploadSizeExceededException(3L));

        // Assert
        Object body = actualHandleMaxUploadSizeExceededExceptionResult.getBody();
        assertTrue(body instanceof MessageResponse);
        HttpStatusCode statusCode = actualHandleMaxUploadSizeExceededExceptionResult.getStatusCode();
        assertTrue(statusCode instanceof HttpStatus);
        assertEquals("File size exceeds the maximum allowed limit!", ((MessageResponse) body).getMessage());
        assertEquals(417, actualHandleMaxUploadSizeExceededExceptionResult.getStatusCode().value());
        assertEquals(HttpStatus.EXPECTATION_FAILED, statusCode);
        assertTrue(actualHandleMaxUploadSizeExceededExceptionResult.hasBody());
        assertTrue(actualHandleMaxUploadSizeExceededExceptionResult.getHeaders().isEmpty());
    }
}
