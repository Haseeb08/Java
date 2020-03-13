
public class caesar
{
    public String encrypt(String msg,int key)
    { String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String shifted_alpha=alpha.substring(key)+alpha.substring(0,key);   
      String encrypted="";
      int index=0;
      
      for(int i=0;i<msg.length();i++)
      { //String str=msg;
         char ch=msg.charAt(i);
      int flag=0;
      if(Character.isUpperCase(ch)==false) 
        { flag=1 ;
          index=alpha.indexOf(Character.toUpperCase(ch));
        }
      else
        index=alpha.indexOf(ch);
         
     if(index!=-1)
     {
         if(flag==1)
         encrypted=encrypted+Character.toLowerCase(shifted_alpha.charAt(index));
         else
         encrypted=encrypted+shifted_alpha.charAt(index);
      }
     else
      encrypted+=' ';
     
    }
    return encrypted;
    }
    
    public void testCaesar()
    {
       System.out.println(encrypt("First Legion",2)); 
    }

}
