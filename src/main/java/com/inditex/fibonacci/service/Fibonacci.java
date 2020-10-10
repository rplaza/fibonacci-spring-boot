package com.inditex.fibonacci.service;

import org.springframework.stereotype.Component;

@Component
public class Fibonacci {

    public int sequence(int index) {
        if (index > 1) {
            return sequence(index - 1) + sequence(index - 2);
        } else {
            return index;
        }
    }
}
