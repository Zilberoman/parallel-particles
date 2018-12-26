import data.Diamond;
import modes.Mode;
import modes.NoSuchModeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter diamond's size");
        int size = scanner.nextInt();

        System.out.println("Please choose mode: Iteration = I, Continuous = C");

        try {
            int mode = new Mode().getValue(scanner.next());
            Diamond diamond = new Diamond(size, mode);
            run(diamond);
        } catch (NoSuchModeException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void run(Diamond diamond) {
        List<Thread> threads = init(diamond);
        threads.forEach(Thread::start);
    }

    private static List<Thread> init(Diamond diamond) {
        List<Thread> threads = new ArrayList<>(diamond.getParticles().size());
        diamond.getParticles().forEach(particle -> threads.add(new Thread(particle)));
        return threads;
    }
}
