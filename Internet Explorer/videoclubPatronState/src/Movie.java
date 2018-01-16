public class Movie 
{
	public static final MovieType CHILDRENS = new ChildrenMovie();
	public static final MovieType NEW_RELEASE = new NewReleaseMovie();
	public static final MovieType REGULAR = new RegularMovie();
	
	private String title;
	private MovieType type;
	
	public Movie(String title, MovieType type) 
	{
		this.title = title;
		this.type = type;
	}
	
	public void setType(MovieType type) 
	{
		this.type = type;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public double getCharge(int daysRented)
	{
		return type.getCharge(daysRented);
	}
	
	public int getFrequentRenterPoints(int daysRented)
	{
		return type.getFrequentRenterPoints(daysRented);
	}
}
