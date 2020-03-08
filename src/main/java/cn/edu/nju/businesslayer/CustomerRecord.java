package cn.edu.nju.businesslayer;

public class CustomerRecord {

	private String date;
	private String firstNameEntry;
	private String lasteNameEntry;
	private String emailAddressEntry;
	private String phoneNumberEntry;
	private String addressEntry;
	private String cityEntry;
	private String stateEntry;
	private String zipCodeEntry;


	public CustomerRecord(String date, String firstNameEntry, String lasteNameEntry, String emailAddressEntry, String phoneNumberEntry,
			String addressEntry, String cityEntry, String stateEntry, String zipCodeEntry) {
		super();
		this.date = date;
		this.firstNameEntry = firstNameEntry;
		this.lasteNameEntry = lasteNameEntry;
		this.emailAddressEntry = emailAddressEntry;
		this.phoneNumberEntry = phoneNumberEntry;
		this.addressEntry = addressEntry;
		this.cityEntry = cityEntry;
		this.stateEntry = stateEntry;
		this.zipCodeEntry = zipCodeEntry;

	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSevenAM() {
		return firstNameEntry;
	}
	public void setSevenAM(String sevenAM) {
		this.firstNameEntry = firstNameEntry;
	}
	public String getEightAM() {
		return lasteNameEntry;
	}
	public void setEightAM(String eightAM) {
		this.lasteNameEntry = lasteNameEntry;
	}
	public String getNineAM() {
		return emailAddressEntry;
	}
	public void setNineAM(String nineAM) {
		this.emailAddressEntry = emailAddressEntry;
	}
	public String getTenAM() {
		return phoneNumberEntry;
	}
	public void setTenAM(String tenAM) {
		this.phoneNumberEntry = phoneNumberEntry;
	}
	public String getElevenAM() {
		return addressEntry;
	}
	public void setElevenAM(String elevenAM) {
		this.addressEntry = addressEntry;
	}
	public String getTwelveAM() {
		return cityEntry;
	}
	public void setTwelveAM(String twelveAM) {
		this.cityEntry = cityEntry;
	}
	public String getonePM() {
		return stateEntry;
	}
	public void setonePM(String onePM) {
		this.stateEntry = stateEntry;
	}
	public String gettwoPM() {
		return zipCodeEntry;
	}
	public void settwoPM(String twoPM) {
		this.zipCodeEntry = zipCodeEntry;
	}
	
	
	@Override
	public String toString() {
		return "<br>Registration Date: " + date + "<br>"
				+ "-------------------------------------<br> "
				+ "First Name : " + firstNameEntry + "<br> " 
				+ "Last Name  : " + lasteNameEntry  + "<br> "							
				+ "Email Address : " + emailAddressEntry  + "<br> "
				+ "Phone Number : " + phoneNumberEntry  + "<br> "
				+ "Address : " + addressEntry  + "<br> "
				+ "City : " + cityEntry  + "<br> "
				+ "State : " + stateEntry  + "<br> "
				+ "Zip Code : " + zipCodeEntry  + "<br>";
	}
	
	public String stringForTable() {
		return "'" + date + "', '" + firstNameEntry + "', '" + lasteNameEntry  
				+ "', '" + emailAddressEntry + "', '" + phoneNumberEntry + "', '" 
				+ addressEntry + "', '" + cityEntry  + "', '" 
				+ stateEntry + "', '" + zipCodeEntry;
	}
}

