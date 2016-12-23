package Common;
import java.io.Serializable;

/** 
 * Holder for column and row information
 */
public class Coordinates implements Serializable{
	private int col;
	private int row;
	
	/** 
	 * Constructor for Coordinates
	 * 
	 * 	@param row A row
	 *  @param column A column 
	 */	
    public Coordinates(int row,int col){
        this.col=col;
        this.row=row;
    }
    
    /** 
     * gets col
     */
    public int getCol(){
    	return this.col;
    }
    
    /** 
     * gets row
     */
    public int getRow(){
    	return this.row;
    }
    
    /** 
     * sets col
     * @param a    the col attribute would be assigned a
     */
    public void setCol(int a){
    	this.col=a;
    }
    
    /** 
     * sets row
     * @param b    the row attribute would be assigned b
     */
    public void setB(int b){
    	this.row=b;
    }

}
