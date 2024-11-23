package it.unibo.mvc;

import java.awt.List;
import java.util.Collection;

/**
 *
 */
public interface Controller {

    void setString(String newString);

    String geString();

    Collection<String> getHistory();

    void printString();
}
