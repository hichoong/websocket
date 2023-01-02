package com.ch.websocket.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *TextWebSocketHandler 클래스를 상속. 몇 개의 메소드를 오버라이드
 * afterConnectionEstablished 메소드 - 연결 후에 수행. 자신이 관리하는 sessionMap 객체에 연결 정보를 저장.
 * handleMessage 메소드 - sessionMap 객체에서 관리되는 session 정보를 이용하여 전달받은 메세지를 전송.
 * afterConnectionClosed 메소드 - 연결이 해제된 후에 수행. 자신이 관리하는 sessionMap 객체에서 연결 정보를 삭제.
 */


@Slf4j
@Component
public class WebSocketComponent extends TextWebSocketHandler {
    public static Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessionMap.put(session.getId(), session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
        sessionMap.forEach((sessionId, sessionInMap) -> {
            try {
                sessionInMap.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessionMap.remove(session.getId());
    }
}

