package Date_Chapter31;

import java.time.ZoneId;

public class ZoneIdDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZoneId.getAvailableZoneIds()
			  .stream()
			  .filter( s -> s.startsWith("Asia") )
			  .sorted()
			  .forEach( s -> System.out.println(s) );
	}

}
