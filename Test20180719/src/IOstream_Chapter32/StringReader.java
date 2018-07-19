package IOstream_Chapter32;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
// p838
public class StringReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(BufferedReader br = new BufferedReader(new FileReader("String.txt"))) {
			String str;
			while(true) {
				str = br.readLine(); //한 문장 읽어 들이기
				if(str == null)
					break;
				System.out.println(str);
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
