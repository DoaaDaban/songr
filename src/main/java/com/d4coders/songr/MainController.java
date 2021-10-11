package com.d4coders.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class MainController{

    @Autowired
    private AlbumRepository albumRepository;


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

    @GetMapping("/getalbums")
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


    @PostMapping("/albums")
    public RedirectView addAlbum(@RequestParam(value = "title") String title ,
                                 @RequestParam(value= "artist") String artist,
                                 @RequestParam(value="songCount") int songCount,
                                 @RequestParam(value="imageUrl") String imageUrl,
                                 @RequestParam(value="length") long length) {
        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return  new RedirectView("/albums");
    }

    @GetMapping("/albums")
    String getAlbum(Model album) {
        album.addAttribute("album" , albumRepository.findAll());
        return "albums";
    }


    @GetMapping("/addalbum")
    String addAlbum() {
        return "addAlbum";
    }

}
