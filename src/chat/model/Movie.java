package chat.model;

import java.time.LocalDate;

public class Movie
{
	private String title;
	private String genre;
	private String ratingMPAA;
	private String review;
	private int length;
	private LocalDate releaseDate;
	private double starScore;
	
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

	public String getTitle()
	{
		this.title = "A Title";
		return title;
	}

	public String getGenre()
	{
		this.genre = "Action";
		return genre;
	}

	public String getRatingMPAA()
	{
		
		this.ratingMPAA = "G";
		return ratingMPAA;
	}

	public String getReview()
	{
		return review;
	}

	public int getLength()
	{
		return length;
	}

	public LocalDate getReleaseDate()
	{
		return releaseDate;
	}

	public double getStarScore()
	{
		return starScore;
	}

	public void setTitle(String title)
	{
		this.title = title;
		title = "Legacy of Pirates";
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
		genre = "Comedy";
	}

	public void setRatingMPAA(String ratingMPAA)
	{
		this.ratingMPAA = ratingMPAA;
		ratingMPAA = "PG-13";
	}

	public void setReview(String review)
	{
		this.review = review;
		review = "This is a movie review, I think. Lol.";
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public void setReleaseDate(LocalDate releaseDate)
	{
		this.releaseDate = releaseDate;
		releaseDate = LocalDate.now();
	}

	public void setStarScore(double starScore)
	{
		this.starScore = starScore;
	}
	
	public String toString()
	{
		String MovieDescription = "";
		return MovieDescription;
	}
}
