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
    private int redX = 0;
    private int redY = 0;
    private int greenX = 0;
    private int greenY = 0;
    private int purpleX = 0;
    private int purpleY = 0;
    private int yellowX = 0;
    private int yellowY = 0;
    private int blueX = 0;
    private int blueY = 0;
    
    //number of colours visible in the frame
    private int numfOfCol;
    
    //visible colours
    private boolean red = false;
    private boolean purple = false;
    private boolean yellow = false;
    private boolean blue = false;
    private boolean green = false;
    
    /**
     * Whether or not the keyframe contains red(ish) pixels
     * @return whether or not the keyframe contains red(ish) pixels
     */
    public boolean getRed(){
        return this.red;
    }
    
    /**
     * Whether or not the keyframe contains blue(ish) pixels
     * @return whether or not the keyframe contains blue(ish) pixels
     */
    public boolean getBlue(){
        return this.blue;
    }
    
    /**
     * Whether or not the keyframe contains green(ish) pixels
     * @return whether or not the keyframe contains green(ish) pixels
     */
    public boolean getGreen(){
        return this.green;
    }
    
    /**
     * Whether or not the keyframe contains yellow(ish) pixels
     * @return whether or not the keyframe contains yellow(ish) pixels
     */
    public boolean getYellow(){
        return this.yellow;
    }
    
    /**
     * Whether or not the keyframe contains purple(ish) pixels
     * @return whether or not the keyframe contains purple(ish) pixels
     */
    public boolean getPurple(){
        return this.purple;
    }
    
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
     * Retrieves the average 'x' position of all purple pixels
     * @return the average 'x' position of all purple pixels
     */
    public int getPurpleX(){
        return this.purpleX;
    }
    
    /**
     * Retrieves the average 'y' position of all purple pixels
     * @return the average 'y' position of all purple pixels
     */
    public int getPurpleY(){
        return this.purpleY;
    }
    
    /**
     * Retrieves the average 'x' position of all blue pixels
     * @return the average 'x' position of all blue pixels
     */
    public int getBlueX(){
        return this.blueX;
    }
    
    /**
     * Retrieves the average 'y' position of all blue pixels
     * @return the average 'y' position of all blue pixels
     */
    public int getBlueY(){
        return this.blueY;
    }
    
    /**
     * Retrieves the average 'x' position of all yellow pixels
     * @return the average 'x' position of all yellow pixels
     */
    public int getYellowX(){
        return this.yellowX;
    }
    
    /**
     * Retrieves the average 'y' position of all yellow pixels
     * @return the average 'y' position of all yellow pixels
     */
    public int getYellowY(){
        return this.yellowY;
    }
    
    /**
     * Return the number of visible (necessary) colours in the key frame
     * @return the number of visible colours
     */
    public int getNumCols(){
        return this.numfOfCol;
    }
    
    /**
     * Sets the average 'x' position of all red pixels
     * @param value the desired value to be set to
     */
    public void setRedX(int value){
        this.redX = value;
    }
    
    /**
     * Sets the average 'y' position of all red pixels
     * @param value the desired value to be set to
     */
    public void setRedY(int value){
        this.redY = value;
    }
    
    /**
     * Sets the average 'x' position of all green pixels
     * @param value the desired value to be set to
     */
    public void setGreenX(int value){
        this.greenX = value;
    }
    
    /**
     * Sets the average 'y' position of all green pixels
     * @param value the desired value to be set to
     */
    public void setGreenY(int value){
        this.greenY = value;
    }
    
    /**
     * Sets the average 'x' position of all purple pixels
     * @param value the desired value to be set to
     */
    public void setPurpleX(int value){
        this.purpleX = value;
    }
    
    /**
     * Sets the average 'y' position of all purple pixels
     * @param value the desired value to be set to
     */
    public void setPurpleY(int value){
        this.purpleY = value;
    }
    
    /**
     * Sets the average 'x' position of all blue pixels
     * @param value the desired value to be set to
     */
    public void setBlueX(int value){
        this.blueX = value;
    }
    
    /**
     * Sets the average 'y' position of all blue pixels
     * @param value the desired value to be set to
     */
    public void setBlueY(int value){
        this.blueX = value;
    }
    
    /**
     * Sets the average 'x' position of all yellow pixels
     * @param value the desired value to be set to
     */
    public void setYellowX(int value){
        this.blueX = value;
    }
    
    /**
     * Sets the average 'y' position of all yellow pixels
     * @param value the desired value to be set to
     */
    public void setYellowY(int value){
        this.blueX = value;
    }
    
    /**
     * Set the number of visible (necessary) colours in the keyframe
     * @param value the number of visible colours
     */
    public void setNumCols(int value){
        this.numfOfCol = value;
    }
    
    /**
     * Sets whether or not their are visible blue pixels in the keyframe
     * @param visible whether or not their are visible blue pixels in the keyframe
     */
    public void setBlue(boolean visible){
        this.blue = visible;
    }
    
    /**
     * Sets whether or not their are visible red pixels in the keyframe
     * @param visible whether or not their are visible red pixels in the keyframe
     */
    public void setRed(boolean visible){
        this.red = visible;
    }
    
    /**
     * Sets whether or not their are visible green pixels in the keyframe
     * @param visible whether or not their are visible green pixels in the keyframe
     */
    public void setGreen(boolean visible){
        this.green = visible;
    }
    
    /**
     * Sets whether or not their are visible yellow pixels in the keyframe
     * @param visible whether or not their are visible yellow pixels in the keyframe
     */
    public void setYellow(boolean visible){
        this.yellow = visible;
    }
    
    /**
     * Sets whether or not their are visible purple pixels in the keyframe
     * @param visible whether or not their are visible purple pixels in the keyframe
     */
    public void setPurple(boolean visible){
        this.purple = visible;
    }
}
