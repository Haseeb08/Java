
/**
 * Write a description of class Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1
{
    // instance variables - replace the example below with your own
    
    public int findStopcodon(String dna,int startIndex,String stopCodon)
    { 
        int currIndex=dna.indexOf(stopCodon,startIndex+3);
        while(currIndex!=-1)
        {
        if((currIndex-startIndex)%3==0)
        return currIndex;
        else 
        currIndex=dna.indexOf(stopCodon,currIndex+1);
        
        }
        return -1;
        
    }
    
    public void testFindStopCodon()
    {
        String dna="ATG123123TAA";
        int startIndex=dna.indexOf("ATG");
        int endIndex=findStopcodon(dna,startIndex,"TAA");
        if(endIndex==dna.length())
        System.out.println("No gene Found");
        else
        System.out.println(dna.substring(startIndex,endIndex+3));
    }
    
    public String findGene(String dna,int startIndex)
  {int minIndex=0;
     //nt startIndex=dna.indexOf("ATG");
     if(startIndex!=-1) 
     { int indexTAA=findStopcodon(dna,startIndex,"TAA");
       int indexTAG=findStopcodon(dna,startIndex,"TAG");
       int indexTGA=findStopcodon(dna,startIndex,"TGA");
       //System.out.println(" "+indexTAA+" "+indexTAG+" "+indexTGA); 
      
      if(indexTAA==-1 ||  (indexTAG!=-1 && indexTAA>indexTAG) )
    minIndex=indexTAG;
    else minIndex=indexTAA;
    if(minIndex==-1 ||  (indexTGA!=-1 && minIndex>indexTGA) )
    minIndex=indexTGA;
      //System.out.println(minIndex);
      if(minIndex!=-1)
       return dna.substring(startIndex,minIndex+3); 
    else 
    return "";
    }
     else 
     return "";
    }
    
    public void printAllGene(String dna)
    {
        int startIndex=dna.indexOf("ATG");
        
        while(startIndex!=-1)
        {String gene=findGene(dna,startIndex);
          System.out.println(gene);
          
          startIndex= dna.indexOf("ATG",startIndex+2+gene.length());
        
        
        
        
        
        
        
        
        
        }
        
        
        
        
        
    }
    public void testfindGene()
    {
        /*String dna1="ATG123123TAA";
        String dna2="XYZATG1234TAA123TAGCBT";
        String dna3="XYZHATG12345TAA15TAG123TGA";
        String dna4="ATG123123TAG";
        String dna5="ATG123123TGA";
        String dna6="ATG1TAA2TAG3TGA123";
        System.out.println("Dna :" +dna1+ "\nGene :" +findGene(dna1));
        System.out.println("Dna :" +dna2+ "\nGene :" +findGene(dna2));    
        System.out.println("Dna :" +dna3+ "\nGene :" +findGene(dna3));
        System.out.println("Dna :" +dna4+ "\nGene :" +findGene(dna4));
        System.out.println("Dna :" +dna5+ "\nGene :" +findGene(dna5));
        System.out.println("Dna :" +dna6+ "\nGene :" +findGene(dna6));
*/
String dna="acaagtttgtacaaaaaagcagaagggccgtcaaggcccaccatgcctattggatccaaagagaggccaacattttttgaaatttttaagacacgctgcaacaaagcagatttaggaccaataagtcttaattggtttgaagaactttcttcagaagctccaccctataattctgaacctgcagaagaatctgaacataaaaacaacaattacgaaccaaacctatttaaaactccacaaaggaaaccatcttataatcagctggcttcaactccaataatattcaaagagcaagggctg";
System.out.println("Dna  : "+dna);
 printAllGene(dna.toUpperCase());
    } 
}
