package com.inditex.fibonacci.domain;

import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class FibonacciResponse {
    @NonNull private int size;
    private List<Integer> sequence;
    private String error;
}
