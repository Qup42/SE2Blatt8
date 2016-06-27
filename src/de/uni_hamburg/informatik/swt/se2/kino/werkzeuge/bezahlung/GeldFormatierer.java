package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlung;

/**
 * Diese Klasse ist ein rudimentärer Formatierer, der für einen gegebenen Geldbetrag
 * eine Mögliche Stückelung in Geldscheinen (bis 20€ Scheine) und -stücken ausgibt.
 * @author Julian.Mundhahs
 *
 */
public class GeldFormatierer
{
    private int _geldBetrag;
    
//    public static void main(String[] args)
//    {
//        GeldFormatierer geldFormatierer1 = new GeldFormatierer(42);
//        GeldFormatierer geldFormatierer2 = new GeldFormatierer(6812);
//        System.out.println(geldFormatierer1.toString());
//        System.out.println(geldFormatierer2.toString());
//    }
    
    public GeldFormatierer(int geldBetrag)
    {
        _geldBetrag = geldBetrag;
    }
    
    public int getGeldBetrag()
    {
        return _geldBetrag;
    }
    
    @Override
    public String toString()
    {
        return "<html>20€: " + _geldBetrag/2000 + "; 10€: " + _geldBetrag%2000/1000 + 
                "; 5€: " + _geldBetrag%1000/500 + "; 2€: " + _geldBetrag%500/200 + 
                "; 1€: " + _geldBetrag%500%200/100 + "; <br> 50ct: " + _geldBetrag%100/50 +
                "; 20ct: " + _geldBetrag%50/20 + "; 10ct: " + _geldBetrag%50%20/10 + 
                "; 5ct: " + _geldBetrag%10/5 + "; 2ct: " + _geldBetrag%5/2 + 
                "; 1ct: " + _geldBetrag%5%2 + "</html>";
    }
}
