package Item2;

/**
 * Created by Abashkin Aleksandr on 07.03.2016.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Deadlock Example...Threads are running, waiting...");
        ThreadInteraction threadInteraction = new ThreadInteraction();
        System.out.println(threadInteraction.DeadlockExample());
    }
}
