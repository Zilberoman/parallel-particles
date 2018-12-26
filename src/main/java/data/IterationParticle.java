package data;

public class IterationParticle extends Particle {
    private final long iterations;

    IterationParticle(double p, long iterations) {
        super(p);
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            move();
        }
    }
}
