import org.apache.commons.csv.*;
import edu.duke.*;
import java.io.File;

public class part3
{
    // instance variables - replace the example below with your own
    public CSVRecord lowestHumidityInFile(CSVParser parser)
    {
     CSVRecord lowHumidRecord=null;
     for(CSVRecord r:parser)
     { if(lowHumidRecord==null)
         lowHumidRecord=r;
         
         else
         {
         if(check(r,lowHumidRecord)==true)
         lowHumidRecord=r;
        }
    } 
        return lowHumidRecord;
    }
    public boolean check(CSVRecord r1,CSVRecord r2)
    {         if(Double.parseDouble(r1.get("Humidity"))< Double.parseDouble(r2.get("Humidity")))
                return true;
                else 
                return false;
    }
    public void testLowHumidyInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        
        System.out.println("Lowest Humidity : "+csv.get("Humidity")+" "+csv.get("DateUTC")); 
    }
    
    public CSVRecord lowestHumidityInManyFile()
    {
        DirectoryResource dr=new DirectoryResource();
        CSVRecord humidRecord=null;
        for(File f : dr.selectedFiles()) 
        {
            FileResource fr=new FileResource(f);
        CSVParser parser= fr.getCSVParser();
        CSVRecord currRecord = lowestHumidityInFile(parser);
        
        if(humidRecord==null)
        humidRecord=currRecord;
        else
        { if(check(currRecord,humidRecord)==true)
                {humidRecord=currRecord; 
                 }
    }
   }
return humidRecord;
} 

public void testLowestHumidityInManyFile()
{
    CSVRecord record= lowestHumidityInManyFile();
    System.out.println(record.get("DateUTC")+" "+record.get("Humidity"));
    
}
}
