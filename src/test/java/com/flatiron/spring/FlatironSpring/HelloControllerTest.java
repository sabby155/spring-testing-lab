package com.flatiron.spring.FlatironSpring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    @Test
    void hello() {
        HelloController helloController = new HelloController();
//        assertEquals("Hello World", helloController.hello());
        String name = "Jamie";
        assertEquals("Hello " + name, helloController.hello(name));
    }

    @Test
    void reverse() {
        HelloController helloController = new HelloController();
        String stringToReverse = "EXAMPLE";
        assertEquals("ELPMAXE", helloController.reverse(stringToReverse).toUpperCase());
    }
}