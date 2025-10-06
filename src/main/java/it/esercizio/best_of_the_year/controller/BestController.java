package it.esercizio.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.esercizio.best_of_the_year.model.Movie;
import it.esercizio.best_of_the_year.model.Song;


@Controller

public class BestController {

    String authorName = "Luca Mainardi";

    @GetMapping("/")
    public String home(Model model) {
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
        model.addAttribute("authorName", authorName);
        return "movies";
    }

    @GetMapping("/songs")
    public String getSongs(Model model) {
        model.addAttribute("songs", getBestSongs());
        model.addAttribute("authorName", authorName);
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(@PathVariable (name = "id") int param, Model model){
        model.addAttribute("authorName", authorName);
        Movie selectedMovie = null;

        for(Movie m : getBestMovies()){
            if (m.getId() == param){
                selectedMovie = m;
            }
        }

        if (param <= 0 || param > getBestMovies().size()) {
            model.addAttribute("error", "Film non trovato");
        } else {
            model.addAttribute("movie", selectedMovie);
        }

        return "movie_details"; 
    }

    @GetMapping("/songs/{id}")
    public String getSongById(@PathVariable (name = "id") int param, Model model){
        model.addAttribute("authorName", authorName);
        Song selectedSong = null;

        for(Song s : getBestSongs()){
            if(s.getId() == param)
            selectedSong = s;
        }

        if(param <= 0 || param > getBestSongs().size()) {
            model.addAttribute("error", "Canzone non trovata");
        } else {
            model.addAttribute("song", selectedSong);
        }

        return "song_details";
    }
    
}
