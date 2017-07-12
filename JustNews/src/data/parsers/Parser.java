package data.parsers;


import data.entities.Root;

import java.io.IOException;

/**
 * Created by Diana on 29.06.2017.
 */
public abstract class Parser {
    public abstract Root parse(String fileName) throws IOException;
}
