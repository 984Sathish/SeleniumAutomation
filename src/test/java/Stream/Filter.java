package Stream;

import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Filter {

	@Test
	public void filter() {

		/*
		 * Filter is perform action with change the list size.
		 * In this cases, filter the start with 'r' letter. so, list we got based on the starting value.
		 */
		Stream.of("abi", "ravi", "shek").filter(name-> name.startsWith("r")).forEach(s-> System.out.println(s));
		
	}

}
