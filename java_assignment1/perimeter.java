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
        double minX=Double.NEGATIVE_INFINITY;
        for(Point p :s.getPoints())
        {
            if(p.getX() > minX)
            minX=p.getX();
        }
        return minX;
    }


    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("Perimeter = " + length);
        int len=getNumPoints(s);
        System.out.println("Number of points " + len);
        double avgper=getAverageLength(s);
        System.out.println("avg perimeter " + avgper);
        
        double largSide=getLargestSide(s);
        System.out.println("largest size " + largSide);
        double largX=getLargestX(s);
        System.out.println("largest X=" + largX);     
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}

