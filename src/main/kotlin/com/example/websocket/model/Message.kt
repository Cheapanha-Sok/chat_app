package com.example.websocket.model

import java.time.LocalDateTime

data class Message(
    var senderName: String? = null,
    var receiverName: String? = null,
    var message: String? = null,
    var dateTime: LocalDateTime? = null,
    var status: Status? = null
)