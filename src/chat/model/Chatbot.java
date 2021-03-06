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
		this.followUps = new String[5];
		
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
		Movie CalvinV1 = new Movie("The Lord Of The Rings Trilogy: Extended Edition");
		Movie CalvinV2 = new Movie("Chicken Run");
		Movie CalvinV3 = new Movie("Turd III");
		Movie CalvinV4 = new Movie("Calvin is trying to convince Porker he's gay... At this point I'm not sure if he's lying");
		Movie CalvinV5 = new Movie("The greatest YT video of all time --> https://youtu.be/36Ua6qAGcFw <--- this is the $H¡+ Minecraft Mod Showcase by Ssundee");
		movieList.add(CalvinV1);
		movieList.add(CalvinV2);
		movieList.add(CalvinV3);
		movieList.add(CalvinV4);
		movieList.add(CalvinV5);
	}
	
	/*
	 * a list of Shopping items for the chatbot to use as a part of a sentence
	 */
	private void buildShoppingList()
	{
		shoppingList.add("eggs");
		shoppingList.add("protein");
		shoppingList.add("veggies");
		shoppingList.add("hot peppers");
		shoppingList.add("onions");
		shoppingList.add("snacks");
		shoppingList.add("bagel");
		shoppingList.add("crunchy peanut butter");
		shoppingList.add("hot sauce");
		shoppingList.add("juice");
	}
	/*
	 * will be a list of cute animals for the chatbot to use as a part of a sentence
	 */
	private void buildCuteAnimalMemes()
	{
		cuteAnimalMemes.add("floofer");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("pupper");
	}
	
	/**
	 * Uses your response to attempt a sensible response.
	 * @param inputs user text as a string.
	 * @return returns your response, and buildChatBotResponse.
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		currentTime = LocalTime.now();
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute();
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
		
		
		int followup = (int) (Math.random() * 5);
				
		switch (followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
			break;
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
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
	
	//method to check for html strings
	public boolean htmlTagChecker(String input)
	{
		boolean valid = false;
		boolean length = true;
		int len = input.length();
		int one = input.indexOf("<") + 1;
		int two = input.indexOf(">");
		int three = input.indexOf("<" + "/") + 2;
		String temp = input;
		temp = temp.replaceFirst(">"," ");
		int four = temp.indexOf(">");
		if (len < 3) {
			length = false;
		}
		if(length && three > one && four > two && input.toLowerCase().substring(one, two)
				.contains(input.toLowerCase().substring(three, four))) {
			valid = true;
		}
		if (length && input.substring(one, two).equalsIgnoreCase("p")
				|| length && input.substring(one, two).equalsIgnoreCase("br")) {
			valid = true;
		}
		String a = "";
		if (length) {
			a = input.toLowerCase().substring(one, two);
		}
		if (a.contains("a href")) {
			if (!a.contains("a href=") && !a.contains("a href =")) {
				valid = false;
			}
		}
		return valid;
//		if(input.contains("<B>  </B>") && input.contains("<I> sdadas </i>") && input.contains("<P>")
//				&& input.contains("<A HREF=\\\"sdfs.html\\\"> </a>") && input.contains("")
//				)
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}
	
	
	// Need to fix the dumb username
	//broken username checker
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
	
	//method to check content
	public boolean contentChecker(String contentCheck)
	{
		if(content.equals(contentCheck) || !content.equals(contentCheck))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//method to check cute animal memes
	public boolean cuteAnimalMemeChecker(String input)
	{
		boolean isinlist = false;
		for (int index = 0; index < cuteAnimalMemes.size(); index ++)
		{
			String current = cuteAnimalMemes.get(index);
			if(current.equals(input))
			{
				isinlist = true;
			}
		}
		return isinlist;
	}
	
	//method to check shopping list
	public boolean shoppingListChecker(String shoppingItem)
	{
		boolean foodincart = false;
		for (int index = 0; index < shoppingList.size(); index ++)
		{
			String foodItem = shoppingList.get(index);
			if(foodItem.equals(shoppingItem))
			{
				foodincart = true;
			}
		}
		return foodincart;
	}
	
	//method to check movie titles (useless method that compiles.)
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	//method to check movie genres (useless method that compiles.)
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	//method to check if the user input string is quit
	public boolean quitChecker(String exitString)
	{	
		if(exitString.equals("Quit"))
		{
			return true;
		}
		else if(exitString.equals("QUIT"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//method that checks for keyboard mashing
	public boolean keyboardMashChecker(String sample)
	{
		boolean MashDetected = false;
		if(sample == "sdf" || sample == "SDF" || sample == "dfg" || sample == "cvb" || sample == ",./" || sample == "kjh" || sample == "DFG" || sample == "CVB" || sample == "KJH")
		{
			MashDetected = true;
		}
		else
		{
			MashDetected = false;
		}

		return MashDetected;
	}
	
	//method to get movie list
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	//method to get shopping list
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	//method to get cute animal memes
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	//method to get questions for the chatbot
	public String [] getQuestions()
	{
		return null;
	}
	
	//method to get verbs for chatbot
	public String[] getverbs()
	{
		return verbs;
	}

	//method to get topics
	public String[] getTopics()
	{
		return topics;
	}

	//method to get followups
	public String[] getFollowUps()
	{
		return followUps;
	}

	//method to get usernames
	public String getUsername()
	{
		return username;
	}
	
	//method to get content
	public String getContent()
	{
		content = "for the repeated lols" + content + "for the repeated lols";
		return content;
	}

	//method to get intro
	public String getIntro()
	{
		return null;
	}
	
	//method to get the current time of day, including the date (useless method that compiles.)
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	//method that sets the username 
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	//method to set content
	public void setContent(String content)
	{
		this.content = content;
	}
}
