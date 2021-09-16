class Sum{

    int num=0;

    synchronized int sum(){

        for(int i=0;i<1000;i++) { num+=1; }

        return num;
    }
}

class ThreadEX implements Runnable{

    Sum s = new Sum();

    public void run() {
        String threadName = Thread.currentThread().getName(); //쓰레드 이름 받아오기
        System.out.println(threadName+" : "+s.sum());
    }
}

public class MethodSync {

    public static void main(String[] args) {

        ThreadEX r = new ThreadEX();

        Thread ex1 = new Thread(r,"a"); //첫번째 쓰레드 객체 생성 쓰레드 이름은 a
        Thread ex2 = new Thread(r,"b"); //두번째 쓰레드 객체 생성 쓰레드 이름은 b

        //멀티 쓰레드 시작
        ex1.start(); 
        ex2.start();
    }
}