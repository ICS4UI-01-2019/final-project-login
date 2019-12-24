/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Purew
 */
public class ProcessImage {
    /**
     * Gathers the average points of each finger (colour)
     * @param img the image being processed
     * @return a string formatted with the average points
     * @throws java.io.IOException (Image exception)
     */
    public String averagePoints(BufferedImage img) throws IOException{
        //blacken the image (remove unessisary colours)
        img = this.BlackImg(img);
        //get the amount of rows and coloums for the image
        int row = img.getHeight();
        int col = img.getWidth();
        
        //the string to hold the average points of each image
        String avPoints;
        
        //Total x and y positions of each colour
        int redX = 0;
        int redY = 0;
        int redCount = 0;
        
        int orangeX = 0;
        int orangeY = 0;
        int orangeCount = 0;
        
        int greenX = 0;
        int greenY = 0;
        int greenCount = 0;
        
        //loop through each pixel
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //get the colour of the pixel
                Color colour = new Color(img.getRGB(j, i));
                
                //check if the colour of the pixel is red(ish)
                if(colour.getRed() >= 155 && colour.getRed() <= 255 && colour.getGreen() >= 0 && colour.getGreen() <= 55 && colour.getBlue() >= 0 && colour.getBlue() <= 100){
                    //if it's classified as red(ish)
                    redX += j;
                    redY += i;
                    redCount++;
                }
                
                //check if the colour of the pixel is orange(ish)
                if (colour.getRed() >= 200 && colour.getRed() <= 255 && colour.getGreen() >= 100 && colour.getGreen() <= 200 && colour.getBlue() >= 0 && colour.getBlue() <= 80) {
                    //if it's classified as orange(ish)
                    orangeX += j;
                    orangeY += i;
                    orangeCount++;
                }
                
                //check if the colour of the pixel is green(ish)
                if (!(colour.getRed() >= 150 && colour.getRed() <= 255 && colour.getGreen() >= 200 && colour.getGreen() <= 255 && colour.getBlue() >= 20 && colour.getBlue() <= 130)) {
                    //if it's classified as green(ish)
                    greenX += j;
                    greenY += i;
                    greenCount++;
                }
                
            }
        }
        //find the average points
        redX /= redCount;
        redY /= redCount;
        
        greenX /= greenCount;
        greenY /= greenCount;
        
        orangeX /= orangeCount;
        orangeY /= orangeCount;
        
        //format the average points
        avPoints = "[" + "ColourX" + "," + "ColourY" + "]\n" + "[" + redX + "," + redY + "]\n" + "[" + "ColourX" + "," + "ColourY" + "]\n" + "[" + greenX + "," + greenY + "]\n" + "[" + orangeX + "," + orangeY + "]\n";

        return avPoints;
    }
    
    /**
     * 'Blackens' the image by removing unnecessary colours 
     * @param img the image being processed
     * @return the processed image
     * @throws IOException (image exception)
     */
    public BufferedImage BlackImg(BufferedImage img) throws IOException {
        //get the amount of rows and coloums for the image
        int row = img.getHeight();
        int col = img.getWidth();
        //loop through each pixel
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //get the colour of the current pixel
                Color colour = new Color(img.getRGB(j, i));
                //if the pixel's colour isn't any of the nessisary colours (fingertip colours) set the pixel's colour to black
                if (!(colour.getRed() >= 155 && colour.getRed() <= 255 && colour.getGreen() >= 0 && colour.getGreen() <= 55 && colour.getBlue() >= 0 && colour.getBlue() <= 100)) {
                    if (!(colour.getRed() >= 200 && colour.getRed() <= 255 && colour.getGreen() >= 100 && colour.getGreen() <= 200 && colour.getBlue() >= 0 && colour.getBlue() <= 80)) {
                        if (!(colour.getRed() >= 150 && colour.getRed() <= 255 && colour.getGreen() >= 200 && colour.getGreen() <= 255 && colour.getBlue() >= 20 && colour.getBlue() <= 130)) {

                            img.setRGB(j, i, Color.black.getRGB());

                        }
                    }
                }
            }
        }
        //return the image
        return img;
    }
    
}
