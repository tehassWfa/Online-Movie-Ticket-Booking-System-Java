# Online-Movie-Ticket-Booking-System-Java
//Superclass
public class Customers{
  
  //Data attributes
  private String custName;
  private String custPhone;
  private String custEmail;
  
  //Default Constructor 
  public Customers(){
    custName = "";
    custPhone = "";
    custEmail = "";
  }
  
  //Normal Constructor
  public Customers(String cn,String cp,String ce){
    custName = cn;
    custPhone = cp;
    custEmail = ce;
  }
  
  //Setter 
  public void setCustName(String cn){
    custName = cn;
  }
  public void setCustPhone(String cp){
    custPhone = cp;
  }
  public void setCustEmail(String ce){
    custEmail = ce;
  }
  
  //Getter
  public String getCustName(){
    return custName;
  }
  public String getCustPhone(){
    return custPhone;
  }
  public String getCustEmail(){
    return custEmail;
  }
  
  
  //Printer 
  public String toString(){
    return "\nCustomer's Name : "+custName+"\nCustomer's Phone Number : "+custPhone+"\nCustomer's Email : "+custEmail;
  
  }
}
