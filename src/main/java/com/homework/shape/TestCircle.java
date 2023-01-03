//package com.homework.shape;
//
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;
//
//import com.classwork.interfaceVsAbstractClass.CircleClass;
//
//public class TestCircle {
//
//	public TestCircle() {
//		// TODO Auto-generated constructor stub
//	}
//}
//
//class InterfaceVsAbstractClassUnitTest {
//
//	@Test
//	public void givenAbstractClass_whenValidCircleUsed_thenPass() {
//		CircleClass redCircle = new ChildCircleClass();
//		redCircle.setColor("RED"); 
//		assertTrue(redCircle.isValid());
//	}
//
//	@Test
//	public void givenInterface_whenValidCircleWithoutStateUsed_thenPass() {
//		ChidlCircleInterfaceImpl redCircleWithoutState = new ChidlCircleInterfaceImpl();
//		redCircleWithoutState.setColor("RED");
//		assertTrue(redCircleWithoutState.isValid());
//	}
//}
