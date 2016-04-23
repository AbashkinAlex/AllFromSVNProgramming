package ex_1;


public class PrintNameWithRunnable implements Runnable {

    public PrintNameWithRunnable() {
        Thread th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        System.out.println("Реализуя интерфейс Runnable");
        double d = 0;
        for (int i = 0; i < 10; i++) {
            d = d + 0.5;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Поток созданный реализуя интерфейс Runnable " + Thread.currentThread().getName() + " (" + d + " sec" + ")");
        }
    }
}
