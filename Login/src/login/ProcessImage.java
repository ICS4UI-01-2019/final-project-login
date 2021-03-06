/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
    private FileReader twoRead;

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

        int purpleX = 0;
        int purpleY = 0;
        int purpleCount = 0;

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
                if (colour.getRed() >= 112 && colour.getRed() <= 165 && colour.getGreen() >= 28 && colour.getGreen() <= 59 && colour.getBlue() >= 20 && colour.getBlue() <= 63) {
                    //if it's classified as red(ish)
                    redX += j;
                    redY += i;
                    redCount++;
                }

                //check if the colour of the pixel is purple(ish)
                if (colour.getRed() >= 74 && colour.getRed() <= 112 && colour.getGreen() >= 59 && colour.getGreen() <= 88 && colour.getBlue() >= 14 && colour.getBlue() <= 88) {
                    //if it's classified as purple(ish)
                    purpleX += j;
                    purpleY += i;
                    purpleCount++;
                }

                //check if the colour of the pixel is yellow(ish)
                if (colour.getRed() >= 192 && colour.getRed() <= 255 && colour.getGreen() >= 169 && colour.getGreen() <= 242 && colour.getBlue() >= 67 && colour.getBlue() <= 94) {
                    //if it's classified as yellow(ish)
                    yellowX += j;
                    yellowY += i;
                    yellowCount++;
                }

                //check if the colour of the pixel is green(ish)
                if (colour.getRed() >= 23 && colour.getRed() <= 73 && colour.getGreen() >= 58 && colour.getGreen() <= 127 && colour.getBlue() >= 20 && colour.getBlue() <= 69) {
                    //if it's classified as geen(ish)
                    greenX += j;
                    greenY += i;
                    greenCount++;
                }

                //check if the colour of the pixel is blue(ish)
                if (colour.getRed() >= 61 && colour.getRed() <= 140 && colour.getGreen() >= 122 && colour.getGreen() <= 202 && colour.getBlue() >= 123 && colour.getBlue() <= 191) {
                    //if it's classified as blue(ish)
                    blueX += j;
                    blueY += i;
                    blueCount++;
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

        if (purpleCount > 0) {
            purpleX /= purpleCount;
            purpleY /= purpleCount;
        }

        if (greenCount > 0) {
            greenX /= greenCount;
            greenY /= greenCount;
        }

        if (blueCount > 0) {
            blueX /= blueCount;
            blueY /= blueCount;
        }

        //format the average points
        avPoints = "[" + blueX + "," + blueY + "]\n" + "[" + redX + "," + redY + "]\n" + "[" + greenX + "," + greenY + "]\n" + "[" + yellowX + "," + yellowY + "]\n" + "[" + purpleX + "," + purpleY + "]\n";

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
                //green
                if (!(colour.getRed() >= 23 && colour.getRed() <= 73 && colour.getGreen() >= 58 && colour.getGreen() <= 127 && colour.getBlue() >= 20 && colour.getBlue() <= 69)) {
                    //red
                    if (!(colour.getRed() >= 112 && colour.getRed() <= 165 && colour.getGreen() >= 28 && colour.getGreen() <= 59 && colour.getBlue() >= 20 && colour.getBlue() <= 63)) {
                        //yellow
                        if (!(colour.getRed() >= 192 && colour.getRed() <= 255 && colour.getGreen() >= 169 && colour.getGreen() <= 242 && colour.getBlue() >= 67 && colour.getBlue() <= 94)) {
                            //light blue
                            if (!(colour.getRed() >= 61 && colour.getRed() <= 140 && colour.getGreen() >= 122 && colour.getGreen() <= 202 && colour.getBlue() >= 123 && colour.getBlue() <= 191)) {
                                //purple
//                                if (!(colour.getRed() >= 74 && colour.getRed() <= 112 && colour.getGreen() >= 59 && colour.getGreen() <= 88 && colour.getBlue() >= 14 && colour.getBlue() <= 88)) {
                                    img.setRGB(j, i, Color.black.getRGB());
//                                }
                            }
                        }
                    }

                }
            }
        }
        //return the image
        return img;
    }

    /**
     * Encodes a provided byte array
     *
     * @param needEncode the data needed to be encrypted
     * @param finalPath the path to the file that we write to
     */
    protected void rawData(byte[] needEncode, String finalPath) {
        try {
            //initializing the file that will be wrote to
            this.imageData = new File(finalPath);
            //initializes the writer that writes to the file provided
            this.write = new FileWriter(this.imageData, true);
            this.bWrite = new BufferedWriter(write);
            //Encodes the data and truns it to a char array
            char[] data = Base64.encode(needEncode).toCharArray();
            String data2 = "";
            //Every 100 lines adds a space so the encoded imformation can be printed completely
            for (int i = 0; i < data.length; i++) {
                if (i % 100 == 0) {
                    data2 += "\n";
                }
                //Adds each of the characters to the string
                data2 += data[i];
            }
            //Writes the data to the file
            bWrite.write(data2);
            //Unclogs the buffered writer so there isnt excessive backup
            bWrite.flush();
        } catch (IOException e) {
        }
    }

    /**
     * decodes a file
     *
     * @param path the file that needs to be read and uncoded
     * @return the decoded byte array
     * @throws FileNotFoundException because of the nature of writing to file
     * has to do a throw statement
     * @throws IOException because of the nature of writing to file has to do a
     * throw statement
     */
    protected byte[] returnUncoded(String path) throws FileNotFoundException, IOException {
        //gets the file it needs to access
        this.imageData = new File(path);
        //scans in the file into a string
        Scanner s = new Scanner(this.imageData);
        s.nextLine();
        String data = "";
        //scans though all of lines
        while (s.hasNext()) {
            data += s.nextLine();
        }
        //Decodes the data and returns it
        byte[] conversion = Base64.decode(data);
        return conversion;

    }
}
