// MessageList.jsx
import React from 'react';

const MessageList = ({ messages }) => {
    return (
        <div className="message-list">
            {messages.map((message, index) => (
                <div key={index} className={`message ${message.sender}`}>
                    {message.text}
                </div>
            ))}
        </div>
    );
};

export default MessageList; // This exports the component as default
