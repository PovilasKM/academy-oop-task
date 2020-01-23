package formatters;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HourlyFileDateSplitter extends AbstractFileDateSplitter {

    private static final SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    public HourlyFileDateSplitter(File inputFile, File outputFile) {
        super(inputDateFormat, outputDateFormat, inputFile, outputFile);
    }

    @Override
    Date addTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        return calendar.getTime();
    }
}
