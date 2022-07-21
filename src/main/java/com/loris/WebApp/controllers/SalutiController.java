package com.loris.WebApp.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/saluti")
@CrossOrigin("http://localhost:4200")
public class SalutiController {

    @GetMapping()
    public String getSaluti2(){
        return "\"Saluti, sono il tuo webService\"";
    }

    @GetMapping(value= "/{nome}")
    public String getSaluti(@PathVariable("nome") String Nome)
    {
        if(Nome.equals("Marco")){
            throw new RuntimeException("Errore: attenzione: ");
        }
        String message = String.format("\"Saluti, %s sono il tuo webService\"", Nome);
        return message;
    }
}
