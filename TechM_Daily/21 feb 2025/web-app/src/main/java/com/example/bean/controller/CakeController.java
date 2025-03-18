package com.example.bean.controller;

import java.util.Date;
import java.util.Set;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bean.Cake;
import com.example.bean.service.CakeService;

@Controller
public class CakeController {
    @Autowired
    private CakeService cakeService;

    @RequestMapping(value = "/showOrderForm", method = RequestMethod.GET)
    public String showOrderForm(@ModelAttribute("cake") Cake cake) {
        return "PlaceOrder";
    }

    @RequestMapping(value = "/orderStatus", method = RequestMethod.POST)
    public String getOrder(@Valid @ModelAttribute("cake") Cake cake, BindingResult res, ModelMap map) {
        if (res.hasErrors()) {
            return "PlaceOrder";
        }

        // Setting flavor rate
        cake.setFlavorRate(CakeService.getFlavorList().getOrDefault(cake.getFlavor(), 0));

        // Calculate price
        cake.setPrice(calculatePrice(cake));

        // Add order to service
        int orderId = CakeService.addOrder(cake);

        // Populate model attributes for view
        map.addAttribute("cake", cake);
        map.addAttribute("indianPrice", cake.getPrice() * 75);
        map.addAttribute("orderId", orderId);
        map.addAttribute("orderDate", new Date());

        // Returning the view page
        return orderId >= 1000 ? "orderStatus" : "PlaceOrder";
    }

    @ModelAttribute("flavorList")
    public Set<String> populateFillingList() {
        return CakeService.getFlavorList().keySet();
    }

    private double calculatePrice(Cake cake) {
        return cake.getSelectedcake() + cake.getFlavorRate() + cake.getIncludeCandles() + cake.getIncludeinscription();
    }
}
