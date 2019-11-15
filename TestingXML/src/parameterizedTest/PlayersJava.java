package parameterizedTest;

public class PlayersJava {
	private String name;
	private String club;
	private String position;
	private double marketValue;
	private String nationality;
	private int age;
	
	

	public PlayersJava(String name, String club, String position, double marketValue, 
	String nationality,int age)
	{
		this.setName(name);
		this.setClub(club);
		this.setPosition(position);
		this.setMarketValue(marketValue);
		this.setNationality(nationality);
		this.setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String toString()
	{
		return "Player info: "+ this.getName()+", "+
				this.getClub()+", "+
				this.getPosition()+", "+
				this.getMarketValue()+", "+
				this.getNationality();
	}

}