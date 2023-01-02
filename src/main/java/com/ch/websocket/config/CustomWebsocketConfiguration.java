package com.ch.websocket.config;


import com.ch.websocket.component.WebSocketComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @EnableWebSocket 애너테이션을 추가
 * WebSocketConfigurer 인터페이스를 구현
 * WebSocket Connection 관리를 위해 생성한 WebSocketComponent 빈(bean)을 주입.
 * registerWebSocketHandlers 메소드 - WebSocket 기능을 위해 필요한 정보들을 지정.
 * /chat 경로의 WebSocket 연결 정보는 WebSocketComponent 객체로 지정.
 * CORS 문제 해결을 위해 setAllowedOrigins() 메소드를 사용하고,테스트이므로 모든 CORS 정보를 허용.
 * SockJS fallback option들을 허용.
 * SockJS 사용 시 필요한 클라이언트 라이브러리 URL 정보를 입력.
 */
@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class CustomWebsocketConfiguration implements WebSocketConfigurer {

    private final WebSocketComponent webSocketComponent;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketComponent, "/chat")
                .setAllowedOriginPatterns(("*"))
                .withSockJS()
                .setClientLibraryUrl("https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js");
    }
}
