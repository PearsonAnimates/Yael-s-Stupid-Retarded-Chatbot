package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class PopupDisplay
{
	//private data members for PopupDisplay
	private ImageIcon icon;
	private String windowTitle;
	
	//method to create a popup
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("images/chatbot.png"));
		windowTitle = "Chatbot says";
	}
	
	//method to show text in the popupDisplay
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	//method to collect response from user
	public String collectResponse(String question)
	{
		String answer = "";
		
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		
		return answer;
	}
	
}
