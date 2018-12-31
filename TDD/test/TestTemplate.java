package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.MissingFormatArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.MissingValueException;
import src.Template;

public class TestTemplate {
	
	private Template template;
	
	@BeforeEach
	public void setUp() throws Exception {
		template = new Template("${one}, ${two}, ${three}");
		template.put("one", "1");
		template.put("two", "2");
		template.put("three", "3");
	}
	
	@Test
	void multipleVariables() throws Exception {
		assertTemplateEvaluatesTo("1, 2, 3");
	}
	
	@Test
	void unknownVariablesAreIgnored() throws Exception {
		template.put("doesnotexist", "Hi");
		
		assertTemplateEvaluatesTo("1, 2, 3");
	}
	
	private void assertTemplateEvaluatesTo(String expected) {
		assertEquals(expected, template.evaluate());
	}
	
	@Test
	void missingValueRaisesException() throws Exception {
	    try {
	        new Template("${foo}").evaluate();
	        fail("evaluate() should throw an exception if "
	                + "a variable was left without a value!");
	    } catch (MissingValueException expected) {
	    	assertEquals("No value for ${foo}", expected.getMessage());
	    }
	}
	
	/*
	@Test
	void variablesGetProcessedJustOnce() throws Exception {
		template.put("one", "${one}");
		template.put("two", "${three}");
		template.put("three", "${two}");
		assertTemplateEvaluatesTo("${one}, ${three}, ${two}");
	}
	*/
}
