package Stream;

import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Map {

	@Test
	public void mapStream() {
		
		/*
		 * Map is used to perform action without changing the size of list.
		 * In this cases,  we make the words as upper case only. not changing any size.
		 */
		Stream.of("abi", "ravi", "sheak").map(name-> name.toUpperCase())
											.forEach(s-> System.out.println(s)) ;

	}

}
