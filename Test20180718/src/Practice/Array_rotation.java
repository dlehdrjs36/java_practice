package Practice;

public class Array_rotation {
	
	public int[][] a_r_90rotation(){
		
		int a[][] = new int[5][5];
		System.out.println("=========================");
		System.out.println("오른쪽으로 90도 회전");
		// 오른쪽  90도 회전
		for ( int i = 0 ;  i <= a.length-1 ; i++) {
			for ( int j = 0 ; j <= a.length-1 ; j++) {
				
				System.out.print(a[(a.length-1)-j][i] + " ");	
			}
			System.out.println();
		}
		System.out.println("=========================");
		
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[][] = new int[5][5];
		int b;
		
		int count = 0;
		System.out.println(a.length);
		
		System.out.println("배열 생성중");
		for ( int i = 0 ;  i < a.length ; i++) {
			for ( int j = 0 ; j < a.length ; j++) {
				a[i][j] = count++;
			}
		}
	
		// 생성된 배열 확인
		for ( int i = 0 ;  i < a.length ; i++) {
			for ( int j = 0 ; j < a.length ; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		//
		System.out.println("=========================");
		System.out.println("오른쪽으로 90도 회전");
		// 오른쪽  90도 회전
		for ( int i = 0 ;  i <= a.length-1 ; i++) {
			for ( int j = 0 ; j <= a.length-1 ; j++) {
				
				System.out.print(a[(a.length-1)-j][i] + " ");	
			}
			System.out.println();
		}
		System.out.println("=========================");
		System.out.println("왼쪽으로 90도 회전");
		// 왼쪽  90도 회전
		for ( int i = 0 ;  i <= a.length-1 ; i++) {
			for ( int j = 0 ; j <= a.length-1 ; j++) {
				
				System.out.print(a[j][(a.length-1)-i] + " ");	
			}
			System.out.println();
		}
		
		
		
	}

}
