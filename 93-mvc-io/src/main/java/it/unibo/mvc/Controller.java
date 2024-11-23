package it.unibo.mvc;

import java.util.Collection;

/**
 *
 */
public interface Controller {

    /**
     * sets the next string to be printed.
     * @param newString the string to be set
     */
    void setString(String newString);

    /**
     * returns the string to be printed.
     * @return the next string to be printed
     */
    String getString();

    /**
     * returns a collection of written strings.
     * @return collection of the written strings
     */
    Collection<String> getHistory();

    /**
     * prints  a string in the stdo.
     */
    void printString();
}
