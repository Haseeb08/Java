

public class Part3
{
    // instance variables - replace the example below with your own
   
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
    
    public int countGene(String dna)
    {int count=0;
        int startIndex=dna.indexOf("ATG");
        
        while(startIndex!=-1)
        {String gene=findGene(dna,startIndex);
          System.out.println(gene);
          count++;
          startIndex= dna.indexOf("ATG",startIndex+2+gene.length());
        }
        
       return count; 
    }
    public void testcountgene()
    { String dna="ABCATG123123123TAAABATG1213TGABSATG123123TGA";
        System.out.println(countGene(dna));
    }
}
