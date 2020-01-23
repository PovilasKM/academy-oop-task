import formatters.AbstractFileDateSplitter;
import formatters.DailyFileDateSplitter;
import formatters.HourlyFileDateSplitter;

import java.io.*;

public class Launcher {

    public static void main(String[] args) {
        File inputFile = new File("resources/dates.txt");
        File outputFile = new File("resources/output.txt");
        AbstractFileDateSplitter splitter = new HourlyFileDateSplitter(inputFile, outputFile);
        splitter.rewriteDates();
//        AbstractFileDateSplitter splitter = new DailyFileDateSplitter(inputFile, outputFile);
//        splitter.rewriteDates();
    }
}
