package com.Deepak.chatbot.controller;

import com.Deepak.chatbot.model.Message;
import com.Deepak.chatbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from React
public class ChatController {

    @Autowired
    private ChatService chatService;

    // DTO Class for input
    static class ChatRequest {
        public String message;
    }

    // DTO Class for output
    static class ChatResponse {
        public String text;

        public ChatResponse(String text) {
            this.text = text;
        }
    }

    @PostMapping
    public ChatResponse handleMessage(@RequestBody ChatRequest chatRequest) {
        // Save user's message
        chatService.saveMessage("user", chatRequest.message);

        // Generate bot's response
        String botResponse = chatService.getBotResponse(chatRequest.message);

        // Save bot's response
        chatService.saveMessage("bot", botResponse);

        // Return response as structured JSON
        return new ChatResponse(botResponse);
    }
}
