/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 *
 * @author Purew
 */
public class ProcessImage {

    private File imageData;
    private FileWriter write;
    private FileReader read;
    private BufferedReader bRead;
    private BufferedWriter bWrite;

    /**
     * Gathers the average points of each finger (colour)
     *
     * @param img the image being processed
     * @return a string formatted with the average points
     * @throws java.io.IOException (Image exception)
     */
    public String averagePoints(BufferedImage img) throws IOException {
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

        int yellowX = 0;
        int yellowY = 0;
        int yellowCount = 0;

        int greenX = 0;
        int greenY = 0;
        int greenCount = 0;

        int blueX = 0;
        int blueY = 0;
        int blueCount = 0;

        //loop through each pixel
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //get the colour of the pixel
                Color colour = new Color(img.getRGB(j, i));

                //check if the colour of the pixel is red(ish)
                if (colour.getRed() >= 155 && colour.getRed() <= 255 && colour.getGreen() >= 0 && colour.getGreen() <= 55 && colour.getBlue() >= 0 && colour.getBlue() <= 100) {
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

                //check if the colour of the pixel is yellow(ish)
                if (!(colour.getRed() >= 150 && colour.getRed() <= 255 && colour.getGreen() >= 200 && colour.getGreen() <= 255 && colour.getBlue() >= 20 && colour.getBlue() <= 130)) {
                    //if it's classified as yellow(ish)
                    yellowX += j;
                    yellowY += i;
                    yellowCount++;
                }

                //check if the colour of the pixel is green(ish)
                if (colour.getRed() >= 0 && colour.getRed() <= 40 && colour.getGreen() >= 100 && colour.getGreen() <= 140 && colour.getBlue() >= 80 && colour.getBlue() <= 120) {
                    //if it's classified as geen(ish)
                    greenX += j;
                    greenY += i;
                    greenCount++;
                }

                //check if the colour of the pixel is blue(ish)
                if (colour.getRed() >= 0 && colour.getRed() <= 30 && colour.getGreen() >= 20 && colour.getGreen() <= 65 && colour.getBlue() >= 100 && colour.getBlue() <= 145) {
                    //if it's classified as blue(ish)
                    blueX += j;
                    blueY += i;
                    blueCount++;
                    System.out.println(j + "," + i);
                }

            }

        }

        //find the average points
        if (redCount > 0) {
            redX /= redCount;
            redY /= redCount;
        }

        if (yellowCount > 0) {
            yellowX /= yellowCount;
            yellowY /= yellowCount;
        }

        if (orangeCount > 0) {
            orangeX /= orangeCount;
            orangeY /= orangeCount;
        }

        if (greenCount > 0) {
            greenX /= greenCount;
            greenY /= greenCount;
        }

        if (blueCount > 0) {
            blueX /= blueCount;
            blueY /= blueCount;
        }

        System.out.println(redX);

        //format the average points
        avPoints = "[" + blueX + "," + blueY + "]\n" + "[" + redX + "," + redY + "]\n" + "[" + greenX + "," + greenY + "]\n" + "[" + yellowX + "," + yellowY + "]\n" + "[" + orangeX + "," + orangeY + "]\n";

        return avPoints;
    }

    /**
     * 'Blackens' the image by removing unnecessary colours
     *
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
//                if (!(colour.getRed() >= 165 && colour.getRed() <= 185 && colour.getGreen() >= 55 && colour.getGreen() <= 80 && colour.getBlue() >= 55 && colour.getBlue() <= 85)) {
//                    if (!(colour.getRed() >= 200 && colour.getRed() <= 255 && colour.getGreen() >= 100 && colour.getGreen() <= 200 && colour.getBlue() >= 0 && colour.getBlue() <= 80)) {
//                        if (!(colour.getRed() >= 150 && colour.getRed() <= 255 && colour.getGreen() >= 200 && colour.getGreen() <= 255 && colour.getBlue() >= 20 && colour.getBlue() <= 130)) {
//                            if (!(colour.getRed() >= 0 && colour.getRed() <= 40 && colour.getGreen() >= 100 && colour.getGreen() <= 140 && colour.getBlue() >= 80 && colour.getBlue() <= 120)) {
                if (!(colour.getRed() >= 185 && colour.getRed() <= 235 && colour.getGreen() >= 20 && colour.getGreen() <= 65 && colour.getBlue() >= 100 && colour.getBlue() <= 145)) {
                    img.setRGB(j, i, Color.black.getRGB());
                }
//                            }
//                        }
//                    }
//                }
            }
        }
        //return the image
        return img;
    }
    
    protected void rawData(BufferedImage img) {
        ByteArrayOutputStream convert = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, "jpg", convert);
        } catch (IOException e) {
        }
        byte[] rawImage = convert.toByteArray();
        this.imageData = new File("LOCKED\\Password\\rawImage.txt");
        try {
            this.write = new FileWriter(this.imageData, true);
            this.bWrite = new BufferedWriter(write);
        } catch (IOException e) {
        }
        String data = Arrays.toString(rawImage);
        try {
            this.bWrite.write(data);
        } catch (IOException e) {
        }
    }

    
//    protected BufferedImage returnImage(String path) throws FileNotFoundException, IOException {
//        ByteArrayInputStream backToImage = new ByteArrayInputStream();
//        this.imageData = new File("LOCKED\\Password\\rawImage.txt");
//        this.read = new FileReader(this.imageData);
//        this.bRead = new BufferedReader(this.read);
//        
//        byte[] data = new byte[1024];
//        
//        
//        
//    }

    

}
