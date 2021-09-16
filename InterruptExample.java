class PrintThread2 extends Thread{
	public void run() {
		try {
			while(true) {
				System.out.println("실행 중");
				Thread.sleep(1);
				// if(Thread.interrupted()) {
				//if(Thread.currentThread().isInterrupted()) {
					// break;
				// }
            }
		} catch (InterruptedException e) {
			System.out.println("interrupt() 실행");
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}

//메인 스레드
public class InterruptExample {
	public static void main(String[] args) {
		Thread thread = new PrintThread2();
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			
		}
		thread.interrupt();
	}
}