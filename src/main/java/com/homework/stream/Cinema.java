package com.homework.stream;

import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

public class Cinema {
    @SneakyThrows
    public static void main(String[] args) {
        String url = "https://www.omdbapi.com/?s=spider&apikey=c0bf5d80";
        ObjectMapper mapper = new ObjectMapper();
        Movie movie = mapper.readValue(new URL(url), Movie.class);
    }
}

@Getter
@Setter
class Movie {
    private String Title;
    private String Year;
    private String imdbID;
    private String Type;
    private String Poster;
}
