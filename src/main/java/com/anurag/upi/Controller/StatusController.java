package com.anurag.upi.Controller;

import com.anurag.upi.Status;
import com.anurag.upi.service.StatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/status")
@RestController
public class StatusController {
    private final StatusService statusService;

    StatusController(StatusService service){
        this.statusService = service;
    }
    @GetMapping
    public Status sendStatus(){
        return statusService.getStatus();
    }
}
