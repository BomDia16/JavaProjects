package dio.web.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome() {
        return "Bom dia =)";
    }

    @GetMapping("/oi")
    public String oi() {
        return "teste";
    }
    
}
