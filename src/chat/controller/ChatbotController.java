package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;

public class ChatbotController
{
	public void start()
	{
		PopupDisplay test = new PopupDisplay();
		test.displayText("words go here");
		test.collectResponse("ask a question");
	}
}
