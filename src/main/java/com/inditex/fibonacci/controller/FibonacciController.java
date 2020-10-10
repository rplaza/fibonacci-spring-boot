package com.inditex.fibonacci.controller;

import com.inditex.fibonacci.domain.FibonacciResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.inditex.fibonacci.service.Fibonacci;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class FibonacciController {

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
}
