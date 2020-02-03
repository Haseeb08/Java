import org.apache.commons.csv.*;
import edu.duke.*;
import java.io.File;

public class Part2
{
   public CSVRecord coldestHourInFile(CSVParser parser)
   {
    CSVRecord coldestRecord=null;
       for(CSVRecord currRecord : parser)
       {    if(coldestRecord==null)
           coldestRecord=currRecord;
           else 
            {
                if(check(coldestRecord,currRecord))
                coldestRecord=currRecord;

            }
           
        }
    return coldestRecord;
    }
   public boolean check(CSVRecord coldestRecord,CSVRecord currRecord)
   {
       if(Double.parseDouble(currRecord.get("TemperatureF"))< Double.parseDouble(coldestRecord.get("TemperatureF")))
           return true;
    
        return false;
    }
    
    /*public void testColdestHour()
    {
        FileResource fr=new FileResource(f);
        CSVParser parser= fr.getCSVParser();
        
        CSVRecord coldestRecord = coldestHourInFile(parser);
        System.out.println("Coldest Hour :\n"+coldestRecord.get("DateUTC")+" "+coldestRecord.get("TemperatureF"));
    }*/
    
    public String fileWithColdestTemperature()
    {
        String nameOfFile="";
        double temp=0.0;
     DirectoryResource dr = new DirectoryResource();
     CSVRecord coldestSoFar=null;
        for(File f : dr.selectedFiles()) 
        {
            FileResource fr=new FileResource(f);
        CSVParser parser= fr.getCSVParser();
        CSVRecord currRecord = coldestHourInFile(parser);
        
        if(coldestSoFar==null)
        coldestSoFar=currRecord;
        else
        { if(check(coldestSoFar,currRecord))
                { coldestSoFar=currRecord; 
                       nameOfFile=f.getName(); 
                    //temp=currRecord.get("TemperatureF");
                    }
    }
   }
return nameOfFile;
}

void TestfileWithColdestTemperature()
{ String file=fileWithColdestTemperature();
    
    FileResource fr=new FileResource("/home/abdul/Desktop/Haseeb/Java/week3/nc_weather/2014/"+file);
 System.out.println("File name : "+file);
 CSVParser parser= fr.getCSVParser();
 CSVRecord coldest = coldestHourInFile(parser);
 System.out.print("Temperature is : "+coldest.get("TemperatureF"));
 CSVParser parser1= fr.getCSVParser();
 for(CSVRecord record : parser1)
 System.out.println(record.get("DateUTC")+" "+record.get("TemperatureF"));
 
}
}