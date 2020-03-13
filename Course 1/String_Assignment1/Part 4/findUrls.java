import edu.duke.*;

public class Part4
{
    // instance variables - replace the example below with your own
   int start,end;

    public void sampleMethod()
    {
         URLResource ur= new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
     for(String line: ur.lines())
     {
         String testline=line.toLowerCase();
         int i=testline.indexOf("youtube.com");
        if(i>0)
        {
            start=testline.lastIndexOf("\"",i);
            end = testline.indexOf("\"",i);
        System.out.println(line.substring(start+1,end));
    }

}
    }
}

