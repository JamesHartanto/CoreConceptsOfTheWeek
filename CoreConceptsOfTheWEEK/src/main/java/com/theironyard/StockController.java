package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JamesHartanto on 4/18/17.
 */
@Controller
public class StockController {

    // Home page - login details (helps keep a list of stocks previously seen??)
    @RequestMapping("/")
    public String homePage(){
        return "index";
    }

    // Stock list - gives the list of stocks in the database
    @RequestMapping("/stockList")
    public String stockList(){
        return "stockList";
    }

    // Find a stock - find a particular stock in the database (check if it matches a name OR code)
    @RequestMapping("/findStock")
    public String findStock(Model model, String search){
        model.addAttribute("search",search);
        return "findStock";
    }

    // Compare stocks
    @RequestMapping("/compareStock")
    public String compareStock(){
        return "compareStock";
    }



}
