import java.util.*;
import java.io.*;
public class Wordplay
{
    public boolean isVowel(char ch)
    { char c=Character.toLowerCase(ch);
        if(c=='a' || c=='e' || c=='i' || c=='o' ||c=='u' )
        return true;
        else return false;
        
    }
    
    void testVowel()
    {
        char ch='I';
        System.out.print(isVowel(ch));
    
    }
    
    public String replaceVowel(String phrase,char ch)
    { 
        String res="";
        int i=0;
        int len=phrase.length();
        while(len>0)
        {len--;
            char c=phrase.charAt(i++);
            if(isVowel(c))
            res=res+"*";
            else
            res=res+c;
        }  
    return res;
    }
    
    void testReplaceVowel()
    { String phrase="Hello World";
      char ch='*';  
      System.out.println(replaceVowel(phrase,ch));   
    }
    
    public String emphasize(String phrase,char ch)
    {StringBuilder res=new StringBuilder(phrase.toLowerCase());
        int index=phrase.indexOf((Character.toLowerCase(ch)));
        //int len=phrase.length();
        while(index>0)
        { //len--;
            if((index+1)%2==0)
            res.setCharAt(index,'+');
            else
            res.setCharAt(index,'*');
            index=phrase.indexOf(ch,index+1);
        }
    return res.toString();
    }
    
    void testEmphasize()
    { String phrase="dna ctgaaactga";
      char ch='a';  
      System.out.println(emphasize(phrase,ch));
    }
}