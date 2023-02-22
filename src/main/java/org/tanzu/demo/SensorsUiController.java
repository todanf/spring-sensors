package org.tanzu.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SensorsUiController {

    private final SensorRepository sensorRepository;

    @Value("${title}")
    private String title;

    public SensorsUiController(final SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @RequestMapping("/")
    public String fetchUI(Model model) {
        model.addAttribute("sensors", sensorRepository.findAll());
        model.addAttribute("title", title);
        return "index";
    }
}

