package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	//private data members for appController/Panel
	private ChatbotController appController;
	private ChatPanel appPanel;
	
	//creates actual method that puts together the frame and panel and initializes the app interface
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ChatPanel(appController);
		setupFrame();
	}
	
	//sets up frame around panel chatbot takes place
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setSize(600, 600);
		this.setTitle("Mad Calvin");
		this.setResizable(false);
		this.setVisible(true);
	}
	
	//method to get app controller
	public ChatbotController getappController()
	{
		return appController;
	}
	
}
