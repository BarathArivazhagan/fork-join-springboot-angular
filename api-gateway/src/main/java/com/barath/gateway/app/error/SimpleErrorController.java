package com.barath.gateway.app.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({"${server.error.path:${error.path:/error}}"})
public class SimpleErrorController implements ErrorController {

    public ResponseEntity<Object> handleError(HttpServletRequest request) {
        
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        return ResponseEntity.status(statusCode).body(exception.getMessage());
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
