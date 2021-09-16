public class PriorityExample {
	public static void main(String[] args) {
		for(int i =1; i<=10; i++) {
			Thread thread = new ClacThread("thread"+i);
			if(i == 10) {
				//가장 낮은 우선순위
				thread.setPriority(Thread.MAX_PRIORITY);
			}else {
				//가장 높은 우선순위
				thread.setPriority(Thread.MIN_PRIORITY);
			}
			thread.start();
		}
	}
}

class ClacThread extends Thread{
	public ClacThread(String name) {
		setName(name);
	}
	
	public void run() {
		for(int i =0; i<2000000000; i++) {}
		System.out.println(getName());
	}
}