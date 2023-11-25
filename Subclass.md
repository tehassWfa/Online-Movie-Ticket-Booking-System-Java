# Online-Movie-Ticket-Booking-System-Java
//Subclass
import java.text.*;
public abstract class BookTicket {
  
  //Data Members
  private String seatType;
  private int quantity;
  private boolean discCode;
  private Customers detail;
  DecimalFormat df = new DecimalFormat("#,###.00");
  
  //Default Constructor
  public BookTicket(){
    seatType = "";
    quantity = 0;
    discCode = false;
  }
  
  //Normal Constructor
  public BookTicket(String cn, String cp, String ce, String st, int qt, boolean dc){
    detail = new Customers(cn,cp,ce);
    seatType = st;
    quantity = qt;
    discCode = dc;
  }
  
  //Setter/Mutator
  public void setSeatType(String st){
    seatType = st;
  }
  
  public void setQuantity(int qt){
    quantity = qt;
  }
  
  public void setDiscCode(boolean dc){
    discCode = dc;
  }
  
  //Getter/Accessor
  public String getSeatType(){
    return seatType;
  }
  
  public int getQuantity(){
    return quantity;
  }
  
  public boolean getDiscCode(){
    return discCode;
  }
  
  public Customers getDetail(){
    return detail;
  }
  
  
  //Abstract Method
  public abstract double calculatePrice();
  
  //Processor
  public double discPrice()
  {
    double price = 0.0;
  
    if(seatType.equalsIgnoreCase("Adult")){
      price = 18.00;
      
    }
    
    else{
      price = 12.00;
    }
  
    if(discCode){
      price = price - (price * 0.10);
    }
      price = price * quantity;
    
    return price;  
    
  }
  
  //Printer
  public String toString(){
    return detail.toString()+ "\nSeat Type : "+seatType+ "\nQuantity : "+quantity+ "\nDiscount Code : "+discCode+"\nPrice: RM"+df.format(discPrice());
  }
}
