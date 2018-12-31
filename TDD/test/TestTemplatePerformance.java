package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Template;

class TestTemplatePerformance {
	
	private Template template;
	
	@BeforeEach
	void setUp() {
		template = new Template("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
		template.put("one", "hghghghghghghg");
		template.put("two", "jghtiutjskoetwo");
		template.put("three", "threejeikoeltcm");
		template.put("four", "fourokhzjithsnvzrct");
		template.put("five", "itlogjheüqäe+hd");
		template.put("six", "nvhgtfync.lawer");
		template.put("seven", "fhgntjvutiosneh");
		template.put("eight", "jgndjtueiwm,skfr");
		template.put("nine", "12345jfnfisjdsdfnsjd");
		template.put("ten", "jgiskynvhfirmsjh");
		template.put("eleven", "qzaudhftneirushy");
		template.put("twelve", "fhynbgvtisjdutr");
		template.put("thirteen", "rtidgokyjmnters");
		template.put("fourteen", "ghtueiwkmyndhezt");
		template.put("fifteen", "+lgotisktugiehmr");
		template.put("sixteen", "hgutijmewzutisekti");
		template.put("seventeen", "qahstietjemdnche");
		template.put("eighteen", "eutisgndiewoket");
		template.put("nineteen", "gghtuoskmyenhres");
		template.put("twenty", "ghrtzuiakfmgdhst");
	}
	
	@Test
	void templateWith100WordsAnd20Variables() throws Exception {
        long expected = 200L;
        long time = System.currentTimeMillis();
        template.evaluate();
        time = System.currentTimeMillis() - time;
        assertTrue(time <= expected, "Rendering the template took " + time + "ms while the target was " + expected + "ms");
    }

}
