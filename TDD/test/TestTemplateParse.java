package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import src.PlainText;
import src.Segment;
import src.TemplateParse;
import src.Variable;

class TestTemplateParse {
		
	private List<String> parse(String template) {
		return new TemplateParse().parse(template);
	}
	
	private void assertSegments(List<? extends Object> actual, Object... expected) {
		assertEquals("Number of segments doesn�t match.", expected.length, actual.size());
		assertEquals(Arrays.asList(expected), actual);
	}

	@Test
	void emptyTemplateRendersAsEmptyString() throws Exception {
		List<String> segments = parse("");
		
		assertSegments(segments, "");
	}
	
	@Test
	void templateWithOnlyPlainText() throws Exception {
		List<String> segments = parse("plain text only");
		
		assertSegments(segments, "plain text only");
	}
	
	@Test
	void parsingMultipleVariables() {
		List<String> segments = parse("${a}:${b}:${c}");
		
		assertSegments(segments, "${a}", ":", "${b}", ":", "${c}");
	}
	
	@Test
	void parsingTemplateIntoSegmentObjects() throws Exception {
		TemplateParse p = new TemplateParse();
		List<Segment> segments = p.parseSegments("a ${b} c ${d}");
		
		assertSegments(segments, new PlainText("a "), new Variable("b"), new PlainText(" c "), new Variable("d"));
	}
}


