package me.spacekiller.util;

import org.bukkit.entity.Player;

public class TpaObject {
	
	private Player sender;
	
	private Player receiver;
	
	private String name;
	
	private int timer = 10; 
	
	private boolean accepted = false;
	
	private boolean denied = false;
	
	public TpaObject(Player sender, Player receiver) {
		name = receiver.getName();
		this.sender = sender;
		this.receiver = receiver;
	}
	
	public Player getSender() {
		return sender;
	}
	
	public Player getReceiver() {
		return receiver;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getAccepted() {
		return accepted;
	}
	
	public boolean getDenied() {
		return denied;
	}
	
	public int getTimer() {
		return timer;
	}
	
	public void changeAccepted() {
		accepted = true;
	}
	
	public void changeDenied() {
		denied = true;
	}
	
	public void countDown() {
		timer--;
	}

}
