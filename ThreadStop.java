public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            // 자원 선언
        
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 공유자원 정리
                // 해당 스레드에서 사용한 메모리 자원 정리(close 같은 작업들)
            }	
        });
        thread.start();
    
        System.out.println("MAIN: "+Thread.currentThread().getName());
        Thread.sleep(2000);
        thread.interrupt();
    }
}