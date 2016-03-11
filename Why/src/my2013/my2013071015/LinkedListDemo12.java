package my2013.my2013071015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LinkedListDemo12 {
	
	Scanner sc  = new Scanner(System.in);
	
	public int[] input1() {
		System.out.print("please input two num spilt by space ���� ");
		String tmp = sc.nextLine();
		int [] arr = new int[]{Integer.valueOf(tmp.split(" ")[0]).intValue(),Integer.valueOf(tmp.split(" ")[1])}; //
		//����������������������������������������������������intValue : convent a integer type to int type
		return arr;//sc.read �� return a int type ,it return you character 's ASCII;
	}
	
	public List<Character> input2() throws IOException{// the return type must be List ,for 'List cl'
		System.out.print("please input two character inside a to z ���� ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmps = br.readLine();
		Character [] c = new Character[]{tmps.split(" ")[0].toCharArray()[0],tmps.split(" ")[1].toCharArray()[0]};
		//Character.valueOf(br.readLine().split(" ")[1])  is err      toCharArray:string convent to char arr
		
		if (c[0] > c[1]){
			char tmp = c[0];
			c[0] = c[1];
			c[1] = tmp;
		}
		int sum = c[1] - c[0] +1;
//		System.out.println(sum);
		List<Character> cl = new ArrayList<Character>(sum);//
		System.out.println("  before add the lenght:   " + cl.size());
		for (int i = c[0] ; i < c[0] + sum ; i++) {
			cl.add(Character.valueOf((char)i));
		}
		System.out.println("  after add the lenght:   " + cl.size());
		return cl;
	}
	
	
	public int input3(){
		System.out.print("please input a num ���� ");
		return sc.nextInt();
	}
	
	public char input4(){
		System.out.print("add a element to the list ���� ");
//		return (char) sc.nextByte();//in run time  it cause inputMisatchException
		return sc.next().charAt(0);//in run time  it cause inputMisatchException
	}
	
	public void linkTest1(int [] num){
		
		LinkedList<Object> ll = new LinkedList<Object>();//inside <> ,must be wrapped class ,so cannot be int 
		for (int i = num[0]; i <= num[1]; i++) {
			ll.add(i);
		}
		System.out.println("  <-- ���������:\t" + ll.getClass() + " -->");
		System.out.println("  <-- ����������:\t" + ll + " -->");//output the contains,
		System.out.println("  <-- ��������:\t" + ll.size() + " -->");
		System.out.println("  <-- ��������λ:(getFrist())\t" + ll.getFirst() + " -->");
		
		char btc = input4();
		ll.addFirst(btc);
		System.out.println("  <-- ��������λ:(element())\t" + ll.element() + " -->");
		System.out.println("  <-- ��������λ:(peek())\t" + ll.peek() + " -->");//peekFrist() : if has no return null;

		ll.addLast((char)(++btc));
		System.out.println("  <-- ������ĩβ:(getLast())\t" + ll.getLast() + " -->");
		System.out.println("  <-- ������ĩβ:(peekLast())\t" + ll.peekLast() + " -->");
		
		System.out.println("now traversal the list  the element in a line����");
//		Iterator<Object> it = ll.iterator();
		int i = 0;
		for (Object character : ll) {
			System.out.print("\t" + character);
			if(i%15==14)
				System.out.println();
			i++;
		}
		
		System.out.println("\n  <-- ��������:(pollFrist)\t" + ll.pollFirst() + " -->");//poll(),pollFrist(),pollLast()
		System.out.println("  <-- ������β:(remove(index))\t" + ll.remove(ll.size()-1) + " -->");//remove(),remove(index),removeFrist,removeLast
		
		int numi = input3();
		boolean ifcont = ll.contains(numi);
		System.out.println("  <-- �Ƿ����" +numi+ ":\t" + (ifcont?"��":"��") + " -->");
		//the judge ifcont must wraped by (),or it will prase to boolean and cause err
		if(ifcont)
			System.out.println("  <-- ����������" +numi+ "�ǵڼ���?:\t�ǵ�" + ll.indexOf(numi) + "�� -->");
			//(ll.indexOf(Integer.valueOf(10).intValue())+1) : write ten's
		
		List<Character> cl = null;
		try {
			cl = new LinkedListDemo12().input2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ll.addAll(ll.size()/2, (ArrayList<Character>)cl);
//		ll.addAll(Arrays.asList('a','b','c','d','e'));//ll.addAll(int ,collection<E-Object>),  aslist can write as so
		System.out.println("  <-- ����������:\t" + ll + " -->");
		System.out.println("  <-- ��������:\t" + ll.size() + " -->");
		if(ifcont)
			System.out.println("  <-- ����������" +numi+ "�ǵڼ���?:\t�ǵ�" + ll.indexOf(numi) + "�� -->");
		
		
		System.out.println("now traversal the list  the element in a line����");
//		Iterator<Object> it = ll.iterator();
		
		for (Object character : ll) {
			System.out.print("\t" + character);
			if(i%15==14)
				System.out.println();
			i++;
		}
		System.out.println("\n\n-----( ^_^ )/~~�ݰ�--( ^_^ )/~~�ݰ�--( ^_^ )/~~�ݰ�--( ^_^ )/~~�ݰ�--( ^_^ )/~~�ݰ�--( ^_^ )/~~�ݰ�--------------------------------------------------------------");
	}
	
	public static void main(String[] args) {
		LinkedListDemo12 lld = new LinkedListDemo12();
		lld.linkTest1(lld.input1());
	}
}

/*linkedList �ײ�˫������ʵ�֣���ɾЧ�ʸߣ���ѯЧ�ʵ�
 * arrayList �ײ�����ʵ��    ����ɾЧ�ʵͣ���ѯЧ�ʸߣ����������̲߳���ȫ*/

/*ArrayList��LinkedList�������ϸ� ����ȱ�㣬���и��������õĵط����ܵ�˵�������������£�����
1����ArrayList��LinkedList���ԣ����б�ĩβ����һ��Ԫ�������Ŀ������ǹ̶��ġ�
   �� ArrayList���ԣ���Ҫ�����ڲ�����������һ�ָ������ӵ�Ԫ�أ�ż�����ܻᵼ�¶��������½��з��䣻
   ����LinkedList���ԣ����������ͳһ�ģ�����һ���ڲ�Entry���󡣡���
2����ArrayList�� �м�����ɾ��һ��Ԫ����ζ������б���ʣ���Ԫ�ض��ᱻ�ƶ���
   ����LinkedList���м�����ɾ��һ��Ԫ�صĿ����ǹ̶��ġ�����
3��LinkedList�� ֧�ָ�Ч�����Ԫ�ط��ʡ�����
4��ArrayList�Ŀ� ���˷���Ҫ��������list�б�Ľ�βԤ��һ���������ռ䣬��LinkedList�Ŀռ仨��������������ÿһ��Ԫ�ض���Ҫ�����൱�Ŀռ䡡��
  ��������˵��
  ����������һ�����ݵĺ���������ݶ�������ǰ����м�,������Ҫ����ط������е�Ԫ��ʱ,ʹ��ArrayList���ṩ�ȽϺõ����ܣ�
  ����Ĳ�������һ�����ݵ�ǰ����м���ӻ�ɾ������,���Ұ���˳��������е�Ԫ��ʱ,��Ӧ��ʹ��LinkedList�ˡ�*/
