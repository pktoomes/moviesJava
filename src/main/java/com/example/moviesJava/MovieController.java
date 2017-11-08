package com.example.moviesJava;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class MovieController {

    static final String MOVIE_URL = "https://api.themoviedb.org/3/movie";
    static final String API_KEY = "?api_key=be2a38521a7859c95e2d73c48786e4bb";
    static RestTemplate restTemplate = new RestTemplate();

    public static List<Movie> getMovies(String route){
        ResultsPage movieResults = restTemplate.getForObject(MOVIE_URL + "/now-playing" + API_KEY, ResultsPage.class);
        return movieResults.getResults();
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homeMovie(){
        return "home";
    }

    @RequestMapping(path = "/now-playing", method = RequestMethod.GET)
    public String nowPlaying(Model model){
        List<Movie> movies = getMovies(MOVIE_URL + "/now-playing" + API_KEY);
        model.addAttribute("movies",movies);
        return "now-playing";
    }
    @RequestMapping(path = "/medium-popular-long-name", method = RequestMethod.GET)
    public String mediumPopularLongName(Model model){
        List<Movie> movies = getMovies(MOVIE_URL+ "/medium-popular-long-name" + API_KEY);
        List<Movie> selctedMovies = movies.stream()
                .filter(movie -> movie.title.length()>=10 && movie.getPopularity() >=30 && movie.getPopularity()<=80)
                .collect(Collectors.toList());
        model.addAttribute("selctedMovies", selctedMovies);
        return "medium-popular-long-name";

    }


}
