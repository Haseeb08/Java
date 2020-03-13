

public class Part3
{
   
   
   
    public boolean twoOccurences(String a,String b)
    {
       
      if(b.indexOf(a, b.indexOf(a)+a.length())>0)
        return true;
        else 
        return false;
      
        
    }
    public void testing()
    {   System.out.println(twoOccurences("by", "A story by abby long"));
    System.out.println(twoOccurences("a", "banana"));
    System.out.println(twoOccurences("atg", "ctgtatgta"));
    
    System.out.println(lastPart("an", "banana"));
    System.out.println(lastPart("zoo", "Forest"));
    }
    
    public String lastPart(String a,String b)
    {
        int i=b.indexOf(a);
        if(i>0) return b.substring(i+a.length());
        else return b;
    }
}
