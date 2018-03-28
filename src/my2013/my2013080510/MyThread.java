package my2013.my2013080510;

class MyThread implements Runnable {

	public void run() {
		int ticket = 10;
		for (int i = 0; i < 20; i++) {
//			if (this.ticket > 0) {
				System.out.println("\t#"+Thread.currentThread().getName()+ "卖票：ticket " + ticket--);
//			}
		}
	}

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		new Thread(mt).start();//同一个mt，但是在Thread中就不可以，如果用同一  
		new Thread(mt).start();//个实例化对象mt，就会出现异常  
		new Thread(mt).start();
	}
}
