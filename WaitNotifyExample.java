//공유객체
class WorkObject {
	public synchronized void methodA() {
		System.out.println("ThreadA의 methodA() 작업 실행");
		notify(); //일시정지 상태에 있는 ThreadB를 실행대기 상태로 만듬.
		try {
			wait();//ThreadA를 일시정지 상태로 만듬.
		} catch (Exception e) {
		}
	}
	
	public synchronized void methodB() {
		System.out.println("ThreadB의 methodB() 작업 실행");
		notify(); //일시정지 상태에 있는 ThreadA를 실행대기 상태로 만듬.
		try {
			wait();//ThreadB를 일시정지 상태로 만듬.
		} catch (Exception e) {
		}
	}
}

//Thread A
class ThreadA extends Thread{
	private WorkObject workObject;
	
	public ThreadA(WorkObject workObject) {
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for(int i =0; i<10; i++) {
			workObject.methodA();
		}
	}
}

//ThreadB
class ThreadB extends Thread{
	private WorkObject workObject;
	
	public ThreadB(WorkObject workObject) {
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for(int i =0; i<10; i++) {
			workObject.methodB();
		}
	}
}

//main 스레드
public class WaitNotifyExample {
	public static void main(String[] args) {
		WorkObject shareObject = new WorkObject(); //공유객체 생성
		
		ThreadA threadA = new ThreadA(shareObject);
		ThreadB threadB = new ThreadB(shareObject);//ThreadA와 ThreadB 생성
		
		threadA.start();
		threadB.start();

        return;
	}
}