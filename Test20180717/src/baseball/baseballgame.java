package baseball;

import java.util.Random;
import java.util.Scanner;

class baseballdata {
	int []g = new int[3]; // Á¤´ä¼ıÀÚ 3°³ ÀúÀåµÇ´Â ¹è¿­
	int value;			  // »ç¿ëÀÚ°¡ ÀÔ·ÂÇÑ°ª 3°³ ÀúÀåµÇ´Â º¯¼ö
	int value2;
	int value3;
	boolean ck = true;
	int count= 0;
	int ct = 0;	
	String restart = "";		// ÀçµµÀü Ã¼Å©
	Random rd = new Random();
	Scanner scn  = new Scanner(System.in);
	
	public void set() {
		for(int i = 0 ; i < g.length-1 ; i++ ) {
			g[i] = rd.nextInt(10) + 1;	// 1~9±îÁöÀÇ °ªÀ» ³Ö¾îÁÜ. ¹è¿­ÀÇ ±æÀÌ¸¸Å­.
			
			if ( i == 0 ) {
				System.out.println("¼ıÀÚ°¡ ¼ÂÆÃµÇ°í ÀÖ½À´Ï´Ù.");
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
		System.out.println("µµÀüÇÒ È½¼ö¸¦ ÀÔ·ÂÇÏ½Ê½Ã¿À. ");
		ct = scn.nextInt();
		System.out.println(count + " "  + ct);
		}
		
		System.out.println("¼ıÀÚ¾ß±¸°ÔÀÓÀ» ½ÃÀÛÇÕ´Ï´Ù. (1~9¹üÀ§)ÀÇ 3°³ÀÇ °ªÀ» ÀÔ·ÂÇÏ¿© ÁÖ½Ê½Ã¿À.");
		System.out.println("Ã¹¹øÂ° °ª.");
		value = scn.nextInt();
		System.out.println("µÎ¹øÂ° °ª.");
		value2 = scn.nextInt();
		System.out.println("¼¼¹øÂ° °ª.");
		value3 = scn.nextInt();
		
		
		
		if( value == value2 || value2 == value3 || value == value3 ) {
			System.out.println("Áßº¹µÈ °ªÀº ÀÔ·Â ºÒ°¡´ÉÇÕ´Ï´Ù. Ã³À½ºÎÅÍ ´Ù½Ã ÀÔ·ÂÇØÁÖ½Ê½Ã¿À.");
			continue;
		}
		
		check();
		
		
		// Á¤ÇØÁø È½¼ö¸¸Å­ °ÔÀÓÀ» ¼öÇàÇÏ°íµµ Á¤´äÀ» ¸ø¸Â­ŸÀ»¶§.
		if ( count == ct ) {
			ck = false;
			System.out.println("Á¤´äÀ» ¸ÂÃßÁö ¸øÇß½À´Ï´Ù.");
			System.out.println("Á¤´äÀº "+ g[0] + ", " + g[1] + ", "+ g[2] + " ÀÔ´Ï´Ù.");
			
			ck = false;
			boolean rt = true;
		
			while ( rt ) {
			Scanner scn2 = new Scanner(System.in);
			System.out.println("´Ù½Ã µµÀüÇÏ½Ã°Ú½À´Ï±î? ( Y/N )");
				
			restart = scn2.next();
				
				if ( scn2.hasNextLine()) {
					if( restart.equals("Y") || restart.equals("y") ) {
					
					System.out.println("»õ·Î ½ÃÀÛÇÕ´Ï´Ù.");	
					count = 0;
					set();
					
					rt = false;
					ck = true;
					}
				    if( restart.equals("N") || restart.equals("n")) {
				    rt = false;
					ck = false;		
					System.out.println("°ÔÀÓÁ¾·á");				
					}
				    
				    if( ((restart.equals("N") || restart.equals("n")) || (restart.equals("Y") || restart.equals("y"))) == false ) 
					{
					System.out.println("y¶Ç´Â nÀ» ÀÔ·ÂÇØ ÁÖ½Ê½Ã¿À");
					continue;				
					}
				
				}
				
			}			
		}		
		
		}
	}
	
	public void check() {
		// Ã¹¹øÂ° ¼ıÀÚ Ã¼Å©
		if ( g[0] == value) {
			System.out.println("Ã¹¹øÂ° ¼ıÀÚ ½ºÆ®¶óÀÌÅ©");
		}
		else if ( value == g[1] || value == g[2] ) 
		{
			System.out.println("Ã¹¹øÂ° ¼ıÀÚ º¼ ");
		}
		else {
			System.out.println("Ã¹¹øÂ° ¼ıÀÚ ºø³ª°¨");
		}
		
		// µÎ¹øÂ° ¼ıÀÚ Ã¼Å©
		if ( g[1] == value2) {
			System.out.println("µÎ¹øÂ° ¼ıÀÚ ½ºÆ®¶óÀÌÅ©");
		}
		else if ( value2 == g[0] || value2 == g[2] ) 
		{
			System.out.println("µÎ¹øÂ° ¼ıÀÚ º¼ ");
		}
		else {
			System.out.println("µÎ¹øÂ° ¼ıÀÚ ºø³ª°¨");
		}
	
		// ¼¼¹øÂ° ¼ıÀÚ Ã¼Å©
		if (g[2] == value3) {
			System.out.println("¼¼¹øÂ° ¼ıÀÚ ½ºÆ®¶óÀÌÅ©");
		}
		else if ( value3 == g[0] || value3 == g[1] ) 
		{
			System.out.println("¼¼¹øÂ° ¼ıÀÚ º¼ ");
		}
		else {
			System.out.println("¼¼¹øÂ° ¼ıÀÚ ºø³ª°¨");
		}
	}
}

public class baseballgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ·£´ıÀ¸·Î 3°³ÀÇ °ªÀ» ¹ŞÀ½ ( ¹è¿­¿¡ ÀúÀå. ¼ø¼­´ë·Î) : o
		// Á¤È®ÇÑ À§Ä¡¿¡ Á¤È®ÇÑ¼ıÀÚ¸¦ ¸ÂÃß¸é ½ºÆ®¶óÀÌÅ©, ¼ıÀÚ´Â µ¿ÀÏÇÏÁö¸¸ À§Ä¡´Â ´Ù¸£¸é º¼
		// °ÔÀÓ µµÀüÈ½¼ö¸¸Å­ While¹®
		baseballdata bd = new baseballdata();
		bd.set();
		bd.play();
		
	}

}





