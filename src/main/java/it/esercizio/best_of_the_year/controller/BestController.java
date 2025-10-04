package it.esercizio.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.esercizio.best_of_the_year.model.Movie;
import it.esercizio.best_of_the_year.model.Song;


@Controller

public class BestController {

    @GetMapping("/")
    public String home(Model model) {
       String authorName = "Luca Mainardi";
       model.addAttribute("authorName", authorName);
       return "index";  
    }

    private List<Movie> getBestMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "A"));
        movies.add(new Movie(2, "B"));
        movies.add(new Movie(3, "C"));
        return movies;
    }

   private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "X"));
        songs.add(new Song(2, "Y"));
        songs.add(new Song(3, "Z"));
        return songs;
   }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        model.addAttribute("movies", getBestMovies());
        return "index";
    }

    @GetMapping("/songs")
    public String getSongs(Model model) {
        model.addAttribute("songs", getBestSongs());
        return "index";
    }
   
}
