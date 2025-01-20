package com.Deepak.chatbot.repository;

import com.Deepak.chatbot.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
