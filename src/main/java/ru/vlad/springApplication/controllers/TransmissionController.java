package ru.vlad.springApplication.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.vlad.springApplication.dto.Transmission;
import ru.vlad.springApplication.services.impl.TransmissionServiceImpl;

@Controller
@RequestMapping("/transmission")
public class TransmissionController {

    private final TransmissionServiceImpl transmissionService;

    public TransmissionController(TransmissionServiceImpl transmissionService) {
        this.transmissionService = transmissionService;
    }

    @GetMapping("/create")
    public ModelAndView transmissionCreateView(@ModelAttribute("transmission") Transmission transmission) {
        return new ModelAndView("transmission_create");
    }

    @PostMapping("/create")
    public ModelAndView transmissionCreate(Transmission transmission) {
        transmissionService.create(transmission);
        return new ModelAndView("redirect:/transmission/list");
    }

    @GetMapping("/list")
    public ModelAndView listTransmissions() {
        ModelAndView modelAndView = new ModelAndView("transmission_list", HttpStatus.OK);
        modelAndView.addObject("transmissions", transmissionService.readAll());
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView transmissionDelete(@PathVariable("id") long id) {
        transmissionService.delete(id);
        return new ModelAndView("redirect:/transmission/list");
    }

    @GetMapping("/update/{id}")
    public ModelAndView transmissionUpdateView(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("transmission_edit");
        modelAndView.addObject("transmission", transmissionService.read(id));
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public ModelAndView transmissionUpdate(Transmission transmission) {
        transmissionService.update(transmission, transmission.getId());
        return new ModelAndView("redirect:/transmission/list");
    }
}
