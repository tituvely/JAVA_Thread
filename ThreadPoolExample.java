import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) throws Exception{
		ExecutorService executorService = Executors.newFixedThreadPool(2); //최대스레드 개수가 2인 스레드풀 생성
        // ExecutorService executorService = Executors.newCachedThreadPool();

        // ExecutorService executorService2 = Executors.newFixedThreadPool(
        //     Runtime.getRuntime().availableProcessors();
        // ); //cpu의 코어수만큼 최대스레드풀 생성
		
		for(int i =0; i<10; i++) {
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[총 스레드 개수 : "+poolSize+"] 작업 스레드 이름 :"+threadName);
					
					//예외 발생시킴
					int value = Integer.parseInt("삼");
				}
			};	
            //이 두개를 번갈아가면서 실행해보세요.
			// executorService.execute(runnable);
			executorService.submit(runnable);
			
			Thread.sleep(10);//콘솔 출력시간을 위해 0.01초 일시정지
		}
		executorService.shutdown();
	}
}