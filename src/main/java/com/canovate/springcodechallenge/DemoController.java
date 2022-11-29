package com.canovate.springcodechallenge;

import com.canovate.springcodechallenge.dao.DeviceRepository;
import com.canovate.springcodechallenge.dto.AddDeviceRequest;
import com.canovate.springcodechallenge.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity.ok("Hello, " + name);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDevice(@RequestBody AddDeviceRequest add) {
        boolean isDeviceExist = deviceRepository.existsDeviceByBrandAndModelAndOsVersion(add.getBrand(), add.getModel(), add.getOsVersion());
        if (!isDeviceExist) {
            deviceRepository.save(new Device(add.getBrand(), add.getModel(), add.getOs(), add.getOsVersion()));
            return ResponseEntity.ok("Device was added successfully");
        } else {
            return (ResponseEntity<String>) ResponseEntity.internalServerError();
        }
    }

}
