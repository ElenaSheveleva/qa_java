package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LionParamTest {

    private final String sex;
    private final boolean hasMane;

    public LionParamTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeReturnsCorrectValue() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);
        assertTrue(lion.doesHaveMane() == hasMane);
    }

    @Test
    public void lionConstructorThrowsExceptionForInvalidSex() {
        assertThrows(Exception.class, () -> new Lion("Кот", new Feline()));
    }
}