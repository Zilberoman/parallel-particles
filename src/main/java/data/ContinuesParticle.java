package data;

public class ContinuesParticle extends Particle {
    private final long time;
    private final long delay;

    ContinuesParticle(double p, long time, long delay) {
        super(p);
        this.time = time;
        this.delay = delay;
    }

    @Override
    public void run() {
        long begin = System.currentTimeMillis();

        while (System.currentTimeMillis() - begin < time) {
            move();

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
