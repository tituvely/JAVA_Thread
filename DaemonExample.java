class AutoSaveThread extends Thread{
	public void save() {
		System.out.println("작업 내용을 저장함");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("1");//여기실행안됨. exception 발생은 아님
				e.printStackTrace();
				break;
			}
			save();
		}
	}
}

//메인 스레드
public class DaemonExample {
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
		System.out.println("메인 스레드 종료");
	}
}