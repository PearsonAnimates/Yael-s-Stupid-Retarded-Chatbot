package chat.view;

import javax.swing.*;
import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton tweetButton;
	private JButton searchButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	//Need a data member for the scrollpane
	private JScrollPane chatScrollPane;

	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;

		// Init GUI data members
		chatButton = new JButton("chat", new ImageIcon(getClass().getResource("chat/viwe/images/message.png")));
		loadButton = new JButton("load", new ImageIcon(getClass().getResource("chat/viwe/images/load.png")));
		tweetButton = new JButton("tweet", new ImageIcon(getClass().getResource("chat/viwe/images/twitter.png")));
		searchButton = new JButton("search", new ImageIcon(getClass().getResource("chat/viwe/images/search.png")));
		saveButton = new JButton("save", new ImageIcon(getClass().getResource("chat/viwe/images/Save.png")));
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		infoLabel = new JLabel("Type to talk to stupid bot");
		appLayout = new SpringLayout();
		//init the scrollpane
		chatScrollPane = new JScrollPane();

		//call new helper method
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	private void setupPanel()
	{
		this.setMinimumSize(new Dimension(800, 600));
		this.setBackground(Color.CYAN);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(searchButton);
		this.add(loadButton);
		this.add(saveButton);
		this.add(tweetButton);
		this.add(infoLabel);
		this.add(chatScrollPane);
		this.add(inputField);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);

	}

	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, infoLabel, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -6, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 540, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, tweetButton, -31, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -31, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, -31, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, searchButton, -31, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, searchButton);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 6, SpringLayout.EAST, tweetButton);
		appLayout.putConstraint(SpringLayout.WEST, tweetButton, 6, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 6, SpringLayout.EAST, loadButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 6, SpringLayout.EAST, searchButton);
		appLayout.putConstraint(SpringLayout.WEST, searchButton, 60, SpringLayout.EAST, inputField);
	}

	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.tweet(inputField.getText());
			}
		});
		
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String usernameToSearch = inputField.getText();
				
				chatArea.setText(appController.search(usernameToSearch));
			}
		});
		
		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
	}
}
