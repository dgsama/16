
abstract class MovieType 
{
	public abstract double getCharge(int daysRented);
	
	public int getFrequentRenterPoints(int daysRented)
	{
		return 1;
	}
}
