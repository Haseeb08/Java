

public class PArt2
{
    
    public float CGratio(String dna)
    { float ratio;
        int count=0;
        
        for(int i=0;i<dna.length();i++)
        if(dna.charAt(i)=='C' || dna.charAt(i)=='G')
        count++;
        
        System.out.println("CGs"+count);
        ratio=(float)count/dna.length();
        return ratio;
    }
    
    public int countCTG(String dna)
    {
     int count=0;  
     int st=dna.indexOf("CTG");
     while(st!=-1)
     {   count++;
         st=dna.indexOf("CTG",st+3);
        }   
     
      return count;  
    }

    public void test()
    {
        String dna="ATGCCATAG";
        System.out.println("Dna length :"+dna.length());
        System.out.println("DNA : "+dna+"\nCG ratio :"+CGratio(dna)+"\nCount CTG :"+countCTG(dna)); 
    }
}


