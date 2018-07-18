package baseball;

import java.util.Random;
import java.util.Scanner;

class baseballdata {
	int []g = new int[3]; // 정답숫자 3개 저장되는 배열
	int value;			  // 사용자가 입력한값 3개 저장되는 변수
	int value2;
	int value3;
	boolean ck = true;
	int count= 0;
	int ct = 0;	
	String restart = "";		// 재도전 체크
	Random rd = new Random();
	Scanner scn  = new Scanner(System.in);
	
	public void set() {
		for(int i = 0 ; i < g.length-1 ; i++ ) {
			g[i] = rd.nextInt(10) + 1;	// 1~9까지의 값을 넣어줌. 배열의 길이만큼.
			
			if ( i == 0 ) {
				System.out.println("숫자가 셋팅되고 있습니다.");
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
		System.out.println("도전할 횟수를 입력하십시오. ");
		ct = scn.nextInt();
		System.out.println(count + " "  + ct);
		}
		
		System.out.println("숫자야구게임을 시작합니다. (1~9범위)의 3개의 값을 입력하여 주십시오.");
		System.out.println("첫번째 값.");
		value = scn.nextInt();
		System.out.println("두번째 값.");
		value2 = scn.nextInt();
		System.out.println("세번째 값.");
		value3 = scn.nextInt();
		
		
		
		if( value == value2 || value2 == value3 || value == value3 ) {
			System.out.println("중복된 값은 입력 불가능합니다. 처음부터 다시 입력해주십시오.");
			continue;
		}
		
		check();
		
		
		// 정해진 횟수만큼 게임을 수행하고도 정답을 못맞췃을때.
		if ( count == ct ) {
			ck = false;
			System.out.println("정답을 맞추지 못했습니다.");
			System.out.println("정답은 "+ g[0] + ", " + g[1] + ", "+ g[2] + " 입니다.");
			
			ck = false;
			boolean rt = true;
		
			while ( rt ) {
			Scanner scn2 = new Scanner(System.in);
			System.out.println("다시 도전하시겠습니까? ( Y/N )");
				
			restart = scn2.next();
				
				if ( scn2.hasNextLine()) {
					if( restart.equals("Y") || restart.equals("y") ) {
					
					System.out.println("새로 시작합니다.");	
					count = 0;
					set();
					
					rt = false;
					ck = true;
					}
				    if( restart.equals("N") || restart.equals("n")) {
				    rt = false;
					ck = false;		
					System.out.println("게임종료");				
					}
				    
				    if( ((restart.equals("N") || restart.equals("n")) || (restart.equals("Y") || restart.equals("y"))) == false ) 
					{
					System.out.println("y또는 n을 입력해 주십시오");
					continue;				
					}
				
				}
				
			}			
		}		
		
		}
	}
	
	public void check() {
		// 첫번째 숫자 체크
		if ( g[0] == value) {
			System.out.println("첫번째 숫자 스트라이크");
		}
		else if ( value == g[1] || value == g[2] ) 
		{
			System.out.println("첫번째 숫자 볼 ");
		}
		else {
			System.out.println("첫번째 숫자 빗나감");
		}
		
		// 두번째 숫자 체크
		if ( g[1] == value2) {
			System.out.println("두번째 숫자 스트라이크");
		}
		else if ( value2 == g[0] || value2 == g[2] ) 
		{
			System.out.println("두번째 숫자 볼 ");
		}
		else {
			System.out.println("두번째 숫자 빗나감");
		}
	
		// 세번째 숫자 체크
		if (g[2] == value3) {
			System.out.println("세번째 숫자 스트라이크");
		}
		else if ( value3 == g[0] || value3 == g[1] ) 
		{
			System.out.println("세번째 숫자 볼 ");
		}
		else {
			System.out.println("세번째 숫자 빗나감");
		}
	}
}

public class baseballgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 랜덤으로 3개의 값을 받음 ( 배열에 저장. 순서대로) : o
		// 정확한 위치에 정확한숫자를 맞추면 스트라이크, 숫자는 동일하지만 위치는 다르면 볼
		// 게임 도전횟수만큼 While문
		baseballdata bd = new baseballdata();
		bd.set();
		bd.play();
		
	}

}





