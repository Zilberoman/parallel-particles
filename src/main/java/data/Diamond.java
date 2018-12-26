package data;

import modes.NoSuchModeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Diamond {
    private final int size;
    private final List<Particle> particles;
    private volatile int[] particlePositions;

    public Diamond(int size, int mode) throws NoSuchModeException {
        this.size = size;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of particles");
        int quantity = scanner.nextInt();
        System.out.println("Probability?");
        double p = scanner.nextDouble();

        switch (mode) {
            case 0: {
                this.particles = initContinues(quantity, p);
                break;
            }
            case 1: {
                this.particles = initIterations(quantity, p);
                break;
            }
            default: {
                throw new NoSuchModeException();
            }
        }

        particlePositions = new int[size];

        for (int i = 1; i < size; i++) {
            particlePositions[i] = 0;
        }

        particlePositions[0] = particles.size();
    }

    private List<Particle> initContinues (int quantity, double p) {
        List<Particle> particles = new ArrayList<>(quantity);
        System.out.println("Please enter execution and delay time");
        Scanner scanner = new Scanner(System.in);
        long time = scanner.nextLong();
        long delay = scanner.nextLong();
        for (int i = 0; i < quantity; i++) {
            Particle particle  = new ContinuesParticle(p, time, delay);
            particle.setDiamond(this);
            particles.add(particle);
        }
        return particles;
    }

    private List<Particle> initIterations(int quantity, double p) {
        List<Particle> particles = new ArrayList<>(quantity);
        System.out.println("Please enter the number of iterations");
        long iterations = new Scanner(System.in).nextLong();

        for (int i = 0; i < quantity; i++) {
            Particle particle = new IterationParticle(p,iterations);
            particle.setDiamond(this);
            particles.add(particle);
        }
        return particles;
    }

    synchronized void moveForwardParticle(boolean moveForward, int fromPos) {
        particlePositions[fromPos]--;
        fromPos = moveForward ? fromPos + 1 : fromPos - 1;
        particlePositions[fromPos]++;
        System.out.println(Arrays.toString(particlePositions));
    }

    int getSize() {
        return size;
    }

    public List<Particle> getParticles() {
        return particles;
    }
}
