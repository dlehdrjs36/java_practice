package IOstream_Chapter32;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Read7FromFile3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(InputStream in = new FileInputStream("data.dat")) {
			int dat = in.read();
		
			System.out.println(dat);
		} 
		catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

}
