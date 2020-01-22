import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Launcher {

    public static void main(String[] args) {
        File inputFile = new File("resources/dates.txt");
        File outputFile = new File("resources/output.txt");
        //getHoursBetweenDates(inputFile, outputFile);
        getDaysBetweenDates(inputFile, outputFile);
    }

    public static void getHoursBetweenDates(File inputFile, File outputFile) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line = reader.readLine();
            while (line != null) {
                String[] dates = line.split(" ");
                Date date = inputDateFormat.parse(dates[0]);
                Date endDate = inputDateFormat.parse(dates[1]);
                while (date.before(endDate) || date.equals(endDate)) {
                    writer.write(outputDateFormat.format(date) + "\n");
                    date = addHour(date);
                }
                line = reader.readLine();
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Date addHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        return calendar.getTime();
    }

    public static void getDaysBetweenDates(File inputFile, File outputFile) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line = reader.readLine();
            while (line != null) {
                String[] dates = line.split(" ");
                Date date = inputDateFormat.parse(dates[0]);
                Date endDate = inputDateFormat.parse(dates[1]);
                while (date.before(endDate) || date.equals(endDate)) {
                    writer.write(outputDateFormat.format(date) + "\n");
                    date = addDays(date);
                }
                line = reader.readLine();
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Date addDays(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }
}
