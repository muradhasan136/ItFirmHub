package EntityList;
import Entity.ItFirm;

public class ItFirmList{
    private ItFirm[] itFirm;
    
    public ItFirmList(){
        itFirm=new ItFirm[4500];
    }
    public ItFirmList(int size){
        itFirm=new ItFirm[size];
    }
    
    public void insert(ItFirm firm) {
        boolean flag = false;
        for (int i = 0; i < itFirm.length; i++) {
            if (itFirm[i] == null) {
                itFirm[i] = firm;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Firm Inserted Successfully");
            } else {
            System.out.println("Insertion Failed!");
        }
    }

    public ItFirm getByName(String firmName){
        boolean flag = false;
        ItFirm firm = null;
        for(int i=0; i<itFirm.length; i++){
            if(itFirm[i]!=null){
                if(itFirm[i].getItFirmName().equalsIgnoreCase(firmName)){
                    firm = itFirm[i];
                    flag = true;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("Found It Firm.");
        }
        else{
            System.out.println("No ItFirm with this name!");
        }
        return firm;
    }

    public ItFirm getById(String itFirmId){
        boolean flag = false;
        ItFirm firm = null;
        for(int i=0; i<itFirm.length; i++){
            if(itFirm[i]!=null){
                if(itFirm[i].getItFirmId().equals(itFirmId)){
                    firm = itFirm[i];
                    flag = true;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("Found It Firm.");
        }
        else{
            System.out.println("No ItFirm with This Id!");
        }
        return firm;
    }
    
    /*public void removeByName(String firmName){
        boolean flag=false;
        for(int i=0; i<itFirm.length; i++){
            if(itFirm[i] !=null && itFirm[i].getItFirmName().equals(firmName)){
                itFirm[i]=null;
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("Firm Removed");
        }
        else
        {
            System.out.println("No firm found.");
        }
    }*/

    public void removeById(String itFirmId){
        boolean flag=false;
        for(int i=0; i<itFirm.length; i++){
            if(itFirm[i] !=null && itFirm[i].getItFirmId().equals(itFirmId)){
                itFirm[i]=null;
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("Firm Removed");
        }
        else
        {
            System.out.println("No firm found.");
        }
    }

    public String getAllItFirmAsString(){
        String allItFirm = "";
        for(int i=0; i<itFirm.length; i++){
            if(itFirm[i] != null) {
                allItFirm += "----------------------------------------------------------------------------------------------------------" +
                        "\n" + itFirm[i].getItFirmAsString() + "\n"
                           + "----------------------------------------------------------------------------------------------------------" + "\n";
            }
        }
        return allItFirm;
    }
    //for FileIO
    public String getAllItFirmAsStringForIOFile(){
        String allItFirm = "";
        for (int i = 0; i<itFirm.length; i++){
            if(itFirm[i] !=null){
                allItFirm += itFirm[i].getItFirmAsStringForFileIO();
            }
        }
        return allItFirm;
    }
    
    public void updateFirm(String itFirmId,String itFirmName, String ceoName, String establishedDate, int numberOfProjectDone, short totalEmployeeNumber, int vacancy, String firmType, String ranking, String firmAddress, String contactNumber, String emailAddress){
        boolean flag = false;
        for (int i = 0; i<itFirm.length; i++){
            if (itFirm[i] !=null && itFirm[i].getItFirmId().equals(itFirmId)){
                if(!itFirmName.isEmpty()){
                    itFirm[i].setItfirmName(itFirmName);
                }
                if (ceoName != null && !ceoName.isEmpty()) {
                    itFirm[i].setCeoName(ceoName);
                }
                if(establishedDate != null){
                    itFirm[i].setEstablishedDate(establishedDate);
                }
                if(numberOfProjectDone != 0){
                    itFirm[i].setNumberOfProjectDone(numberOfProjectDone);
                }
                if(totalEmployeeNumber != 0){
                    itFirm[i].setTotalEmployeeNumber(totalEmployeeNumber);
                }
                if(vacancy !=0){
                    itFirm[i].setVacancy(vacancy);
                }
                if(firmType !=null){
                    itFirm[i].setFirmType(firmType);
                }
                if (ranking != null && !ranking.isEmpty()) {
                    itFirm[i].setRanking(ranking);
                }
                if (firmAddress != null && !firmAddress.isEmpty()) {
                    itFirm[i].setFirmAddress(firmAddress);
                }
                if (contactNumber != null && !contactNumber.isEmpty()) {
                    itFirm[i].setContactNumber(contactNumber);
                }
                if(emailAddress !=null){
                    itFirm[i].setEmailAddress(emailAddress);
                }
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("Firm Update Successfully");
        }
        else{
            System.out.println("Not found firm with this id");
        }
    }
    
   // public void sortByRanking(){}

    /*public void sortFirmsByType(String firmType) {
        boolean found = false;
        for (int i = 0; i < itFirm.length; i++) {
            if (itFirm[i] != null && itFirm[i].getFirmType().equalsIgnoreCase(firmType)) {
                itFirm[i].getItFirmAsString();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No firms found of type: " + firmType);
        }
    }*/
}


