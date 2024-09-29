//import Entity.ItFirm;
import EntityList.ItFirmList;
//import GUI.ItFirmManagement;
import GUI.LoginPage;
//import GUI.SignUp;

public class Start {
    public static void main(String[] args) {
    ItFirmList itFirmList= new ItFirmList();

     /* itFirmList.insert(new ItFirm("10", "Sample1","Tamim","2025",0,(short)4,200,"Local","100","Dhaka","018374627","firmhum@gmail.com"));
      itFirmList.insert(new ItFirm("11", "Sample2","Ratul","2028",0,(short)4,200,"Local","100","Dhaka","018374627","firmhum@gmail.com"));
      itFirmList.insert(new ItFirm("12","Tiger It Bangladesh","Ziaur Rahman","2000",0,(short)759,0,"Local","Top 5","Banani Model Town,Dhaka-1213","02-8826716","info@tigerit.com"));

      itFirmList.getByName("Sample1").setItfirmName("Data Soft");
      itFirmList.getById("10").setCeoName("Mahboob Zaman");
      //itFirmList.removeById("11");
      */


      LoginPage loginPage = new LoginPage();
      //ItFirmManagement itFirmManagement = new ItFirmManagement(itFirmList);
       // SignUp signUp = new SignUp();
    }
}
