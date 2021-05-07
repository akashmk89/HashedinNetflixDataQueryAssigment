package com.hashedIn.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.hashedIn.domain.NetflixShow;

// Reads Data from the CSV file and Adds it to the collection
public class CsvReader {
       public List<NetflixShow> readCSVAndGetRecords() throws IOException, ParseException {
        String delimiter = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        List<NetflixShow> netflixShows = new ArrayList<NetflixShow>();
        int count = 0;
        String dataRow = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\netflix_titles.csv"));
        while ((dataRow = bufferedReader.readLine()) != null) {
            Date date;
            if (count == 0) {
                count++;
                continue;
            }
            String[] token = dataRow.split(delimiter);
            Set<String> director = new HashSet<String>(Arrays.asList(token[3].split(",")));
            Set<String> cast = new HashSet<String>(Arrays.asList(token[4].replaceAll("\"","").split(",")));
            Set<String> country = new HashSet<String>(Arrays.asList(token[5].split(",")));
            Set<String> listedIn = new HashSet<String>(Arrays.asList(token[10].replaceAll("\"","").split(",")));
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            date = token[6].isEmpty()? null: format.parse(token[6].replaceAll("\"","").trim());
            NetflixShow show = new NetflixShow(token[0], token[1], token[2], director, cast, country,date, 5 , token[8], token[9], listedIn, token[11]);
            netflixShows.add(show);
        }
        System.out.println("There are total of " +netflixShows.size() + " records in Netflix database");
        return  netflixShows;
    }
    }

