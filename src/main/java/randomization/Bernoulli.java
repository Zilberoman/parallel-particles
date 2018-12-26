package randomization;

import java.util.Random;

public class Bernoulli {
    private final double p;
    private final Random random;

    public Bernoulli(double p) {
        this.p = p;
        random = new Random();
    }

    public boolean next() {
        double number = random.nextDouble();
        return !(number > p);
    }
}
