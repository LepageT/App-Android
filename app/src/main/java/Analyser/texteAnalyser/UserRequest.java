package Analyser.texteAnalyser;

public class UserRequest {

	public boolean isNear;
	public String typeService;
	public int quantity;
	
	public UserRequest()
	{
		this.quantity = 10;
	}
	
	public String getService() {
		return typeService;
	}
	
	public void setService(String service) {
		this.typeService = service;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public boolean isNear() {
		return isNear;
	}
	
	public void setNear(boolean isNear) {
		this.isNear = isNear;
	}
	
	public boolean isRequestComplete()
	{
		return true;
	}

}

