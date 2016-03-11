package my2013.my2013080510;

public class ThreadThread0808 extends Thread{

	int count = 10;
	@Override
	public void run() {
//		System.out.println("#" +Thread.currentThread().getName()+" got from 10");
		while(count>0){
			System.out.println("#"+ThreadThread0808.currentThread().getName()+" : "+count--);
		}
//		System.out.println("#"+this.getName()+" �� is exit "+count);//����ʹ��Thread.currentThread()������ֱ��ʹ��this�����ɻ�õ�ǰ�߳�
	}
	
	public static void main(String[] args) {
		ThreadThread0808 tt1 = new ThreadThread0808();
		ThreadThread0808 tt2 = new ThreadThread0808();
//		Thread thread1 = new Thread(tt1);
//		Thread thread2 = new Thread(tt2);
		tt1.start();
		tt2.start();
		
	}
}
