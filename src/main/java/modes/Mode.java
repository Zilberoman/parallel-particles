package modes;

import java.util.HashSet;
import java.util.Set;

public class Mode {
    private Set<String> iteration;
    private Set<String> continues;

    public Mode() {
        iteration = new HashSet<>();
        continues = new HashSet<>();

        continues.add("CONTINUES");
        continues.add("C");
        iteration.add("ITERATION");
        iteration.add("I");
    }

    public int getValue(String value) throws NoSuchModeException {
        if (iteration.contains(value.toUpperCase())) {
            return 0;
        }

        if (continues.contains(value.toUpperCase())) {
            return 1;
        }

        throw new NoSuchModeException();
    }
}
