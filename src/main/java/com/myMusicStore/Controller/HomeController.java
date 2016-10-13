package com.myMusicStore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by root on 10/13/16.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }
}
