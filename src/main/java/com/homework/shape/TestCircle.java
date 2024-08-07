package com.homework.shape;

import com.classwork.collection.generic.ChildCircleClass;
import com.classwork.collection.generic.CircleClass;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TestCircle {

    @Test
    public void givenAbstractClass_whenValidCircleUsed_thenPass() {
        CircleClass redCircle = new ChildCircleClass();
        redCircle.setColor("RED");
        assertTrue(redCircle.isValid());
    }

    @Test
    public void givenInterface_whenValidCircleWithoutStateUsed_thenPass() {
        ChidlCircleInterfaceImpl redCircleWithoutState = new ChidlCircleInterfaceImpl();
        redCircleWithoutState.setColor("RED");
        assertTrue(redCircleWithoutState.isValid());
    }
}
