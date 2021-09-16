import java.awt.Toolkit;

public class BeepProgram {
    public static void main(String[] args) {
        Thread thread = new BeepThread();

        thread.start();
        
        // Thread thread2 = new Thread() {
        //     @Override
        //     public void run() {
        //         Toolkit tookit = Toolkit.getDefaultToolkit();
        //         for(int i=0; i<5; i++) {
        //             tookit.beep();
        //             try {
        //                 Thread.sleep(500);
        //             }
        //             catch (Exception e) {}
        //         }
        //     }
        // };

        // thread2.start();

        for(int i=0; i<5; i++) {
            System.out.println("Ting");
            try {
                Thread.sleep(500);
            }
            catch (Exception e) {}
        }
    }
}

class BeepThread extends Thread{
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i =0; i<5; i++) {
			toolkit.beep();
			try {Thread.sleep(500);} catch(Exception e) {}
		}
	}
}