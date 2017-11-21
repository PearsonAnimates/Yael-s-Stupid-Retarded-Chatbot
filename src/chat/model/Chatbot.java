package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import chat.model.Movie;

public class Chatbot
{
	/*
	 * A bunch of variables used for this project that have been given types.
	 */
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
	
	/*
	 * Taking all variables and giving them values.
	 */
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.questions = new String [2];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.currentTime = LocalTime.now();
		this.topics = new String [3];
		this.verbs = new String [4];
		this.followUps = null;
		
		buildverbs();
		buildTopics();
		buildQuestions();
		buildMovieList();
		buildShoppingList();
		buildCuteAnimalMemes();
	}
	
	/*
	 * a list of verbs for the chatbot to use as a part of a sentence
	 */
	private void buildverbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	/*
	 * a list of Topics for the chatbot to use as a part of a sentence
	 */
	private void buildTopics()
	{
		topics[0] = "Calvin Hobbs LVIII";
		topics[1] = "Porker The Benevolent";
		topics[2] = "Makai-3PO";
	}
	
	/*
	 * a list of Topics for the chatbot to use as a part of a sentence
	 */
	private void buildQuestions()
	{
		questions[0] =  "Are you dumb?";
		questions[1] = "Why would Calvin not be an insult to human existence?";
	}

	/*
	 * a list of Movies for the chatbot to use as a part of a sentence
	 */
	private void buildMovieList()
	{
		Movie Calvinv1 = new Movie("The Lord Of The Rings Trilogy: Extended Edition");
		Movie Calvinv2 = new Movie("Chicken Run");
		Movie Calvinv3 = new Movie("Turd III");
		Movie Calvinv4 = new Movie("Calvin is trying to convince Porker he's gay... At this point I'm not sure if he's lying");
		Movie Calvinv5 = new Movie("The greatest YT video of all time --> https://youtu.be/36Ua6qAGcFw <--- this is the $H¡+ Minecraft Mod Showcase by Ssundee");
		movieList.add(Calvinv1);
		movieList.add(Calvinv2);
		movieList.add(Calvinv3);
		movieList.add(Calvinv4);
		movieList.add(Calvinv5);
	}
	
	/*
	 * a list of Shopping items for the chatbot to use as a part of a sentence
	 */
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protien");
		shoppingList.add("slug bait");
		shoppingList.add("gross things");
	}
	/*
	 * will be a list of cute animals for the chatbot to use as a part of a sentence
	 */
	private void buildCuteAnimalMemes()
	{
		cuteAnimalMemes.add("This is supposed to be a meme, I don't know if I should actually add an image or not... *snores*"
				+ " *lazy*");
	}
	
	/**
	 * Uses your response to attempt a sensible response.
	 * @param inputs user text as a string.
	 * @return returns your response, and buildChatBotResponse.
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input+ "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	
	/**
	 * Randomly selects pre-selected short phrases/words to make a sentence, but will not gaurantee flow of words.
	 * @return Returns pre-selected short phrases/words and outputs them <-- it will be visible on popup to the user.
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		
		int random = (int) (Math.random() * verbs.length);	
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * 2);
		
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + " is a great movie!";
		}
		
		return response;
	}

	/**
	 * Checks if user input 3 characters or more, if not, the program goes crash, burn, and die.
	 * @param input must be greater than 2
	 * @return if input isn't big enough, validLength returns false, aka, program dies.
	 */
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
	
	
	// Need to fix the dumb username
	
	public boolean userNameChecker(String input)
	{
		boolean UsernameChecker = false;
		this.username = "@morgan";
		input = "@morgan";
		
		//Broken thing
//		if(input == "@morgan")
//		{
//			username.concat(getUsername())
//			UsernameChecker = true;
//		}
		
		return UsernameChecker;
		
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
		boolean Quit = false;
		
		if (exitString.equalsIgnoreCase("quit"))
		{
			Quit = true;
		}
		
		return Quit;
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
