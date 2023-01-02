package com.ch.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
    @GetMapping("/chat")
    public String main() {
        return "chat";
    }
}
