package CollectionFrame_Chapter23;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new LinkedList<>();			//list(stringŸ��)�� ���ؼ� ��ä�� ����. LinkedList�� list�� �����ߴ�. 
		
		//�ν��Ͻ��� ����
		list.add("Toy");
		list.add("Box");
		list.add("Robot");
		list.add("Box");			//�� 4���� ����.
		
		Iterator<String> itr = list.iterator();			//�ݺ��� ó�� ȹ��. iterator<- �ݺ���.
		
		//�ݺ��ڸ� �̿��� ������ ����.
		while(itr.hasNext())			//hasNext�� ���� ���� �ν��Ͻ� ó���� ���� �ִ��� ������ Ȯ����
			System.out.print(itr.next()+ '\t');			//���� ������ �װ��� ������ �������� �ִ��� Ȯ���� �غ� ��ħ
		System.out.println();
		
		itr = list.iterator();							//�ݺ��� �ٽ�ȹ��. �ѹ������� �ۿ� ���� ����.
		
		String str;
		while(itr.hasNext()) {			
			str = itr.next();
			if(str.equals("Box"))
				itr.remove();
		}
		
		itr = list.iterator();							//�ݺ��� �ٽ� ȹ��.
		
		while(itr.hasNext())
			System.out.print(itr.next() + '\t');
		System.out.println();						//������ ��� Ȯ��
	}

}
