
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records=new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method

         FileResource fr = new FileResource(filename);
         for (String log : fr.lines())
         {
             LogEntry e=WebLogParser.parseEntry(log);
             records.add(e);
            }
     }
        
     public int countUniqueIps(){
         ArrayList<String> uIPs = new ArrayList<String>();
        
         for(LogEntry le : records)
         { if(!uIPs.contains(le.getIpAddress()))
               uIPs.add(le.getIpAddress());
            }
           return uIPs.size(); 
        }
        
     public ArrayList uniqueIPVisitsOnDay(String someday){ //MMM DD
                  ArrayList<String> uIPsOnDay = new ArrayList<String>();
                   for (LogEntry le : records) {
                    Date d=le.getAccessTime();
                     String str=d.toString();
                    // System.out.println(str);
                    if(str.contains(someday))
                    uIPsOnDay.add(le.toString());
                    }
                    System.out.println(uIPsOnDay.size());
                    return uIPsOnDay;
     }
     
     public int countUniqueIPsInRange(int low , int high){
         int count=0;
         for(LogEntry le : records){
            int status=le.getStatusCode();
            if(status >=low && status <=high)
            count++;
            }
        return count;
    }
    
    public HashMap countVisitsPerIp(){
        HashMap<String,Integer> myMap=new HashMap<String,Integer>();
            for(LogEntry le : records) {
                    String ip=le.getIpAddress();
                    if(myMap.keySet().contains(ip)){
                    myMap.put(ip,myMap.get(ip)+1);
                    }
                    else {
                    myMap.put(ip,1);
                    }
        }
        return myMap;
    }
    
    public int mostNumberVisitsByIP(HashMap<String,Integer> m){
        int max=0;
        for (String ip : m.keySet()){
                if(m.get(ip)>max)
                    max=m.get(ip);
                }
                return max; 
    }
    
    public ArrayList iPsMostVisits(HashMap<String,Integer> m){
        ArrayList<String> list=new ArrayList<String>();
        int max = mostNumberVisitsByIP(m);
        for (String ip : m.keySet()){
                if(m.get(ip)==max){
                    list.add(ip);
                }
            }
            return list;
    }
    
    public HashMap iPsForDays(){
        HashMap<String, ArrayList<String>> myMap = 
        new HashMap<String, ArrayList<String>>();
        ArrayList<String> list;
        for (LogEntry le : records){
            
        String d=(le.getAccessTime()).toString();
        d=d.substring(4,10);
        if(myMap.keySet().contains(d))
        {  /*if(myMap.get(d).contains(le.getIpAddress()))
            continue;
            else
            */
            myMap.get(d).add(le.getIpAddress());
           // myMap.put(d,list);
        }
        else {
        list=new ArrayList<String>();
        list.add(le.getIpAddress());
        myMap.put(d,list);
        }
        }
        return myMap;
    }
    
    public String daysWithMostIPVisits(HashMap<String, ArrayList<String>> m){
        String date=null;
        int max=0;
        for(String d : m.keySet()){
        if(m.get(d).size()>max){
        max=m.get(d).size();
        date=d;
            }
        }
        
        return date;
    }
     
    public ArrayList iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> m,String date){
        ArrayList<String> list,Iplist;
        list = m.get(date);
        HashMap<String,Integer> MapIpCount = new HashMap<String,Integer>(); 
        for(String ip : list)
        {
        if(MapIpCount.keySet().contains(ip))
            MapIpCount.put(ip,MapIpCount.get(ip)+1);  
        else 
            MapIpCount.put(ip,1);
        }
        Iplist = iPsMostVisits(MapIpCount);
        return Iplist;
    }
    
    public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
