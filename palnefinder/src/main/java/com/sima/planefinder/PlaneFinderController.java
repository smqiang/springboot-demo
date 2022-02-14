package com.sima.planefinder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PlaneFinderController {
    private final PlaneFinderService pfService;

    public PlaneFinderController(PlaneFinderService pfService) {
        this.pfService = pfService;
    }

    @ResponseBody
    @GetMapping("/aircraft")
    public Iterable<Aircraft> getCurrentAircraft() throws IOException {
        return this.pfService.getAircraft();
    }
}
