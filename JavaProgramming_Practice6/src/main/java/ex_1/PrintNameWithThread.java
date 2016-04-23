package ex_1;


public class PrintNameWithThread extends Thread {

    public PrintNameWithThread() {
        super();
        start();
    }

    @Override
    public void run() {
        System.out.println("Наследуясь от класса Thread");
        double d = 0;
        for (int i = 0; i < 10; i++) {
            d = d + 0.5;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Поток созданный наследуясь от класса Thread " + Thread.currentThread().getName() + " (" + d + " sec" + ")");
        }
    }
}
