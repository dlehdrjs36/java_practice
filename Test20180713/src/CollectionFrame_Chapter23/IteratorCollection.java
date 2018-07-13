package CollectionFrame_Chapter23;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new LinkedList<>();			//list(string타입)에 대해서 객채를 생성. LinkedList로 list를 선언했다. 
		
		//인스턴스를 저장
		list.add("Toy");
		list.add("Box");
		list.add("Robot");
		list.add("Box");			//총 4개를 저장.
		
		Iterator<String> itr = list.iterator();			//반복자 처음 획득. iterator<- 반복자.
		
		//반복자를 이용한 순차적 참조.
		while(itr.hasNext())			//hasNext를 통해 위의 인스턴스 처음에 값이 있는지 없는지 확인함
			System.out.print(itr.next()+ '\t');			//값이 있으면 그값을 읽은후 다음값이 있는지 확인할 준비를 마침
		System.out.println();
		
		itr = list.iterator();							//반복자 다시획득. 한방향으로 밖에 읽지 못함.
		
		String str;
		while(itr.hasNext()) {			
			str = itr.next();
			if(str.equals("Box"))
				itr.remove();
		}
		
		itr = list.iterator();							//반복자 다시 획득.
		
		while(itr.hasNext())
			System.out.print(itr.next() + '\t');
		System.out.println();						//삭제후 결과 확인
	}

}
