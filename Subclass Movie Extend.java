# Online-Movie-Ticket-Booking-System-Java
//Subclass
import java.text.*;
import java.util.*;
public class Movie extends BookTicket{
  
  private String genre;
  private char packages;
  private DateTime dt;
  DecimalFormat df = new DecimalFormat("#,###.00");
 
  
  //Normal Constructor
  public Movie(String cn, String cp, String ce,String st, int qt, boolean dc,String gr, char pc,String dy,String mh,String yr,String tm){
    super(cn,cp,ce,st,qt,dc);
    genre = gr;
    packages = pc;
    dt = new DateTime(dy,mh,yr,tm);
    
  }
  
  //Setter/Mutator
  public void setGenre(String gr){
    genre = gr;
  }
  
  public void setPackages(char pc){
    packages = pc;
  }
  
  
  //Getter/Accessor
  public String getGenre(){
    return genre;
  }
  
  public char getPackages(){
    return packages;
  }
  public DateTime getDt(){
    return dt;
  }
  
  
  //Abstract Method 
  public double calculatePrice(){
     double price = 0;
     
     if(getPackages() == 'A' || getPackages() == 'a'){
       price = 10.00;
     }
       
     
     else if (getPackages() == 'B' || getPackages() == 'b'){
       price = 14.00;
       
     }

     return price;
  }
    
  //Printer
  public String toString(){
    return super.toString()+"\nGenre : "+genre+ "\nPackage : "+packages+"\nPrice of food package choosen: RM"+df.format(calculatePrice())+"\nDate : " +dt+ "\nTime : "+dt.getTime();  
  }
  
}
