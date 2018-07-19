package IOstream_Chapter32;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class TextReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ����: ");
		String src = sc.nextLine();
		
		try(Reader in = new FileReader(src)) { //���� �Է� ��Ʈ�� ����
			int ch;
			
			while(true) {
				ch = in.read(); // ���ڸ� �ϳ��� �д´�.
				if(ch == -1) // �� �̻� ���� ���ڰ� ���ٸ�,
					break;
				System.out.print((char)ch); //���ڸ� �ϳ��� ����Ѵ�.
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
