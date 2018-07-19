package IOstream_Chapter32;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TextWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Writer out = new FileWriter("data.txt")) {
			for (int ch = (int) 'A'; ch < (int) ('Z' + 1); ch++)	//a���� z���� data.txt�� �ۼ�.
				out.write(ch);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
