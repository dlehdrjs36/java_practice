package baseball;

import java.util.Random;
import java.util.Scanner;

class baseballdata {
	int []g = new int[3]; // ������� 3�� ����Ǵ� �迭
	int value;			  // ����ڰ� �Է��Ѱ� 3�� ����Ǵ� ����
	int value2;
	int value3;
	boolean ck = true;
	int count= 0;
	int ct = 0;	
	String restart = "";		// �絵�� üũ
	Random rd = new Random();
	Scanner scn  = new Scanner(System.in);
	
	public void set() {
		for(int i = 0 ; i < g.length-1 ; i++ ) {
			g[i] = rd.nextInt(10) + 1;	// 1~9������ ���� �־���. �迭�� ���̸�ŭ.
			
			if ( i == 0 ) {
				System.out.println("���ڰ� ���õǰ� �ֽ��ϴ�.");
			}
			else if ( g[i] == g[i-1]) {
				i--;
				continue;
			}
		}	
	}
	
	public void play() {

		
		while( ck ) {
	
		count++;
		
		if ( count == 1) {
		System.out.println("������ Ƚ���� �Է��Ͻʽÿ�. ");
		ct = scn.nextInt();
		System.out.println(count + " "  + ct);
		}
		
		System.out.println("���ھ߱������� �����մϴ�. (1~9����)�� 3���� ���� �Է��Ͽ� �ֽʽÿ�.");
		System.out.println("ù��° ��.");
		value = scn.nextInt();
		System.out.println("�ι�° ��.");
		value2 = scn.nextInt();
		System.out.println("����° ��.");
		value3 = scn.nextInt();
		
		
		
		if( value == value2 || value2 == value3 || value == value3 ) {
			System.out.println("�ߺ��� ���� �Է� �Ұ����մϴ�. ó������ �ٽ� �Է����ֽʽÿ�.");
			continue;
		}
		
		check();
		
		
		// ������ Ƚ����ŭ ������ �����ϰ� ������ ���­�����.
		if ( count == ct ) {
			ck = false;
			System.out.println("������ ������ ���߽��ϴ�.");
			System.out.println("������ "+ g[0] + ", " + g[1] + ", "+ g[2] + " �Դϴ�.");
			
			ck = false;
			boolean rt = true;
		
			while ( rt ) {
			Scanner scn2 = new Scanner(System.in);
			System.out.println("�ٽ� �����Ͻðڽ��ϱ�? ( Y/N )");
				
			restart = scn2.next();
				
				if ( scn2.hasNextLine()) {
					if( restart.equals("Y") || restart.equals("y") ) {
					
					System.out.println("���� �����մϴ�.");	
					count = 0;
					set();
					
					rt = false;
					ck = true;
					}
				    if( restart.equals("N") || restart.equals("n")) {
				    rt = false;
					ck = false;		
					System.out.println("��������");				
					}
				    
				    if( ((restart.equals("N") || restart.equals("n")) || (restart.equals("Y") || restart.equals("y"))) == false ) 
					{
					System.out.println("y�Ǵ� n�� �Է��� �ֽʽÿ�");
					continue;				
					}
				
				}
				
			}			
		}		
		
		}
	}
	
	public void check() {
		// ù��° ���� üũ
		if ( g[0] == value) {
			System.out.println("ù��° ���� ��Ʈ����ũ");
		}
		else if ( value == g[1] || value == g[2] ) 
		{
			System.out.println("ù��° ���� �� ");
		}
		else {
			System.out.println("ù��° ���� ������");
		}
		
		// �ι�° ���� üũ
		if ( g[1] == value2) {
			System.out.println("�ι�° ���� ��Ʈ����ũ");
		}
		else if ( value2 == g[0] || value2 == g[2] ) 
		{
			System.out.println("�ι�° ���� �� ");
		}
		else {
			System.out.println("�ι�° ���� ������");
		}
	
		// ����° ���� üũ
		if (g[2] == value3) {
			System.out.println("����° ���� ��Ʈ����ũ");
		}
		else if ( value3 == g[0] || value3 == g[1] ) 
		{
			System.out.println("����° ���� �� ");
		}
		else {
			System.out.println("����° ���� ������");
		}
	}
}

public class baseballgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �������� 3���� ���� ���� ( �迭�� ����. �������) : o
		// ��Ȯ�� ��ġ�� ��Ȯ�Ѽ��ڸ� ���߸� ��Ʈ����ũ, ���ڴ� ���������� ��ġ�� �ٸ��� ��
		// ���� ����Ƚ����ŭ While��
		baseballdata bd = new baseballdata();
		bd.set();
		bd.play();
		
	}

}





