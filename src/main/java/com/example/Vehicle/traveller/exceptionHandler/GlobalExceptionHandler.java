package com.example.Vehicle.traveller.exceptionHandler;

import com.example.Vehicle.traveller.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        Map<String,String> map=new HashMap<>();
        for(ObjectError error:allErrors){
            String defaultMessage = error.getDefaultMessage();
            String field=((FieldError)error).getField();
            map.put(field,defaultMessage);
        }
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }
}