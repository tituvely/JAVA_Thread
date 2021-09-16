import java.util.*;

public class ThreadGroupExample {
    public static void main(String[] args) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        System.out.println(group.getName());
            
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setName("AutoSaveThread");
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();
            
        //getAllStackTraces() : 프로세스 내에서 실행하는 모든 스레드에 대한 정보를 얻음.
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        Set<Thread> threads = map.keySet();
            
        for(Thread thread : threads) {
            System.out.println("Name : "+thread.getName() + ((thread.isDaemon()) ? "(데몬)":"(주)"));
            System.out.println("\t"+"소속그룹 : "+thread.getThreadGroup().getName());
            System.out.println();
        }
    }
}