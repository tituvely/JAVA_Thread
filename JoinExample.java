class SumThread extends Thread{
	private long sum;

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	public void run() {
		for(int i =1; i<=100; i++) {
			sum+=i;
		}
	}
	
	@Override
	public String toString() {
		return "SumThread [sum=" + sum + "]";
	}
}

public class JoinExample {
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try {
			sumThread.join();//현재 스레드 기준 (이부분을 주석처리해서 결과를 비교해보세요)
		} catch (Exception e) {
		}
		System.out.println("1~100 합 : "+sumThread.getSum());
	}
}