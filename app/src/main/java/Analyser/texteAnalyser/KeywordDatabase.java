/*
 * HotelInitialisation.java
 *
 * Created on 6 March 2006, 14:04
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Analyser.texteAnalyser;

/**
 *
 * @author John
 */
public class KeywordDatabase {
    
    private static final Keyword[] KEYWORDS = {    
        new Keyword("1","Toilette","Toilette, Chiotte, chiasse, caca", "Service"),
        new Keyword("2","Lieu de culte","Terroriste, esclavage, fraude, J.sus, culte, lieu, amis imaginaires", "Service"),
        new Keyword("3","Proche", "proche, proximité, prés, à côt., voisine, imm.diate", "Proximite"),
        new Keyword("4","Loin", "loin, éloignée, distante, écarté, lointaine, ailleurs", "Proximite")
        
    };
    
    public static Keyword[] getKeywords() {
        return KEYWORDS;
    }
    
    public static Keyword getKeyword(String id) {
        for(Keyword keyword : KEYWORDS) {
            if (id.equals(keyword.getId())) {
                return keyword;
            }
        }
        return null;
    }
}