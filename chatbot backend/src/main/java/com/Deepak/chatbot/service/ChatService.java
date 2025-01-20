package com.Deepak.chatbot.service;

import com.Deepak.chatbot.model.Message;
import com.Deepak.chatbot.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(String sender, String text) {
        Message message = new Message(sender, text);
        return messageRepository.save(message);
    }

    public String getBotResponse(String userMessage) {
        if (userMessage.toLowerCase().contains("hello")) {
            return "Hi! How can I help you today?";
        } else if (userMessage.toLowerCase().contains("bye")) {
            return "Goodbye! Have a nice day!";
        }
        return "I'm sorry, I didn't understand that.";
    }
}
