package IOstream_Chapter32;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Write7ToFile3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			try (OutputStream out = new FileOutputStream("data.dat")){
					out.write(7);
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
}
