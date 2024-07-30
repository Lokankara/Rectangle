package com.homework.stream;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class Cinema {
    @SneakyThrows
    public static void main(String[] args)  {
        String url = "https://www.omdbapi.com/?s=spider&apikey=c0bf5d80";
        ObjectMapper mapper = new ObjectMapper();
        Movie movie = mapper.readValue(new URL(url), Movie.class);
    }
}
class Movie {

    private String Title;
    private String Year;
    private String imdbID;
    private String Type;
    private String Poster;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}






