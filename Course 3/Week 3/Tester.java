
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{   public void Test(){
    
    }
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
        
    }
    
    public void testUniqueIPs() {
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println("Unique IP addresses are : "+la.countUniqueIps());        //la.printAll();
    }
    
    public void testUniqueIPsOnday() {
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog-short_log");
        System.out.println("Unique IP addresses on sep 14: "+
        la.uniqueIPVisitsOnDay("Sep 14"));        //la.printAll();
    }
    public void testCountUniqueIPsInRange(){
    LogAnalyzer la=new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println("Ips in range : "+la.countUniqueIPsInRange(200,299));
    }
    public void testCountVisitsPerIp(){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println(la.countVisitsPerIp());
    }
    public void testMostNumberVisitsByIP(){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog3-short_log");
        System.out.println(la.mostNumberVisitsByIP(la.countVisitsPerIp()));
    }
    public void testIPsMostVisits(){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog3-short_log");
        System.out.println("IPs: \n"+la.iPsMostVisits(la.countVisitsPerIp()));
    }
    public void testIPsForDays(){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog3-short_log");
        System.out.println(la.iPsForDays());
    }
    public void testDaysWithMostIPVisits(){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog3-short_log");
        System.out.println(la.daysWithMostIPVisits(la.iPsForDays()));

    }
    public void testIPsWithMostVisitsOnDay(){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog3-short_log");
        System.out.println(la.iPsWithMostVisitsOnDay(la.iPsForDays(),"Sep 30"));
    }
}