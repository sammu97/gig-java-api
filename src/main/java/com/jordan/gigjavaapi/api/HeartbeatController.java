package com.jordan.gigjavaapi.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("heartbeat")
public class HeartbeatController {

    @GetMapping
    public void sendHeartbeat(){
        return;
    }
}
