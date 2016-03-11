package my2013.my2013080510;

public class ThreadTicketR0808 implements Runnable{

	int ticket = 100;
	@Override
	public void run() {
//		for (this.ticket=10; this.ticket >0; ticket--) {
//			System.out.println("\t"+Thread.currentThread().getName()+": "+this.ticket+ " ticket leaves");
//		}
		for (int i = 0; i < 100; i++) {
			if(ticket>0){
				System.out.println("\t"+Thread.currentThread().getName()+": "+ticket--+ " ticket leaves");
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadTicketR0808 ttr = new ThreadTicketR0808();
		new Thread(ttr).start();
		new Thread(ttr).start();
		new Thread(ttr).start();
	}
}

//		System.out.println(Thread.currentThread().getName()+" now has ten ticket: ");
//		System.out.println(Thread.currentThread().getName()+": "+ "ticket beybey~~");