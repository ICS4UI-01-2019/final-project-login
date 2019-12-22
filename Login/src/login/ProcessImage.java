/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Color;
import java.awt.image.BufferedImage;
import org.opencv.core.Mat;

/**
 *
 * @author Purew
 */
public class ProcessImage {
    
    public BufferedImage ProcessImage(BufferedImage img){
        int row = img.getHeight();
        int col = img.getWidth();
        Color colour;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                colour = new Color(img.getRGB(j, i));
                
                
                
                if(!(colour.getRed() >= 155 && colour.getRed() <= 255 && colour.getGreen() >= 0 && colour.getGreen() <= 58 && colour.getBlue() >= 0 && colour.getBlue() <= 100)){
                    if(!(colour.getRed() >= 200 && colour.getRed() <= 255 && colour.getGreen() >= 100 && colour.getGreen() <= 200 && colour.getBlue() >= 0 && colour.getBlue() <= 80)){
                        img.setRGB(j, i, Color.black.getRGB());
                    }
                }
                
                
            }
        }
        
        return img;
    }
}
