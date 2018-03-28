package my2013.my2013080510;

public class ThreadRunnable0807 implements Runnable{

	static int count = 100;
	@Override
	public void run() {
//		System.out.println("#"+Thread.currentThread().getName()+"# got count from "+count);
		while(count>0){
			System.out.println("\t#"+Thread.currentThread().getName()+" : "+(count--));
		}
//		System.out.println("#"+Thread.currentThread().getName()+" is exit"+" : "+count);
	}
	
	public static void main(String[] args) {
		ThreadRunnable0807 tfr = new ThreadRunnable0807();
		Thread thread1 = new Thread(tfr);
		Thread thread2 = new Thread(tfr);
		thread1.start();
		thread2.start();
	}
}
