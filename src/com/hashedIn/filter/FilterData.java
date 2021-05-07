package com.hashedIn.filter;

import java.util.Date;
import java.util.List;
import com.hashedIn.domain.NetflixShow;

public class FilterData {


    public void listNRecordsByType(List<NetflixShow> shows , int n, String type, Date fromDate, Date toDate){
        long startTime = System.currentTimeMillis();
        shows.stream()
                .filter(x -> x.getDateAdded() !=null)
                .filter(x -> x.getType().equals(type)).limit(n)
                .filter(x-> x.getDateAdded().after(fromDate) && x.getDateAdded().before(toDate))
                .forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken in MillSeconds = " + (endTime - startTime));
    }

    public void listNRecordsInHorrorMovies(List<NetflixShow> movies, int n, String genre, Date fromDate, Date toDate){
        long startTime = System.currentTimeMillis();
        movies.stream()
                .filter(x -> x.getDateAdded() !=null)
                .filter(x -> x.getGenres().contains(genre)).limit(n)
                .filter(x-> x.getDateAdded().after(fromDate) && x.getDateAdded().before(toDate))
                .forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken in MillSeconds = " + (endTime - startTime));
    }

    public void listNRecordsByTypeAndCountry(List<NetflixShow> shows, int n, String country, String type, Date fromDate, Date toDate){
        long startTime = System.currentTimeMillis();
        shows.stream()
                .filter(x -> x.getDateAdded() !=null)
                .filter(x -> x.getDateAdded().after(fromDate) && x.getDateAdded().before(toDate))
                .filter(x -> x.getCountries().contains("India"))
                .filter(x -> x.getType().equals("Movie"))
                .limit(n)
                .forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken in MillSeconds = " + (endTime - startTime));
    }
}
