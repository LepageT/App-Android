/*
 * Accommodation.java
 *
 * Created on 6 March 2006, 11:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Analyser.texteAnalyser;

/**
 *
 * @author John
 */
public class Keyword {

    /** Creates a new instance of Accommodation */
    public Keyword(String id, 
                 String name, 
                 String keywords,
                 String type) {
        this.id = id;     
        this.name = name;     
        this.keywords = keywords;  
        this.type = type;
    }
    
    /**
     * Holds value of property name.
     */
    private String name;

    /**
     * Getter for property title.
     * @return Value of property title.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for property title.
     * @param title New value of property title.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Holds value of property id.
     */
    private String id;

    /**
     * Getter for property id.
     * @return Value of property id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter for property id.
     * @param id New value of property id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Holds value of property description.
     */
    private String keywords;

    /**
     * Getter for property details.
     * @return Value of property details.
     */
    public String getKeywords() {
        return this.keywords;
    }

    /**
     * Setter for property details.
     * @param details New value of property details.
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    
    private String type;

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
        return "Keyword "
               + getId()
               +": "
               + getName();
    }
}
