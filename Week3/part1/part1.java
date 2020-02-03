import org.apache.commons.csv.*;
import edu.duke.*;
public class part1
{
   
    

    public void tester()
    {
    FileResource fr = new FileResource();

    CSVParser parser1 = fr.getCSVParser();
    System.out.println(countryInfo(parser1,"Malawi"));
    
    CSVParser parser2 = fr.getCSVParser();
    listExportersTwoProducts(parser2,"gold","diamonds");
    
    CSVParser parser3 = fr.getCSVParser();
    System.out.println(numberOfExporters(parser3,"gold"));
    
    CSVParser parser4 = fr.getCSVParser();    
    bigExporters(parser4,"$999,999,999");
}

    public String countryInfo(CSVParser parser, String country)
    { String countryDetails="";
        for(CSVRecord record :parser)
        {
            if((record.get("Country")).contains(country))
               { countryDetails=country+" : "+record.get("Exports")+":"+record.get("Value (dollars)");
                break;
            }
        }
    return countryDetails;
    }
    
    public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2)
    { System.out.println("\n\nList of Exporters of "+exportItem1+" and "+exportItem2);
     for(CSVRecord r:parser)
     {
         if(r.get("Exports").contains(exportItem1) && r.get("Exports").contains(exportItem2))
         System.out.println(r.get("Country"));
        } 
        
    }
    
    public int numberOfExporters(CSVParser parser,String exportItem1)
    {int count=0;
        System.out.println("\n\nNumber of countries exporting "+exportItem1);
        for(CSVRecord r:parser)
        {
            if(r.get("Exports").contains(exportItem1))
            count++;
        }
        //System.out.println(count);
        return count;
    }
    
    public void bigExporters(CSVParser parser,String amount)
    {System.out.println("\n\nCountries with value more than "+amount);
     for(CSVRecord r:parser)
     { if(r.get("Value (dollars)").length()>amount.length())
         System.out.println(r.get("Country")+" : "+r.get("Value (dollars)"));
         
        }
    }
}
