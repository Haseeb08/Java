import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put coe here
        int count =0;
        for(Point obj : s.getPoints()) { count++;}
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        int len= getNumPoints(s);
        double per=getPerimeter(s);
        return per/len;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double sidelen=0.0;
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            if(currDist>sidelen)
            sidelen=currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return sidelen;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double minval=Double.NEGATIVE_INFINITY;
        for(Point p :s.getPoints())
        {
            if(p.getX() > minval)
            minval=p.getX();
        }
        return minval;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double larg=0;
        for (File f : dr.selectedFiles()) {
            
        FileResource fr = new FileResource(f);
        Shape  s =new Shape(fr);
      double larg_peri = getPerimeter(s);
            if(larg<larg_peri)
            larg=larg_peri;
        }
      
        return larg;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;  
       DirectoryResource dr = new DirectoryResource();
        double larg=0;;
        for (File f : dr.selectedFiles()) {
           
        FileResource fr = new FileResource(f);
        Shape  s =new Shape(fr);
      double larg_peri = getPerimeter(s);
            if(larg<larg_peri)
            temp=f;
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int len=getNumPoints(s);
        System.out.println("no of points " + len);
        double avgper=getAverageLength(s);
        System.out.println("avg per " + avgper);
        
        double larg_s=getLargestSide(s);
        System.out.println("largest size " + larg_s);
        double largX=getLargestX(s);
        System.out.println("largest X=" + largX);     
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("largest perimeter is ="+getLargestPerimeterMultipleFiles());
        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("largest perimeter file name="+getFileWithLargestPerimeter());
    }


    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}

