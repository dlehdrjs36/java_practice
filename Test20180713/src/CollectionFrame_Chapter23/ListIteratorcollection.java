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
		
		ListIterator<String> litr = list.listIterator();			//����� �ݺ��� ȹ��. ����	/ ��ü����.
		
		String str;
		while(litr.hasNext()) {		//���ʿ��� ���������� �̵��� ���� �ݺ���
			str = litr.next();
			System.out.print(str + '\t');
			if(str.equals("Toy"))		//"Toy" ������ "Toy"2����
				litr.add("Toy2");											//"Toy"<-"Toy2"<-"Box"<-"Robot"<-"Box"
		
		}
		
		System.out.println();	
		System.out.println("=============================");
		while(litr.hasPrevious()) {								//�����ʿ��� �������� �̵��� ���� �ݺ���
			str = litr.previous();
			System.out.print(str + '\t');
			if(str.equals("Robot"))								//"Robot" ������ "Robot2" ���� 						"Toy"<-"Box""Robot2"<-"Robot"(�κ��� ����)<-"Box"
				litr.add("Robot2");
		}
		
		System.out.println();
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::");
		
		//�ٽ� ���ʿ��� ����������.
		for(Iterator<String> itr = list.iterator(); itr.hasNext(); )
			System.out.print(itr.next() + '\t');
		System.out.println();
			
		}
	}

