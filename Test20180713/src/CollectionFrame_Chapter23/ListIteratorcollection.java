package CollectionFrame_Chapter23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorcollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("Toy", "Box", "Robot", "Box");
		list = new ArrayList<>(list);
		
		ListIterator<String> litr = list.listIterator();			//양방향 반복자 획득. 선언	/ 객체생성.
		
		String str;
		while(litr.hasNext()) {		//왼쪽에서 오른쪽으로 이동을 위한 반복문
			str = litr.next();
			System.out.print(str + '\t');
			if(str.equals("Toy"))		//"Toy" 만나면 "Toy"2저장
				litr.add("Toy2");											//"Toy"<-"Toy2"<-"Box"<-"Robot"<-"Box"
		
		}
		
		System.out.println();	
		System.out.println("=============================");
		while(litr.hasPrevious()) {								//오른쪽에서 왼쪽으로 이동을 위한 반복문
			str = litr.previous();
			System.out.print(str + '\t');
			if(str.equals("Robot"))								//"Robot" 만나면 "Robot2" 저장 						"Toy"<-"Box""Robot2"<-"Robot"(로봇을 만남)<-"Box"
				litr.add("Robot2");
		}
		
		System.out.println();
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::");
		
		//다시 왼쪽에서 오른쪽으로.
		for(Iterator<String> itr = list.iterator(); itr.hasNext(); )
			System.out.print(itr.next() + '\t');
		System.out.println();
			
		}
	}

