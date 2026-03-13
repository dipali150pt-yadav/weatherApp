package com.cfs.weatherApp.controller;


import com.cfs.weatherApp.dto.Root;
import com.cfs.weatherApp.dto.WeatherResponse;
import com.cfs.weatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class controller {
     @Autowired
     private WeatherService Service;
    @GetMapping("/{city}")
    public String getWeatherData(@PathVariable String city) {
        return Service.test();
    }
    @GetMapping("/my/{city}")
    public  WeatherResponse getWeather(@PathVariable String city) {
        return Service.getData(city);
    }

    @GetMapping("/forecast/{city}")
    public  WeatherResponse getForecast(@PathVariable String city) {
        return Service.getData(city);
    }




}
