class BreadPlate {
    private int breadCount = 0;

    public BreadPlate(){

    }

    /**
     * 스레드 동기화 중 협력관계 처리작업 : wait() notify()
     * 스레드 간 협력 작업 강화
     */
    public synchronized void makeBread(){
        if (breadCount >= 10){
            try {
                System.out.println("빵 생산 초과");
                wait();    // Thread를 Not Runnable 상태로 전환
            } catch (Exception e) {

            }
        }
        breadCount++;    // 빵 생산
        System.out.println("빵을 만듦. 총 " + breadCount + "개");
        notify();    // Thread를 Runnable 상태로 전환

      // 알아보기 쉽게하기 위해 10개가 넘어도 생산되기 함.
    }

    public synchronized void eatBread(){
        if (breadCount < 1){
            try {
                System.out.println("빵이 없어 기다림");
                wait();
            } catch (Exception e) {

            }
        }
        breadCount--;
        System.out.println("빵을 먹음. 총 " + breadCount + "개");
        notify();

      // 알아보기 쉽게하기 위해 빵이 없어도 먹을수 있게 함.
    }
}

class BreadMaker extends Thread {
    private BreadPlate plate;    // 공유될 빵접시

    public BreadMaker(BreadPlate plate){
        this.plate = plate;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            plate.makeBread();
        }
    }
}

class BreadEater extends Thread {
    private BreadPlate plate;

    public BreadEater(BreadPlate plate){
        this.plate = plate;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            plate.eatBread();
        }
    }
}

public class BreadMain {
    public static void main(String[] args) {
        BreadPlate breadPlate = new BreadPlate();
        BreadMaker maker = new BreadMaker(breadPlate);
        BreadEater eater = new BreadEater(breadPlate);

        maker.setPriority(10);
        maker.start();
        eater.start();
    }
}