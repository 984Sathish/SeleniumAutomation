package Stream;

import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Limit {

	@Test
	public void limit() {
		
		/*
		 * Limit is used for limit the result once we get the value from the filter.
		 * In this cases, we got 2 values but limit method is we used after the filter so we only get 1 value.
		 */
		Stream.of("abi", "ravi", "sheak").filter(name->name.length()>3).limit(1).forEach(s-> System.out.println(s));
	}
}
