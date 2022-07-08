package edu.miu.cs.cs425.eregistrar.advice;

import edu.miu.cs.cs425.eregistrar.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class eRegistrarWebAPIExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(StudentNotFoundException.class)
    public Map<String,String>handleWebAPIException(StudentNotFoundException studentNotFoundException){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("erroeMessage", studentNotFoundException.getMessage());
        return errorMap;
    }
}
