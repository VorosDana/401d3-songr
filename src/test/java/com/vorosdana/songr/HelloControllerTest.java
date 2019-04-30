package com.vorosdana.songr;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloControllerTest {

    @Test
    public void helloWorld() {
        HelloController testoTheTester = new HelloController();

        assertNotNull(testoTheTester);
        assertNotNull(testoTheTester.helloWorld());
        assertEquals("Hellooooooo!", testoTheTester.helloWorld());

    }
}