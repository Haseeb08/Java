
public class Part2
{
    public int howMany(String a, String b)
    { System.out.println(a+" \n"+b);
     int count=0;
     int st=b.indexOf(a);
     while(st!=-1)
     {   count++;
         st=b.indexOf(a,st+a.length());
        }   
      return count;  
    }
    
    public void testHowmany()
    {
     System.out.println(howMany("an","banana"));   
     System.out.println(howMany("aa","aaaaaa"));
     System.out.println(howMany("abxc","bcwijabxcweijfdjewfbjbceabxc"));
     System.out.println(howMany("12","122112212"));

    }
    
}
