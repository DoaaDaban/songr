package com.d4coders.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;


    @GetMapping("/songs")
    public String getAllSongs(Model song){

        List<Song> songs = songRepository.findAll();
        song.addAttribute("songs",songs);
        return "songs";
    }

    @GetMapping("/addSong")
    public String getAddSong(){
        return "addedSongs";
    }

    @PostMapping("/songs")
    public RedirectView addSong(@RequestParam(value = "title") String title ,
                                @RequestParam(value="length") int length,
                                @RequestParam(value= "trackNumber") int trackNumber,
                                @RequestParam(value="albumID") long albumID, Model song){
        try{
            Album album = albumRepository.findById(albumID).get();
            Song songs = new Song(title,length,trackNumber,album);
            songRepository.save(songs);
            Album newAlbum = albumRepository.findById(album.getId()).get();
            song.addAttribute("songs", newAlbum.getSongs());
            return  new RedirectView("/songs");
        }catch(Exception e){
            return new RedirectView("/error");
        }

    }

}

