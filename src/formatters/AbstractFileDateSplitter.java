package formatters;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractFileDateSplitter {

    private final SimpleDateFormat inputDateFormat;
    private final SimpleDateFormat outputDateFormat;
    private final File inputFile;
    private final File outputFile;

    public AbstractFileDateSplitter(SimpleDateFormat inputDateFormat, SimpleDateFormat outputDateFormat, File inputFile, File outputFile) {
        this.inputDateFormat = inputDateFormat;
        this.outputDateFormat = outputDateFormat;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public SimpleDateFormat getInputDateFormat() {
        return inputDateFormat;
    }

    public SimpleDateFormat getOutputDateFormat() {
        return outputDateFormat;
    }

    public void rewriteDates() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line = reader.readLine();
            while (line != null) {
                String[] dates = line.split(" ");
                Date date = getInputDateFormat().parse(dates[0]);
                Date endDate = getInputDateFormat().parse(dates[1]);
                StringBuilder output = new StringBuilder();
                while (date.before(endDate) || date.equals(endDate)) {
                    output.append(getOutputDateFormat().format(date)).append("\n");
                    date = addTime(date);
                }
                writer.write(output.toString());
                line = reader.readLine();
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    abstract Date addTime(Date date) throws ParseException;
}
