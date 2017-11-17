package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;
import chat.view.ChatPanel;

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("food");
		display = new PopupDisplay();
		//View initialized after Model
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
//		String response = display.collectResponse("wa u wann talk bout?");
		
		/* While method checks for a response greater than two, and checks if it isn't quit, if both
		 * evaluate to "true" (response > 2 and not quit), it will refresh the popup with your response
		 * with a new question
		 *	|
		 *	|
		 *	V
		 */
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);						
//			response = display.collectResponse(response);
//		}
	}
	
	public String interactWithChatbot(String input)
	{
		return null;
	}
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	
	public PopupDisplay getDisplay()
	{
		return display;
	}
	
	public ChatFrame getChatFrame()
	{
		return appFrame;
	}
	
}
