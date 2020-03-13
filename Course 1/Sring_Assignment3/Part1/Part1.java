import edu.duke.*;

public class Part1
{
    
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
    
    /*public void testFindStopCodon()
    {
        String dna="ATG123123TAA";
        int startIndex=dna.indexOf("ATG");
        int endIndex=findStopcodon(dna,startIndex,"TAA");
        if(endIndex==dna.length())
        System.out.println("No gene Found");
        else
        System.out.println(dna.substring(startIndex,endIndex+3));
    }
    */
   
   
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
    
    public StorageResource getAllGene(String dna)
    { 
        StorageResource genelist= new StorageResource();
        
        int startIndex=dna.indexOf("ATG");
        while(startIndex!=-1)
        {String gene=findGene(dna,startIndex);
          if(gene.isEmpty()==false)
          genelist.add(gene); //System.out.println(gene);}
       
         startIndex= dna.indexOf("ATG",startIndex+gene.length());   
        
        }    
    return genelist;
    }
    
    public void testGetallGene()
    {
       //String dna="ATG123TAAATG112233TAGATG123123123123123TGA";
       /* System.out.println("\nPRINTING ALL GENES :\n";
        printAllGene(dna);
        */
       String dna2="atg123123123taaatg123tagatg123123tga";
       //System.out.print(dna2.toUpperCase());
        System.out.println("\nALL GENES FROM GENE LIST\n");
        //dna=dna.toUpperCase();
        StorageResource s=getAllGene(dna2.toUpperCase());
        //printAllGene(dna2.toUpperCase());
       // for(String gene:s.data())
        //System.out.println(gene);        
        
        for(String gene:s.data())
        System.out.println(gene);        
        
    }
}
