package pl.michalek.marcin.nfcdrinkerserver.utils;

/**
 * Created by Marcin on 2015-01-02.
 */

import java.util.List;


public class Util {

    public static <T> T getDrinkerFromList(List<T> list, T searchedElement) {
        for (T element : list) {
            if (element.equals(searchedElement)) {
                return element;
            }
        }
        return null;
    }
}
