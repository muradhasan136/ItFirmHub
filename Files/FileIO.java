package Files;
import java.io.*;
import java.util.Scanner;
import Entity.ItFirm;
import EntityList.ItFirmList;

public class FileIO {
    public static boolean cheakUserByNameAndPass(String userName, String userPass) {
        boolean flag = false;
        File file = new File("./Files/users.txt");
        try (Scanner fsc = new Scanner(file)) {

            while (fsc.hasNextLine()) {
                String line = fsc.nextLine();
                String[] data = line.split(";");
                if (userName.equals(data[1]) && userPass.equals(data[2])) {
                    flag = true;
                    break;
                }
            }
        } catch (FileNotFoundException fNFE) {
            System.out.println("File Not Found");
        } catch (Exception ex) {
            System.out.println("Can't Read The File: " + ex.getMessage());
        }
        return flag;
    }
    public static boolean cheakUserByName(String userName) {
        boolean flag = false;
        File file = new File("./Files/users.txt");
        try (Scanner fsc = new Scanner(file)) {

            while (fsc.hasNextLine()) {
                String line = fsc.nextLine();
                String[] data = line.split(";");
                if (userName.equals(data[1])) {
                    flag = true;
                    break;
                }
            }
        } catch (FileNotFoundException fNFE) {
            System.out.println("File Not Found");
        } catch (Exception ex) {
            System.out.println("Can't Read The File: " + ex.getMessage());
        }
        return flag;
    }

    public static void writeUserInFile(String userName, String email, String password){
        File file = new File("./Files/users.txt");
        int userNumber = 0;
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                scanner.nextLine();
                userNumber++;
            }
        }
        catch (FileNotFoundException fNFE){
            System.out.println("File not Found");
        }
        try(FileWriter fileWriter = new FileWriter(file,true)){
            String line = (userNumber+1) + ";" + userName + ";" + password + ";" + email  + "\n";
            fileWriter.write(line);
        }
        catch (IOException IOE){
            System.out.println("I/O Error: " + IOE.getMessage());
        }
    }

    public static void loadItFirmFromFile(ItFirmList itFirmList) {
        File file = new File("./Files/itFirms.txt");
        try (Scanner fsc = new Scanner(file)) {
            while (fsc.hasNextLine()) {
                String line = fsc.nextLine();
                String[] data = line.split(";");
                ItFirm tempFirm = new ItFirm(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), Short.parseShort(data[5]), Integer.parseInt(data[6]), data[7], data[8], data[9], data[10], data[11]);
                itFirmList.insert(tempFirm);
            }
        } catch (FileNotFoundException fNFE) {
            System.out.println("File Not Found");
        } catch (NumberFormatException nFE) {
            System.out.println("Invalid Format");
        }
    }

    public static void writeItFirmInFile(ItFirm firm) {
        File file = new File("./Files/itFirms.txt");
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            String line = firm.getItFirmId() + ";" + firm.getItFirmName() + ";" + firm.getCeoName() + ";" + firm.getEstablishedDate() + ";" + firm.getNumberOfProjectDone() + ";" + firm.getTotalEmployeeNumber() + ";" + firm.getVacancy() + ";" + firm.getFirmType() + ";" + firm.getRanking() + ";" + firm.getFirmAddress() + ";" + firm.getContactNumber() + ";" + firm.getEmailAddress() + "\n";
            fileWriter.write(line);
                /*fileWriter.flush();
                fileWriter.close();
                Automatic flush and close for "try with resources"
                */
        } catch (FileNotFoundException fNFE) {
            System.out.println("File Not Found");
        } catch (IOException iOE) {
            System.out.println("I/O Error: " + iOE.getMessage());
        }
    }

    public static void reWriteItFirmInFile(ItFirmList itFirmList) {
        File file = new File("./Files/itFirms.txt");
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            String firms = itFirmList.getAllItFirmAsStringForIOFile();
            fileWriter.write(firms);

        } catch (FileNotFoundException fNFE) {
            System.out.println("File Not Found");
        } catch (IOException iOE) {
            System.out.println("I/O Error: " + iOE.getMessage());
        }
    }

    public static void removeItFirmFromFile(ItFirmList itFirmList, String itfirmId) {
        System.out.println("removeItFirmFromFile called");
        File file = new File("./Files/itFirms.txt");
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            String[] firms = itFirmList.getAllItFirmAsStringForIOFile().split("\n");
            for (String firm : firms) {
                String[] data = firm.split(";");
                if (!data[0].equals(itfirmId)) {
                    fileWriter.write(firm + "\n");
                }
            }
        } catch (FileNotFoundException fNFE) {
            System.out.println("File Not Found");
        } catch (IOException IOE) {
            System.out.println("I/O Error: " + IOE.getMessage());
        }
    }
}
