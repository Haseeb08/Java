import edu.duke.*;

public class Part3
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
    public StorageResource getAllGene(String dna)
    { 
        StorageResource genelist= new StorageResource();
        
        int startIndex=dna.indexOf("ATG");
        while(startIndex!= -1)
        {String gene=findGene(dna,startIndex);
          if(gene.isEmpty()==false)
          genelist.add(gene);
         startIndex= dna.indexOf("ATG",startIndex+gene.length());   
        
        }    
    return genelist;
    }
    
    public float CGratio(String dna)
    { float ratio;
        int count=0;
        
        for(int i=0;i<dna.length();i++)
        if(dna.charAt(i)=='C' || dna.charAt(i)=='G')
        count++;
        
        //System.out.println("CGs"+count);
        ratio=(float)count/dna.length();
        return ratio;
    }
    
    public void processGenes(StorageResource sr)
    {
        StorageResource cg_genes=new StorageResource();
        int genes_len=0;
        int max_length=0;
        int genes_cg=0;
        
        System.out.println("Genes with lenght greater than 9 :\n");
        for(String gene:sr.data())
        { int length=gene.length();
            if(max_length<length) max_length=length; 
            if(length>9)
            { 
                System.out.println(gene);
                genes_len++;
            }
          float cg=CGratio(gene);
          if(cg>0.35)
          {
            cg_genes.add(gene);
            genes_cg++;
            }
        }
        
        System.out.println("Genes with CG ratio higher than 0.35 :\n");
        for(String gene:cg_genes.data())
        System.out.println(gene);
        
        System.out.println("Number of dna in sr that are longer than 9 characters :"+genes_len);
        System.out.println("Number of dna in sr whose C-G-ratio is higher than 0.35 :"+genes_cg);
        System.out.println("Length of longest gene :"+max_length);
    }
    
    public void testProcess()
    {
        //FileResource fr = new FileResource();
        //String dna = fr.asString();
        String dna1 = "atg123taavgxvdxatgctggtctagatggctag";
        //String dna="ATG123123123TAAATG123123123456TAG";
        
       //String dnau=dna1.toUpperCase();
        System.out.println(dna1);
        //StorageResource s=getAllGene(dna);
       // for(String gene:s.data())
        //System.out.println(gene); 
        //dna1=dna1.toUpperCase();
       processGenes(getAllGene(dna1.toUpperCase()));
    }
}
