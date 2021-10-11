package com.d4coders.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class MainController{

    //   http://localhost:8080/hello
    @GetMapping("/hello")
    String helloWorld(){
        return "hello";
    }

    //   http://localhost:8080/capitalize/hello
    @GetMapping("/capitalize/{word}")
    public String showCapital(Model m, @PathVariable("word") String word){
        m.addAttribute("word", word);
        return "HelloWorld";
    }

    @GetMapping("/albums")
    public String albums( Model model) {
        ArrayList<Album> albums= new ArrayList<>();
        Album IWantIThatAway = new Album("I want it that away", "BackStreet Boys", 4, 960, "https://media.glamour.com/photos/5e822ed3449002000841f2a5/master/pass/GettyImages-1176081636.jpg");
        Album Home = new Album("Home", "Noel", 9, 2160, "https://i1.sndcdn.com/artworks-Ws4ZSszUOHW4xmX3-Hvee7Q-t500x500.jpg");
        Album algharamAlmostaheel = new Album("Algharam Almostaheel", "Wael Kfoury", 8, 1920, "https://i.ytimg.com/vi/NuPfJDRkW-E/hqdefault.jpg");
        albums.add(IWantIThatAway);
        albums.add(Home);
        albums.add(algharamAlmostaheel);
        model.addAttribute("album", albums);
        return "album";
    }
}
