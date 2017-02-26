package framework;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Marina on 26.02.2017.
 */
public class DataProviders {

    @DataProvider
    //для чтения параметров из файла
    public static Iterator<Object[]> setTypeOfBrowser() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(DataProviders.class.getResourceAsStream("/typeOfBrowser.data")));
        List<Object[]> fileData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            fileData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return fileData.iterator();
    }
}
