package dev.ivanqueiroz.jbin3dec.main;

import dev.ivanqueiroz.jbin3dec.util.Conversor;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.Test void bin2dec() {
        assertEquals(9.0, Conversor.bin2dec("1001"));
        assertEquals(10.0, Conversor.bin2dec("1010"));
        assertThrows(IllegalArgumentException.class, ()->Conversor.bin2dec("22222"));
    }
}
