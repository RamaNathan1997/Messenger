package com.rama.rmkcet.Messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.rama.rmkcet.Messenger.database.DatabaseClass;
import com.rama.rmkcet.Messenger.exception.DataNotFoundException;
import com.rama.rmkcet.Messenger.model.Message;

public class MessageService {
	
	
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public MessageService()
	{
		messages.put(1L, new Message(1,"Hello World!","Rama"));
		messages.put(2L, new Message(2,"Hello Jersey!","Rama"));

	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size); 
	}
	
	
	public List<Message> getAllMessages()
	{
     return new ArrayList<Message>(messages.values());		
	}
	
	public Message getMessage(long id) {
		Message message = messages.get(id);
		if (message == null) {
			throw new DataNotFoundException("Message with id " + id + " not found");
		}
		return message;
	}
	
	public Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(),message );
		return message;
	}
	
	public Message updateMessage(Message message)
	{
		if(message.getId()<=0)
		{
			return null;
		}
		
		messages.put(message.getId(), message);
		return message;
	}
	
    public Message removeMessage(long id)
    {
    	return messages.remove(id);
    	
    }
    
    
}
