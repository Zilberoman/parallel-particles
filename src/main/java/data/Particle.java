package data;

import randomization.Bernoulli;

public abstract class Particle implements Runnable {
    private final Bernoulli bernoulli;
    private Diamond diamond;
    private int position;

    Particle(double p) {
        this.bernoulli = new Bernoulli(p);
    }

    void move() {
        moveForward(bernoulli.next() ? position < diamond.getSize() - 1 : position == 0);
    }

    private void moveForward(boolean move) {
        diamond.moveForwardParticle(move, position);
        position = move ? position + 1 : position - 1;
    }

    void setDiamond(Diamond diamond) {
        this.diamond = diamond;
    }

    public abstract void run();
}
