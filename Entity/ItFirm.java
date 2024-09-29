package Entity;
public class ItFirm {
	private String itFirmId;
	private String itFirmName;
	private String ceoName;
	private String establishedDate;
	private int numberOfProjectDone;
	private short totalEmployeeNumber;
	private int vacancy;
	private String firmType;
	private String ranking;
	private String firmAddress;
	private String contactNumber;
	private String emailAddress;
	private static int itFirmCounter=0;

	public ItFirm(String itFirmId,String itFirmName, String ceoName, String establishedDate, int numberOfProjectDone, short totalEmployeeNumber, int vacancy, String firmType, String ranking, String firmAddress, String contactNumber, String emailAddress) {
		setItFirmId(itFirmId);
		setItfirmName(itFirmName);
		setCeoName(ceoName);
		setEstablishedDate(establishedDate);
		setNumberOfProjectDone(numberOfProjectDone);
		setTotalEmployeeNumber(totalEmployeeNumber);
		setVacancy(vacancy);
		setFirmType(firmType);
		setRanking(ranking);
		setFirmAddress(firmAddress);
		setContactNumber(contactNumber);
		setEmailAddress(emailAddress);
		itFirmCounter++;
	}

	public void setItFirmId(String itFirmId){ this.itFirmId = itFirmId; }
	public String getItFirmId() { return this.itFirmId ;}

	public void setItfirmName(String itFirmName) {
		this.itFirmName = itFirmName;
	}
	public String getItFirmName() {
		return this.itFirmName;
	}
	
	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
	public String getCeoName() {
		return this.ceoName;
	}
	
	public void setEstablishedDate(String establishedDate) {
		this.establishedDate = establishedDate;
	}
	public String getEstablishedDate() {
		return this.establishedDate;
	}
	
	public void setNumberOfProjectDone(int numberOfProjectDone) {
	if(numberOfProjectDone>=0){this.numberOfProjectDone = numberOfProjectDone;}
	}
	public int getNumberOfProjectDone() {return this.numberOfProjectDone;}
	
	public void setTotalEmployeeNumber(short totalEmployeeNumber) {
		if(totalEmployeeNumber>=0){this.totalEmployeeNumber = totalEmployeeNumber;
		}
	}
	public short getTotalEmployeeNumber() {return this.totalEmployeeNumber;}
	
	public void setVacancy(int vacancy) {this.vacancy = vacancy;}
	public int getVacancy() {return this.vacancy;}
	
	public void setFirmType(String firmType) {
		this.firmType = firmType;
	}
	public String getFirmType() {
		return this.firmType;
	}
	
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	public String getRanking() {
		return ranking;
	}
	
	public void setFirmAddress(String firmAddress) {
		this.firmAddress = firmAddress;
	}
	public String getFirmAddress() {
		return this.firmAddress;
	}
	
	public void setContactNumber(String contactNumber) {
		/*if (contactNumber.length() != 11) {
			System.out.println("Error Input");
			}
		else {
			this.contactNumber = contactNumber;
		}*/
		this.contactNumber = contactNumber;
	}
	public String getContactNumber() {return this.contactNumber;}
	
	public void setEmailAddress(String emailAddress) {
		if (emailAddress.endsWith(".com")){
			this.emailAddress = emailAddress;}
		else{
			System.out.println("Invalid Email Address");
		}
	}
	public String getEmailAddress() {return this.emailAddress;}

	public String getItFirmAsString() {
		return  " ItFirm ID                            : " + itFirmId + "\n" +
				" ItFirm Name                      : " + itFirmName + "\n" +
				" CEO Name                        : " + ceoName + "\n" +
				" Established Year               : " + establishedDate + "\n" +
				" Number of Project Done  : " + numberOfProjectDone + "\n" +
				" Total Employee                 : " + totalEmployeeNumber + "\n" +
				" Vacancy Available            : " + vacancy + "\n" +
				" ItFirm Type                        : " + firmType + "\n" +
				" Ranking                             : " + ranking + "\n" +
				" ItFirm Address                   : " + firmAddress + "\n" +
				" Contact Number               : " + contactNumber + "\n" +
				" Email Address                   : " + emailAddress;
	}
	public String getItFirmAsStringForFileIO(){
		return itFirmId + ";" + itFirmName + ";" + ceoName + ";" + establishedDate + ";" + numberOfProjectDone + ";" + totalEmployeeNumber + ";" + vacancy + ";" +firmType + ";" + ranking + ";" +firmAddress + ";" + contactNumber + ";" + emailAddress + "\n";
	}

	public static void totalNumberOfUniqueItFirm(){
		System.out.println("Total Number Of Unique ItFirm: " + itFirmCounter);
	}
}