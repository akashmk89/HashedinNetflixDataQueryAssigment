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
            if (count == 0) {
                count++;
                continue;
            }
            String[] token = dataRow.split(delimiter);
            Set<String> directors = new HashSet<String>(Arrays.asList(token[3].split(",")));
            Set<String> casts = new HashSet<String>(Arrays.asList(token[4].replaceAll("\"","").split(",")));
            Set<String> countries = new HashSet<String>(Arrays.asList(token[5].split(",")));
            Set<String> genres = new HashSet<String>(Arrays.asList(token[10].replaceAll("\"","").split(",")));
            NetflixShow show = new NetflixShow(token[0], token[1], token[2], directors, casts, countries,this.getDate(token[6]), 5 , token[8], token[9], genres, token[11]);
            netflixShows.add(show);
        }
        System.out.println("There are total of " +netflixShows.size() + " records in Netflix database");
        return  netflixShows;
    }

    public Date getDate(String token) throws ParseException{
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        date = token.isEmpty()? null: format.parse(token.replaceAll("\"","").trim());
        return date;
       }
    }

