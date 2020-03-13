package VigenereProgram;

import java.io.*;
import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    String correctLanguage;
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder str=new StringBuilder();
        for(int i=whichSlice;i<message.length();i=i+totalSlices)
        {
            str.append(message.charAt(i));
        }
        return str.toString();
    }

   public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];    
        for(int i=0;i<klength;i++){
        String s=sliceString(encrypted,i,klength);
        CaesarCracker c=new CaesarCracker();
        key[i]=c.getKey(s);
        //System.out.println(key[i]);
        }
        return key;
   }
   
   public HashSet readDictionary(FileResource fr){
    HashSet<String> set = new HashSet<String>();
    for(String line : fr.lines()){
        line=line.toLowerCase();
        set.add(line);
        
    }
    return set;
    }
    
   public int countWords(String msg, HashSet<String> Dic){
    int count=0;  
    String[] words=msg.split("\\W+");
    for(String w : words){
    if(Dic.contains(w))
    count++;
    }    
    return count;
    }
    
   public int breakForLanguage(String encrypted,HashSet<String> Dic){
   int maxKey=0;
   int max=0;
       for(int key=1;key<=100;key++){
       VigenereCipher vc= new VigenereCipher(tryKeyLength(encrypted,key,'e'));
        String decrypted = vc.decrypt(encrypted);
        int realWords=countWords(decrypted,Dic);
        if(realWords>max){
        max=realWords;
        maxKey=key;
        }
        
   }
   return maxKey;
    }
    
   public char mostCommonCharIn(HashSet<String> Dic){
       char mostCommon='a';
       HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();
       
       for(String word : Dic){
           word=word.toLowerCase();
           for(int i=0;i<word.length();i++){
               char ch=word.charAt(i);
               if(charMap.keySet().contains(ch))
                charMap.put(ch,charMap.get(ch)+1);
               else 
                charMap.put(ch,1);
            }
        }
        //System.out.println(charMap);
        int max=0;
        for(char c : charMap.keySet()){
            if(charMap.get(c)>max)
            {
            max=charMap.get(c);
            mostCommon=c;
            }
        }
        
        /*
        char mostCommon = Collections.max(charMap.entrySet(), 
        Map.Entry.comparingByValue()).getKey();
        
        int maxValueInMap=(Collections.max(charMap.values()));  // This will return max value in the Hashmap
        for (Entry<Character, Integer> entry : charMap.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                System.out.println(entry.getKey());     // Print the key with max value
            }
        }
        */
       return mostCommon;
       
   }
   
   public void breakForAllLangs(String encrypted,HashMap<String,HashSet<String>> languages){
       int realWordsCount=0;
       int max=0;
       char mostCommon='a';
       String ans="";
       String langName="";
   HashSet<String> dic=new HashSet<String>();
   for(String lang : languages.keySet()){
       dic = languages.get(lang);
       mostCommon=mostCommonCharIn(languages.get(lang));
       
       for(int key=1;key<=100;key++){
           //int max=0;
           int keys[]=tryKeyLength(encrypted,key,mostCommon);
       VigenereCipher vc= new VigenereCipher(keys);
        String decrypted = vc.decrypt(encrypted);
        realWordsCount=countWords(decrypted,dic);
        if(realWordsCount>max){
        max=realWordsCount;
        ans=decrypted;
        //maxKeyofLang=key;
        langName=lang;
        }
      }  
      System.out.println(lang +"  "+ realWordsCount);
    }
    System.out.println("Language : "+langName+"\nDecrypted msg :  \n"+ans);
    
 }

 public HashMap<String,HashSet<String>> createMap(){
    
       HashMap<String,HashSet<String>> dictionaryMap=new HashMap<String,HashSet<String>>();
        DirectoryResource dr=new DirectoryResource();
        for(File F : dr.selectedFiles()){
            FileResource fR = new FileResource(F);
            if(!dictionaryMap.keySet().contains(F.getName()))
            dictionaryMap.put(F.getName(),readDictionary(fR));            
        }
        //System.out.println(MAP);
        return dictionaryMap;
  }
  
   public void breakVigenere () {
        FileResource fr = new FileResource();   //Taking encrypted file.
        String s=fr.asString();                        
        VigenereBreaker vb= new VigenereBreaker();
        breakForAllLangs(s,vb.createMap());
        
        
        
        
        
        //FileResource f = new FileResource();  //Dictionary
        
        
        //System.out.println(mostCommonCharIn(readDictionary(f)));
        //int key = vb.breakForLanguage(s,readDictionary(f));
        //VigenereCipher vc= new VigenereCipher(tryKeyLength(s,key,'e'));
        //String ans = vc.decrypt(s);
        //System.out.println(ans);
         
      //  FileResource fr = new FileResource();   //Encrypted file
        //String s=fr.asString();
        
        
        
      /*  int key=vb.breakForAllLangs(s,MAP);
        VigenereCipher vc= new VigenereCipher(tryKeyLength(s,key,
        mostCommonCharIn(MAP.get(correctLanguage))));
      String ans = vc.decrypt(s);
      System.out.println(ans);
    */}
    
}
