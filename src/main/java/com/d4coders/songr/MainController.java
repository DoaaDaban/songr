package com.d4coders.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;


/**
 * `@Controller` tells spring to load this class as a controller and look for routes
 * `@RequestMapping` tells spring the path for the controller (prefix of the individual routes)
 */
@Controller
public class MainController {

    /**
     * GetMapping("/greeting") is a shortcut @RequestMapping(value = "/greeting", method = RequestMethod.GET)
     *
     * @return
     */
    //    http://localhost:8080/hello
    @GetMapping("/hello")
    String helloWorld(){
        return "hello";
    }

    //   http://localhost:8080/capitalize/hello?name=doaa
    @GetMapping("/capitalize/{id}")
    String hello(Model model, @PathVariable("id") String id) {
        id.toUpperCase();
        model.addAttribute("name",id.toUpperCase());
        return "HelloWorld";
    }


    @PostMapping("/albums")
    public RedirectView addAlbum(@RequestParam(value = "title") String title ,
                                 @RequestParam(value= "artist") String artist,
                                 @RequestParam(value="songCount") int songCount,
                                 @RequestParam(value="length") long length,
                                 @RequestParam(value="imageUrl") String imageUrl){
        return  new RedirectView("/albums");
    }


}
