

public class Part2
{
  public String findSimpleGene(String dna,String st,String en) {
	if(dna.charAt(0)<=90)
	{ dna=dna.toUpperCase();
	    st="ATG";
	    en="TAA";
	    
	   }
      int start = dna.indexOf(st);
		if (start == -1) {
			return "";
		}
		
		int stop = dna.indexOf(en, start+3);
		
		if ((stop!=-1) && (stop - start) % 3 == 0) {
			return dna.substring(start, stop+3);
		}
		else {
			return "";
		}
	}
	void testSimpleGene() {
	    String dna="AVBDSATGJBVIUVWIUFdUTAA";
	    System.out.println(" DNA string : "+dna);
	    System.out.println(" GENE : "+findSimpleGene(dna,"atg","taa"));
	    
	    String dna1="avuherhbatgjbvrjvrfvtaa";
	    System.out.println(" DNA string : "+dna1);
	    System.out.println(" GENE : "+findSimpleGene(dna1,"atg","taa"));
}
}

