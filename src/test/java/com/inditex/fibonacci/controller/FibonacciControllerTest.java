package com.inditex.fibonacci.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.inditex.fibonacci.domain.FibonacciResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class FibonacciControllerTest extends AbstractTest {

    private final static String ERROR_MESSAGE = "[ERROR] Size must be higher or equal than 0";
    private final static String FIBONACCI_PATH = "/fibonacci?size=";

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    private FibonacciResponse callFibonacciController(final String size) throws Exception {
        FibonacciResponse response = null;
        String uri = FIBONACCI_PATH + size;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        response = super.mapFromJson(content, FibonacciResponse.class);

        return response;
    }

    @Test
    public void getFibonacciSequenceNegativeElements() throws Exception {
        FibonacciResponse response = callFibonacciController("-1");
        assertTrue(response.getSize() == -1);
        assertTrue(response.getSequence() == null);
        assertEquals(response.getError(), ERROR_MESSAGE);
    }

    @Test
    public void getFibonacciSequenceZeroElements() throws Exception {
        FibonacciResponse response = callFibonacciController("0");
        assertTrue(response.getSize() == 0);
        assertTrue(response.getSequence().isEmpty());
        assertEquals(response.getError(), null);
    }

    @Test
    public void getFibonacciSequenceOneElements() throws Exception {
        FibonacciResponse response = callFibonacciController("1");
        assertTrue(response.getSize() == 1);
        assertTrue(response.getSequence().size() == 1);
        assertEquals(response.getError(), null);
    }

    @Test
    public void getFibonacciSequenceFourElements() throws Exception {
        FibonacciResponse response = callFibonacciController("4");
        assertTrue(response.getSize() == 4);
        assertTrue(response.getSequence().size() > 0);
        assertEquals(response.getError(), null);
    }

}
