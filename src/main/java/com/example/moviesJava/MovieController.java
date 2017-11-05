package com.example.moviesJava;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.util.List;


@Controller
public class MovieController {

    static final String MOVIE_URL = "https://api.themoviedb.org/3/movie/now_playing";
    static final String API_KEY = 



    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homeMovie(){
        return "home";
    }

    @RequestMapping(path = "/now-playing", method = RequestMethod.GET)
    public String nowPlaying(Model model){
        List<Movie> movies =
    }


}
