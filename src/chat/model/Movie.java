package chat.model;

import java.time.LocalDate;

public class Movie
{
	//private members declared
	private String title;
	private String genre;
	private String ratingMPAA;
	private String review;
	private int length;
	private LocalDate releaseDate;
	private double starScore;
	
	//Initializing data members.
	public Movie(String title)
	{
		this.title = "";
		this.genre = "";
		this.ratingMPAA = "";
		this.review = "";
		this.length = 99;
		this.releaseDate = null;
		this.starScore = 0.0;
	}

	//method to getTitle
	public String getTitle()
	{
		this.title = "A Title";
		return title;
	}

	//method to getGenre
	public String getGenre()
	{
		this.genre = "Action";
		return genre;
	}

	//method to getRating
	public String getRatingMPAA()
	{
		
		this.ratingMPAA = "G";
		return ratingMPAA;
	}

	//method to getReview
	public String getReview()
	{
		return review;
	}

	//method to getLength
	public int getLength()
	{
		return length;
	}

	//method to getReleaseDate
	public LocalDate getReleaseDate()
	{
		return releaseDate;
	}

	//method to getStarScore
	public double getStarScore()
	{
		return starScore;
	}

	//method to setTitle
	public void setTitle(String title)
	{
		this.title = title;
		title = "Legacy of Pirates";
	}

	//method to setGenre
	public void setGenre(String genre)
	{
		this.genre = genre;
		genre = "Comedy";
	}

	//method to setRating
	public void setRatingMPAA(String ratingMPAA)
	{
		this.ratingMPAA = ratingMPAA;
		ratingMPAA = "PG-13";
	}

	//method to setReview
	public void setReview(String review)
	{
		this.review = review;
		review = "This is a movie review, I think. Lol.";
	}

	//method to setLength
	public void setLength(int length)
	{
		this.length = length;
	}

	//method to setReleaseDate
	public void setReleaseDate(LocalDate releaseDate)
	{
		this.releaseDate = releaseDate;
		releaseDate = LocalDate.now();
	}

	//method to setStarScore
	public void setStarScore(double starScore)
	{
		this.starScore = starScore;
	}
	
	//method to make a description via toString
	public String toString()
	{
		String MovieDescription = "";
		return MovieDescription;
	}
}
