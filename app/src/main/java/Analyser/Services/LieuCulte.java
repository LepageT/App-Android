package Analyser.Services;



public class LieuCulte extends Service {

	private float longitude;
	private float latitude;
	private String religion;
	private String quartier;
	
	public float getLongitude() {
		return longitude;
	}
	
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public float getLatitude() {
		return latitude;
	}
	
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	public String getReligion() {
		return religion;
	}
	
	public void setReligion(String religion) {
		this.religion = religion;
	}
	
	public String getQuartier() {
		return quartier;
	}
	
	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}
	
	public String getInfo()
	{
		return this.religion + " " + this.quartier + " " + this.longitude + " " + this.latitude;
	}
}
