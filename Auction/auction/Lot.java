package auction;

public class Lot {
	private String artist, title;
	private int hammerPrice;
	
	private Lot(String artist, String title, int hammerPrice) {
		this.artist = artist;
		this.title = title;
		this.hammerPrice = hammerPrice;
	}
	
	public Lot(Lot other) {
		artist = other.artist;
		title = other.title;
		hammerPrice = other.hammerPrice;
	}
	
	public static Lot make(String artist, String title, int hammerPrice) {
		if(artist == null || title == null || title.length() < 2 || hammerPrice <= 0)
			return null;
		for(int i=0;i<title.length();++i) {
			char c = title.charAt(i);
			if(c != ' ' && !Character.isUpperCase(c))
				return null;
		}
		return new Lot(artist, title, hammerPrice);
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getHammerPrice() {
		return hammerPrice;
	}
	
	public void bid(int bidValue) {
		hammerPrice = Math.max(hammerPrice, bidValue);
	}
	
	public String toString() {
		return artist + ": " + title + "(" + hammerPrice + " GBP)";
	}
	
	public boolean moreExpensiveThan(Lot other) {
		return other != null && hammerPrice > other.hammerPrice;
		
	}
}
