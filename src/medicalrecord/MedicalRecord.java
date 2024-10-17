
package medicalrecord;
import java.time.LocalDate;
import java.util.Scanner;

public class MedicalRecord {

    
    public static void main(String[] args) {
 
       String response;
        do{ 
        Scanner sc=new Scanner(System.in);
        
        System.out.println("\n-- Medical Record Management System --");
        System.out.println("1. Add Record");
        System.out.println("2. View Records");
        System.out.println("3. Update Record");
        System.out.println("4. Delete Record");
        System.out.println("5. Exit");
        
        System.out.print("Enter Action: ");
        int action = sc.nextInt();
        
        MedicalRecord Medical =new MedicalRecord();
        
        
        switch(action){
            
            case 1:
                Medical.addMedical();  
            break;
            
            case 2:
                Medical.viewMedical();
                
            break;
            
            case 3:
                Medical.viewMedical();
                Medical.updateMedical();
                Medical.viewMedical();
            break;
            
            case 4:
                Medical.viewMedical();
                Medical.deleteMedical();
                Medical.viewMedical();
            break;
            
            case 5:
                System.out.println("Existing...");
            break;
            default:
                System.out.println("Invalid action. Please try again.");
                
        }
           System.out.print("do you want to continue? (yes or no): ");
           response = sc.next();
  
       }while (response.equalsIgnoreCase("yes"));
        System.out.println("Thank you,see you!");
       }
    
    public void addMedical(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Enter visit date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.print("Enter diagnosis: ");
        String diagnosis = sc.nextLine();
        System.out.print("Enter treatment plan: ");
        String treatment = sc.nextLine(); 
        System.out.println("Record added successfully.");

        String sql = "INSERT INTO tbl_medrecord (med_vdate, med_diag, med_Tplan) VALUES (?, ?, ?)";


        conf.addRecord(sql, date, diagnosis, treatment);


    }
   private void viewMedical() {
        config conf = new config();
        String votersQuery = "SELECT * FROM tbl_medrecord";
        String[] votersHeaders = {"Medical ID", "Medical-visit-Date", "Diagnose", "Treatment Plan"};
        String[] votersColumns = {"med_id", "med_vdate", "med_diag", "med_Tplan"};

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
   
    private void updateMedical(){

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter record ID to update: ");
    int id = sc.nextInt();
    sc.nextLine(); 
    System.out.print("Enter new visit date (YYYY-MM-DD): ");
    LocalDate newDate = LocalDate.parse(sc.nextLine());
    System.out.print("Enter new diagnosis: ");
    String newDiagnosis = sc.nextLine();
    System.out.print("Enter new treatment plan: ");
    String newTreatment = sc.nextLine();
    String qry = "UPDATE tbl_medrecord SET med_vdate = ?, med_diag = ?, med_Tplan = ? WHERE med_id = ?";
    config conf = new config();
    conf.updateRecord(qry, newDate, newDiagnosis, newTreatment, id);
}
    private void deleteMedical(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the id to delete: ");

    int id = sc.nextInt();
    String qry = "DELETE FROM tbl_medrecord WHERE med_id= ?";
    config conf = new config();
    conf.deleteRecord(qry, id);
    
    
}   

}
       
    
    

                    