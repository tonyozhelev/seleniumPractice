package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils
{
    /**
     * method for extracting data from csv file.
     * @param filename name of file
     * @param delimiter delimiter of file
     * @return String[][] - first dimention - rows of file, second dimension - elements in each row
     * @throws IOException thrown if file is invalid
     */
    public static String[][] getTestData(String filename, String delimiter) throws IOException {
        List<String[]> records = new ArrayList<>();
        String record;

        BufferedReader file = new BufferedReader(new FileReader("src\\main\\resources\\dataFiles\\" + filename));
        record = file.readLine();
        while (record != null) {
            String[] fields = record.split(delimiter);
            records.add(fields);
            record = file.readLine();
        }

        file.close();

        return records.toArray(new String[records.size()][]);
    }

    /**
     * method for extracting data from csv file.
     * @param filename name of file
     * @return String[][] - first dimention - rows of file, second dimension - elements in each row
     * @throws IOException thrown if file is invalid
     */
    public static String[][] getTestData(String filename) throws IOException {
        return getTestData(filename,",");
    }
}
