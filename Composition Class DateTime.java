# Online-Movie-Ticket-Booking-System-Java
//Composition Class
public class DateTime {
  
  //Data DateTime
  private String day;
  private String month;
  private String year;
  private String time;
  
  //Method DateTime
  //Default Constructor 
  public DateTime(){
    day = "";
    month = "";
    year = "";
   time = "";
  
  }
  
  //Normal Constructor
  public DateTime(String dy, String mh, String yr, String tm){
    day = dy;
    month = mh;
    year = yr;
    time = tm;
    
  }
  
 
  //Setter
  public void setDay(String dy){
    day = dy;
  }
  
  public void setMonth(String mh){
    month = mh;
  }
  
  public void setYear(String yr){
    year = yr;
  }
  
  public void setTime(String tm){
    time = tm;
  }
  
  //Getter
  public String getDay(){
    return day;
  }
  
   public String getMonth(){
    return month;
  }
  
   public String getYear(){
    return year;
  }
  
  public String getTime(){
    return time;
  }


  //Printer
  public String toString(){
   return String.format("%s/%s/%s", day, month, year);
  }
}
