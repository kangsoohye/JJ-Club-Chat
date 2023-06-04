package com.example.BasicChat;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@Service
@ServerEndpoint(value="/Chatt")
public class BasicChatApplication {

	private static Set<Session> clients =
			Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen
	public void onOpen(Session s) {
		System.out.println("open session : " + s.toString());
		if(!clients.contains(s)) {
			clients.add(s);
			System.out.println("session open : "+ s);
		}else {
			System.out.println("이미 연결된 Session 임!!");
		}
	}

	@OnMessage
	public void onMessage(String msg, Session session) throws Exception{
		System.out.println("receive message : " + msg);
		for(Session s : clients) {
			System.out.println("send data : " + msg);
			s.getBasicRemote().sendText(msg);
		}
	}

	@OnClose
	public void onClose(Session s) {
		System.out.println("session close: " + s);
		clients.remove(s);
	}

	public static void main(String[] args) {

		SpringApplication.run(BasicChatApplication.class, args);
	}
}
