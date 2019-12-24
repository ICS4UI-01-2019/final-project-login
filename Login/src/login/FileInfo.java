/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Purew
 */
public class FileInfo {
    
    /**
     * Reads in all of the data of a gesture file(and formats it)
     * @param path the path of to the gesture data file
     * @return an array of KeyFrames with individual data
     * @throws IOException (File Exception)
     */
    public KeyFrame[] readFile(String path) throws IOException {
        //get the text file and initialize the file readers
        File file = new File(path);
        FileReader read = new FileReader(file);
        BufferedReader buffRead = new BufferedReader(read);

        //number of lines in the file
        long lines = buffRead.lines().count();

        //create the array of keyframes
        KeyFrame[] keys = new KeyFrame[((int) lines / 5)];
        
        //initialize the first keyframe in keys
        keys[0] = new KeyFrame();

        //loop through the file and get all of the file's data
        for (int i = 1; i < lines + 1; i++) {
            //re-initialize the buffered reader after it has read the amount of lines in the file
            buffRead = new BufferedReader(read);
            //read in a line
            String line = buffRead.readLine();

            if ((i%5) == 1) {

            } else if ((i%5) == 2) {
                keys[(i / 5) - 1].setRedX(Integer.parseInt(line.substring(1, line.indexOf(","))));
                keys[(i / 5) - 1].setRedY(Integer.parseInt(line.substring(line.indexOf(",") + 1, line.length())));
            } else if ((i%5) == 3) {

            } else if ((i%5) == 4) {
                keys[(i / 5) - 1].setGreenX(Integer.parseInt(line.substring(1, line.indexOf(","))));
                keys[(i / 5) - 1].setGreenY(Integer.parseInt(line.substring(line.indexOf(",") + 1, line.length())));
            } else if ((i%5) == 0) {
                keys[(i / 5) - 1].setOrangeX(Integer.parseInt(line.substring(1, line.indexOf(","))));
                keys[(i / 5) - 1].setOrangeY(Integer.parseInt(line.substring(line.indexOf(",") + 1, line.length())));
            }
            
            //check if a new keyframe needs to be made
            if (i % 5 == 0) {
                keys[(i / 5)] = new KeyFrame();
            }

        }

        return keys;
    }
    
    /**
     * Update a gesture's data file using an array of images
     * @param path to the file being updated
     * @param buffImg the array of images used to update the file
     * @throws IOException (file/image exception)
     */
    public void updateFile(String path, BufferedImage[] buffImg) throws IOException{
        //get the text file and initialize the file writers
        File file = new File(path);
        FileWriter write = new FileWriter(file, false);
        BufferedWriter buffWrite = new BufferedWriter(write);
        
        //string to hold the 'data' of the keyframes
        String data = "";
        
        //get the process image class in order to get each keyframe's average points
        ProcessImage procImg = new ProcessImage();
        
        //loop through the images and get the average point data (and store the data to the string 'data')
        for (int i = 0; i < buffImg.length; i++) {
            data += procImg.averagePoints(buffImg[i]);
        }
        
        //update the file with the new data
        buffWrite.write(data);
    }
}
