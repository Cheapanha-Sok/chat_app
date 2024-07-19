package com.example.websocket.controller

import com.example.websocket.model.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller


@Controller
class WebSocketTextController {
    @Autowired lateinit var simpMessagingTemplate: SimpMessagingTemplate

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    fun broadcastMessage(@Payload message: Message): Message {
        return message
    }

    @MessageMapping("/private-message")
    fun recMessage(@Payload message: Message): Message {
        simpMessagingTemplate.convertAndSendToUser(message.receiverName!!, "/private", message)
        return message
    }
}