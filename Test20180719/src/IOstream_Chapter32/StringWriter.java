package IOstream_Chapter32;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//p837
public class StringWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ks = "���ο� �־ ���� �� �ʿ��� ���� �ƴϴ�.";
		String es = "Life is long if you know how to use it.";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("String.txt"))) {
			bw.write(ks, 0, ks.length());
			bw.newLine(); // �ٹٲ� ���ڸ� ����
			bw.write(es, 0, es.length());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
