package it.unibo.mvc;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String nexString;
    private final Collection<String> historyString = new LinkedList<>();

    /**
     * constructor for the Simple controller: sets the String to be printed to null.
     */
    public SimpleController() {
        this.nexString = null;
    }

    @Override
    public String getString() {
        return this.nexString;
    }

    @Override
    public Collection<String> getHistory() {
        return List.copyOf(historyString);
    }

    @Override
    public void printString() {
        if (Objects.nonNull(this.nexString)) {
            System.out.println(this.nexString); // NOPMD: required by the excercise
            this.historyString.add(nexString);
        } else {
            throw new IllegalStateException("the string is not set");
        }
    }

    @Override
    public void setString(final String newString) {
        this.nexString = Objects.requireNonNull(newString);
    }
}
