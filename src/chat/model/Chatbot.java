package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import chat.model.Movie;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = null;
		this.currentTime = null;
		this.questions = new String [2];
		this.username = username;
		this.content = null;
		this.intro = null;
//		this.currentTime = null;
		this.topics = new String [3];
		this.verbs = new String [4];
		this.followUps = null;
		
		buildverbs();
		buildTopics();
		buildQuestions();
		buildMovieList();
		buildShoppingList();
	}
	
	private void buildverbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	private void buildTopics()
	{
		topics[0] = "Calvin Hobbs LVIII";
		topics[1] = "Porker The Benevolent";
		topics[2] = "Makai-3PO";
	}
	
	private void buildQuestions()
	{
		questions[0] =  "Are you dumb?";
		questions[1] = "Why would Calvin not be an insult to human existence?";
	}

	private void buildMovieList()
	{
		Movie d1 = new Movie("The Lord Of The Rings Trilogy: Extended Edition");
		Movie d2 = new Movie("Chicken Run");
		Movie d3 = new Movie("Turd III");
		Movie d4 = new Movie("Calvin is dumb");
		Movie d5 = new Movie("The greatest YT video of all time --> https://youtu.be/36Ua6qAGcFw <--- this is the $H¡+ Minecraft Mod Showcase by Ssundee");
		movieList.add(d1);
		movieList.add(d2);
		movieList.add(d3);
		movieList.add(d4);
		movieList.add(d5);
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protien");
		shoppingList.add("slug bait");
		shoppingList.add("gross things");
	}
	
	private void buildCuteAnimals()
	{
		
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input+ "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		return response;
	}

	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if(input != null && input.length() > 2)
		{
			validLength = true;
		}
		
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		if (exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		boolean anything = false;
		if(sample != null)
		{
			anything = false;
		}
		else
		{
			anything = true;
		}

		return anything;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return null;
	}
	
	public String[] getverbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
