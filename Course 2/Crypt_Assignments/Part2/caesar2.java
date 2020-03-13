
public class caesar2
{
    
    public void testCaesarWith2keys()
    {
       System.out.println(encryptTwoKeys("First Legion",23,17)); 
    }
    public String encryptTwoKeys(String phrase,int key1,int key2)
    {
    String encrypted="";
    
        String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted_alpha1=alpha.substring(key1)+alpha.substring(0,key1);   
        String shifted_alpha2=alpha.substring(key2)+alpha.substring(0,key2);
      
    for(int i=0;i<phrase.length();i++)
    { 
        char ch=phrase.charAt(i);
        int flag=0;
        int index;
        if(i%2==0)
        {
           if(Character.isUpperCase(ch)==false) 
           {   flag=1 ;
               index=alpha.indexOf(Character.toUpperCase(ch));
            }
           else
           index=alpha.indexOf(ch);
         
           if(index!=-1)
           {
                if(flag==1)
                    encrypted=encrypted+Character.toLowerCase(shifted_alpha1.charAt(index));
                 else
                    encrypted=encrypted+shifted_alpha1.charAt(index);
           }
           else
           encrypted+=' '; 
            
        }
        else
        {
            if(Character.isUpperCase(ch)==false) 
           {   flag=1 ;
               index=alpha.indexOf(Character.toUpperCase(ch));
            }
           else
           index=alpha.indexOf(ch);
         
           if(index!=-1)
           {
                if(flag==1)
                    encrypted=encrypted+Character.toLowerCase(shifted_alpha2.charAt(index));
                 else
                    encrypted=encrypted+shifted_alpha2.charAt(index);
           }
           else
           encrypted+=' '; 
        }
    }
    return encrypted;
}


   
    
    
}