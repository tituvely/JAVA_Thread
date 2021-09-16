class Bank {
    private int money = 10000;    // 공유될 자원

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public synchronized void saveMoney(int save){    // 입금
        int m = money;
        try{
            Thread.sleep(2000);    // 지연시간 2초
        } catch (Exception e){

        }
        money = m + save;
        System.out.println("입금 처리");

    }

    public synchronized void minusMoney(int minus){    // 출금
        int m = money;
        try{
            Thread.sleep(3000);    // 지연시간 3초
        } catch (Exception e){

        }
        money = m - minus;
        System.out.println("출금 완료");
    }
}

class Park extends Thread {
    @Override
    public void run() {
        BankMain.myBank.saveMoney(5000);
        System.out.println("남편 예금 후 잔고 확인: " + BankMain.myBank.getMoney());
    }
}

class ParkWife extends Thread {
    @Override
    public void run() {
        BankMain.myBank.minusMoney(2000);
        System.out.println("아내 출금 후 잔고 확인: " + BankMain.myBank.getMoney());
    }
}

public class BankMain {
    public static Bank myBank = new Bank();

    public static void main(String[] args) throws Exception{
        System.out.println("원금 : " + myBank.getMoney());

        Park park = new Park();
        ParkWife wife = new ParkWife();

        park.setPriority(10);
        park.start();
        wife.start();

        park.join();
        wife.join();

        System.out.println("은행 작업 종료");

    }
}