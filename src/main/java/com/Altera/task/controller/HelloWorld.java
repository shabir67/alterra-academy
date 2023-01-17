package com.Altera.task.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorld {
    // GET methods //
@Operation(summary = "Hello World but with get method")
    @GetMapping(path = "/v1/messages")
    public String getMessages(){
    log.info("[Uba] v1/messages Get method is called");
    return "Hello World!";
}
@PostMapping(path = "/v1/messages")
    public String postMessages(){
    log.info("[Uba] v1/messages Post method is called");
    return "Hello World";
}
@DeleteMapping(path = "/v1/messages")
    public String deleteMessage() {
    log.info("[Uba] v1/messages Delete method is called");
    return "Hello World";
}

}
