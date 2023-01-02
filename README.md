# websocket
웹소켓 연습하기

WebSocket, STOMP, SocketJs의 차이점

WebSocket
Http의 특징 중 하나는 단방향 통신이다.
클라이언트와 서버간의 통신은 단건으로 이루어지며 하나의 요청(통신)이 끝나게 되면 클라이언트와 서버는 아무런 관계가 없어지게된다.
이 말은 서버입장에서 클라이언트로부터 요청이 있기전까지는 어떤 데이터도 전송할 수 없다는 것이다.
이런 문제를 해결하기 위해 양방향 통신이 생겨나게 되었고, WebSocket으로 구현하게 되었다.

WebSocket은 Http를 통해 작동하도록 설계되었으며, Http Header에 특정 값("websocket")을 명시함으로써 WebSocket 프로토콜로 전환하는 요청으로 시작된다.

STOMP
STOMP는 Simple/Stream Text Oriented Message Protocol의 약자로, 메시지 브로커의 역할을 한다.
STOMP는 WebSocket 기반으로 동작하며 pub/sub 구조로 되어 있다. pub/sub 구조는 쉽게 말해 편지를 쓰는 사람(Publisher)가 편지함에 편지를 넣어두면 그걸 기다리고 있던 편지를 받는 사람(Subscriber)가 편지를 받고 읽는 구조이다.
인터넷에 떠도는 대표적인 예로
채팅방 생성 : pub/sub 구현을 위한 Topic 생성
채팅방 입장 : Topic 구독
채팅방에서 메시지를 송수신 : 해당 Topic으로 메시지를 송신(pub) 혹은 수신(sub)

SockJS
상단에 적어둔 내용 처럼 WebSocket은 upgrade Header를 이용하여 Socket연결을 하고, 통신을 진행한다. 이 과정에서 여러가지 이유로 소켓연결이 불가능하게 될 경우가 있는데 이럴 경우 Http기반의 다른 기술로 전환하여 다시 연결을 시도해야할 필요가 있다. 이 때 사용하시는 것이 'WebSocket Emulation'이다. 그리고 Spring에서는 Emulation을 위해 'SockJS' 라이브러리를 지원한다.

SockJS는 다양한 기술을 이용해 웹소켓을 지원하지 않는 브라우저에서 정상작동하도록 도와주는데.
WebSocket
HTTP Streaming
HTTP Long Polling
세가지 타입을 이용한다.

참조 - https://velog.io/@kwj2435/Web-WebSocket-STOMP-SocketJS-%EC%B0%A8%EC%9D%B4
