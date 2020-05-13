package com.sparta.jp.Manager;


import com.sparta.jp.display.Display;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;


public class SortFactory {

    public static Sorter getInstance() {
        Properties properties = new Properties();
        Display display = new Display();
        try {
            properties.load(new FileReader("src/main/resources/sort.properties"));
            String s = display.displayTerminalSortTypeRequest("src/main/java/com/sparta/jp/Sorters");
            String sorter = properties.getProperty(s);
            Class selectedSorter = Class.forName(sorter);

            return (Sorter) selectedSorter.getDeclaredConstructor().newInstance();
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
           Logger logger = Logger.getLogger(SortFactory.class.getName());
           logger.debug("Unable to create sorter object");
        }
        return null;
    }

}