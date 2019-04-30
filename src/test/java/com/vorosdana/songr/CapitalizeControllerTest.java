package com.vorosdana.songr;

import org.junit.Test;

import static org.junit.Assert.*;

public class CapitalizeControllerTest {

    @Test
    public void capitalize() {
        CapitalizeController testoTheTester = new CapitalizeController();

        assertEquals("THINGSES",
                testoTheTester.capitalize("thingses"));

        assertEquals("STUFFLES",
                testoTheTester.capitalize("stuffles"));

        assertEquals("TOTALLY CAPITALIZED",
                testoTheTester.capitalize("totally capitalized"));
    }
}