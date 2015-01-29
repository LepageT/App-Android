package Analyser.Services;

public class Toilette extends Service{
	
	private String adresse;
	private String quartier;
	
	public Toilette()
	{
		
	}
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getQuartier() {
		return quartier;
	}
	
	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}
	
	public String getInfo()
	{
		return this.adresse + " " + this.quartier + " ";
	}
}
