package com.morse;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.morse.util.MorseUtil;

/**
 * junit test.
 *
 * @author csanchez
 */
public class MorseTest {

    @Test
    public void testText_OK() throws Exception {
        assertTrue(MorseUtil.txtToMorse("hola").equals("....---.-...-"));
    }

    @Test
    public void testText_NULL() throws Exception {
        assertTrue(MorseUtil.txtToMorse("") == null);
    }
}