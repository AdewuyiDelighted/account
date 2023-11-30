package account;

public class MultiThread extends Thread {
    @Override
    public void run() {
        for (int index = 0; index < 25; index++) {
            System.out.print("=");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();

    }
}
