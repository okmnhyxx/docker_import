package my2013.my2013080510;

public class ThreadTicketT0808 extends Thread{
	
//	static int i = 0;
//	String name;
//	public ThreadTicketR0808(){
//		String names[] = {"process aaa","process bbb","process ccc"};
//		this.name = names[i++];
//	}
//	
	String name = "";
	int ticket = 10;
	public ThreadTicketT0808(String name){
		this.name = name;
	}
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			if(ticket>0){
				System.out.println("\t"+Thread.currentThread().getName()+": "+ticket--+ " ticket leaves");
			}
		}
	}
	
	public static void main(String[] args) {
		new ThreadTicketT0808("process aaa").start();
		new ThreadTicketT0808("process bbb").start();
		new ThreadTicketT0808("process ccc").start();
	}
	

}

//System.out.println("now has ten ticket: ");
//		System.out.println("  "+this.name+": "+ "ticket beybey~~");