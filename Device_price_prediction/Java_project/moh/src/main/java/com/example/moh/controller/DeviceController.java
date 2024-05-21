package com.example.moh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.moh.model.Device;
import com.example.moh.repository.DeviceRepository;
import com.fasterxml.jackson.databind.JsonNode;





@RestController
@RequestMapping("/api")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    // Endpoint to add an device
    @PostMapping("/addDevice")
    public Device addDevice(@RequestBody String data) {
        Device device = new Device(data);
        return deviceRepository.save(device);
    }

    // Endpoint to get all devices
    @GetMapping("/Devices")
    public List<Device> getAllItems() {
        return deviceRepository.findAll();
    }

    // Endpoint to get JSON value
    @GetMapping("/Devices/{id}")
    public String getItemData(@PathVariable Long id) {
        Device device = deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));
        return device.getData();
    }

    // Endpoint to make prediction using Python model
    @PostMapping("/predict")
    public String predictPrice(@RequestBody JsonNode deviceData) {
             
        String pythonApiUrl = "http://localhost:5000/predict";

        // Convert JsonNode to String
        String deviceDataStr = deviceData.toString();
        
        // Set the headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        // Create request entity
        HttpEntity<String> requestEntity = new HttpEntity<>(deviceDataStr, headers);

        ResponseEntity<String> response = new RestTemplate().postForEntity(
            pythonApiUrl, requestEntity, String.class);
        
       return response.getBody();
        
        }
}
