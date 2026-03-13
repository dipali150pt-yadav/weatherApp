package com.cfs.weatherApp.service;


import com.cfs.weatherApp.dto.Root;
import com.cfs.weatherApp.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownContentTypeException;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;
    private final RestTemplate template = new RestTemplate();
    @Value("${weather.api.url}")
    private String apiUrl;
    public String test(){
        return "good";
    }
    public  WeatherResponse getData(String city){
        String url= apiUrl+"?key="+apiKey+"&q="+city ;
        Root response=template.getForObject(url,Root.class);
        WeatherResponse weatherResponse=new WeatherResponse();
        assert response != null;
        weatherResponse.setCity(response.getLocation().name);
        weatherResponse.setRegion(response.getLocation().region);
        weatherResponse.setCountry(response.getLocation().country);
        String condition= response.getCurrent().getCondition().getText();
        weatherResponse.setTemperature(response.getCurrent().getTemp_f());
        weatherResponse.setCondition(condition);
        return weatherResponse;

    }

    public Forcast getForcast(){

    }
}
