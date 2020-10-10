package com.inditex.fibonacci.controller;

import com.inditex.fibonacci.domain.FibonacciResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.inditex.fibonacci.service.Fibonacci;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class FibonacciController implements ErrorController {

    private final static String ERROR_PATH = "/error";

    @Autowired
    private Fibonacci fibonacci;

    @RequestMapping(value = "/fibonacci", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    FibonacciResponse fibonacciRest(@RequestParam final int size) {
        FibonacciResponse response = new FibonacciResponse(size);
        if (size < 0 ) {
            response.setError("[ERROR] Size must be higher or equal than 0");
        } else {
            log.info("[INFO] Requested " + size + " elements of Fibonacci sequence");
            List sequence = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                sequence.add(fibonacci.sequence(i));
            }
            response.setSequence(sequence);
        }
        return response;
    }

    @RequestMapping(value = ERROR_PATH, method = RequestMethod.GET)
    @ResponseBody
    public String errorHtml(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        return String.format("<html>" +
                        "<body>" +
                        "<h2>What's the hell are you doing here?</h2>" +
                        "<h3>You make a request to the wrong way. Please take a look at the documentation: http://localhost:8081/swagger-ui.html</h3>" +
                        "<div>Status code: <b>%s</b></div>" +
                        "<div>Exception Message: <b>%s</b></div>" +
                        "<body>" +
                        "</html>",
                statusCode, exception==null? "N/A": exception.getMessage());
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
