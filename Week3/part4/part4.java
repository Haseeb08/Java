import org.apache.commons.csv.*;
import edu.duke.*;
import java.io.File;

public class part4
{
    public double averageTemperatureInFile(CSVParser parser)
    { double sum=0;
        int i=0;
        for(CSVRecord r : parser)
        { 
            sum+=Double.parseDouble(r.get("TemperatureF"));
            i++;
        }
        return sum/i; 
    }
    public double averageTemperatureWithHumidyInFile(CSVParser parser,int value)
    { double sum=0;
        int i=0;
        for(CSVRecord r : parser)
        { if(Integer.parseInt(r.get("Humidity"))>=value)
            {sum+=Double.parseDouble(r.get("TemperatureF"));
            i++;
        }
        }
        if(sum>0.0)
        return sum/i; 
        else
        return sum;
    }
        
    public void testAverageTemperatureIWithHumidityinFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        int value = 80;
        double temp=averageTemperatureWithHumidyInFile(parser,value);
        if(temp>0)
        System.out.println("Average temperature with Humidity more than "+value+" : "+temp);
        else
        System.out.println("No Temperature");
    }
    
    public void testAverageTemperatureInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Average temperature : "+averageTemperatureInFile(parser));
    }
    
}
