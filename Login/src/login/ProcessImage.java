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

    public BufferedImage ProcessImage(BufferedImage img) {
        int row = img.getHeight();
        int col = img.getWidth();
        Color colour;

        int count = 0;
        int redAvX = 0;
        int redAvY = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                colour = new Color(img.getRGB(j, i));

                if (!(colour.getRed() >= 155 && colour.getRed() <= 255 && colour.getGreen() >= 0 && colour.getGreen() <= 55 && colour.getBlue() >= 0 && colour.getBlue() <= 100)) {
                    if (!(colour.getRed() >= 200 && colour.getRed() <= 255 && colour.getGreen() >= 100 && colour.getGreen() <= 200 && colour.getBlue() >= 0 && colour.getBlue() <= 80)) {
                        if (!(colour.getRed() >= 150 && colour.getRed() <= 255 && colour.getGreen() >= 200 && colour.getGreen() <= 255 && colour.getBlue() >= 20 && colour.getBlue() <= 130)) {
                            
                                img.setRGB(j, i, Color.black.getRGB());
                            
                            
                        }
                    }
                } else {
                    redAvX += j;
                    redAvY += i;
                    count++;
                }

//                img.setRGB(j, i, Color.black.getRGB());
            }
        }

//        if (redAvX > 0 && redAvY > 0) {
//            redAvX /= count;
//            redAvY /= count;
//
//            img.setRGB(redAvX, redAvY, Color.white.getRGB());
//            img.setRGB(redAvX - 1, redAvY, Color.white.getRGB());
//            img.setRGB(redAvX + 1, redAvY, Color.white.getRGB());
//            img.setRGB(redAvX, redAvY - 1, Color.white.getRGB());
//            img.setRGB(redAvX, redAvY + 1, Color.white.getRGB());
//        }

        return img;
    }
}
