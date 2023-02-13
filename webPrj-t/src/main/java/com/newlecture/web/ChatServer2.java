package com.newlecture.web;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat2/{guest-id}")
public class ChatServer2 {
	
	static CopyOnWriteArrayList<Session> sessions = new CopyOnWriteArrayList<>();
		
	// OPEN
	@OnOpen
	public void openHandler(@PathParam("guest-id") String guestId, Session session) throws IOException {		
		sessions.add(session);
		
		for(Session s : sessions)
			s.getBasicRemote().sendText(String.format("%s님이 접속하셨습니다.", guestId));		
		
	}
	
	// MESSAGE
	@OnMessage
	public void messageHandler(@PathParam("guest-id") String guestId, Session session, String message) throws IOException {
		System.out.println(message);
		for(Session s : sessions)
			s.getBasicRemote().sendText(message);
	}
	
	// CLOSE
	@OnClose
	public void closeHandler(Session session) {
		sessions.remove(session);
	}
	
}



