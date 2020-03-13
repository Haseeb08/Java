
public class Part1
{
   
    public String findSimpleGene(String dna) {
        int start = dna.indexOf("ATG");
        if (start == -1) {
            return "";
        }
        int stop = dna.indexOf("TAA", start+3);
        if ((stop!=-1) && (stop - start) % 3 == 0) {
            return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
    }
    void testSimpleGene() {
        String dna="ABDATGDGCBHRTAA";
        System.out.println(" DNA string : "+dna);
        System.out.println(" GENE : "+findSimpleGene(dna));
        
        String dna1="ATGTSGVDGTAA";
        System.out.println(" DNA string : "+dna1);
        System.out.println(" GENE : "+findSimpleGene(dna1));
}
}
