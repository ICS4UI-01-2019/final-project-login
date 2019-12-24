/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author Purew
 */
public class KeyFrame {
    //variables of the keyframe (average positions of each colour)
    private int redX;
    private int redY;
    private int greenX;
    private int greenY;
    private int orangeX;
    private int orangeY;
    
    /**
     * Retrieves the average 'x' position of all red pixels
     * @return the average 'x' position of all red pixels
     */
    public int getRedX(){
        return this.redX;
    }
    
    /**
     * Retrieves the average 'y' position of all red pixels
     * @return the average 'y' position of all red pixels
     */
    public int getRedY(){
        return this.redY;
    }
    
    /**
     * Retrieves the average 'x' position of all green pixels
     * @return the average 'x' position of all green pixels
     */
    public int getGreenX(){
        return this.greenX;
    }
    
    /**
     * Retrieves the average 'y' position of all green pixels
     * @return the average 'y' position of all green pixels
     */
    public int getGreenY(){
        return this.greenY;
    }
    
    /**
     * Retrieves the average 'x' position of all orange pixels
     * @return the average 'x' position of all orange pixels
     */
    public int getOrangeX(){
        return this.orangeX;
    }
    
    /**
     * Retrieves the average 'y' position of all orange pixels
     * @return the average 'y' position of all orange pixels
     */
    public int getOrangeY(){
        return this.orangeY;
    }
    
    /**
     * Sets the average 'x' position of all red pixels
     */
    public void setRedX(int value){
        this.redX = value;
    }
    
    /**
     * Sets the average 'y' position of all red pixels
     */
    public void setRedY(int value){
        this.redY = value;
    }
    
    /**
     * Sets the average 'x' position of all green pixels
     */
    public void setGreenX(int value){
        this.greenX = value;
    }
    
    /**
     * Sets the average 'y' position of all green pixels
     */
    public void setGreenY(int value){
        this.greenY = value;
    }
    
    /**
     * Sets the average 'x' position of all orange pixels
     */
    public void setOrangeX(int value){
        this.orangeX = value;
    }
    
    /**
     * Sets the average 'y' position of all orange pixels
     */
    public void setOrangeY(int value){
        this.orangeY = value;
    }
}
