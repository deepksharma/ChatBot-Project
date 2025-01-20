import React, { useState } from "react";
import MessageList from "./MessageList";
import MessageInput from "./MessageInput";
import axios from "axios";

const ChatContainer = () => {
    const [messages, setMessages] = useState([]);

    const sendMessage = async (text) => {
        const userMessage = { sender: "user", text };
        setMessages((prevMessages) => [...prevMessages, userMessage]);
        console.log("User message sent:", userMessage);

        try {
            // Make sure you're sending the correct data in the POST request
            const response = await axios.post("http://localhost:8080/api/chat", { message: text });
            const botMessage = { sender: "bot", text: response.data.text };
            setMessages((prevMessages) => [...prevMessages, botMessage]);
        } catch (error) {
            console.error("Error fetching response from backend:", error);
        }
    };

    return (
        <div className="chat-container">
            <MessageList messages={messages} />
            <MessageInput onSend={sendMessage} />
        </div>
    );
};

export default ChatContainer;
