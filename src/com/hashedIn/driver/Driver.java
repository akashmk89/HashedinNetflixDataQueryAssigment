package com.hashedIn.driver;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.hashedIn.domain.NetflixShow;
import com.hashedIn.utility.CsvReader;
import com.hashedIn.filter.FilterData;

public class Driver {
    public static void main(String[] args) throws IOException,ParseException {
        String DEFAULT_DATE = "dd-MM-yyyy";
        CsvReader csvReader = new CsvReader();
        FilterData filterData = new FilterData();
        // Read Date only once from the CSV and always refer to the same data
        List<NetflixShow> movies = csvReader.readCSVAndGetRecords();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many records do you want to fetch?");
        int n = sc.nextInt();
        System.out.println("Enter from date in the format: \"dd-mm-yyyy\"");
        String date = sc.next();
        Date fromDate = !date.equals("") ? new SimpleDateFormat(DEFAULT_DATE).parse(date) : null;
        System.out.println("Enter to date in the format: \"dd-mm-yyyy\"");
        String date2 = sc.next();
        Date toDate = !date2.equals("") ? new SimpleDateFormat(DEFAULT_DATE).parse(date2) : null;
        while (true) {
            System.out.println("1. List the first n records where type: TV Show.");
            System.out.println("2. List the first n records where listed_in: Horror Movies");
            System.out.println("3. List the first n type: Movie where country: India");
            System.out.println("4. Exit from the Application");
            System.out.println("Please select valid option 1 or 2 or 3 or 4");
            Scanner s = new Scanner(System.in);
            int option = s.nextInt();
            switch (option) {
                case 1:
                    filterData.listNRecordsByType(movies, n, "TV Show", fromDate, toDate);
                    continue;
                case 2:
                    filterData.listNRecordsInHorrorMovies(movies, n,"Horror Movies", fromDate, toDate);
                    continue;
                case  3:
                    filterData.listNRecordsByTypeAndCountry(movies,n,"India","Movie", fromDate,toDate);
                    continue;
                case 4: System.out.println("Thanks for using the application");
                    System.exit(0);

                default: System.out.println("Invalid Choice, Application closing");
                    System.exit(0);

            }
        }
    }
}