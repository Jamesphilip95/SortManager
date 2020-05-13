package com.sparta.jp.Manager;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



/**
 * Hello world!
 */
public class Starter {

    static final String LOG_PROPERTIES_FILE = "SortManager/src/main/resources/log4j.properties";
    static Logger log = Logger.getLogger(Starter.class.getName());

    public static void main(String[] args) {

        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        int[] unsortedArray = {23, 2, 1, 34, 66, 22, 6, 434,46,23,45,27,345,234,776,3677,324,3,8,9,34,396,739,55593};
        SortManager sortManager = new SortManager();
        sortManager.runSorter(unsortedArray);
    }

}

