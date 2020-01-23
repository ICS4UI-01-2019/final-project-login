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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import javax.imageio.ImageIO;

/**
 *
 * @author Purew
 */
public class FileInfo {
    
    ProcessImage proc = new ProcessImage();

    /**
     * Reads in all of the data of a gesture file(and formats it)
     *
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
        KeyFrame[] keys = new KeyFrame[((int) (lines) / 5)];
        
        //initialize the first keyframe in keys
        keys[0] = new KeyFrame();
        //re-initialize the readers (and file) after it has read the amount of lines in the file
        file = new File(path);
        read = new FileReader(file);
        buffRead = new BufferedReader(read);
        //loop through the file and get all of the file's data
        for (int i = 1; i < (lines); i++) {

            //current keyframe index
            int index = (int) (i / 5);
            

            //read in a line
            String line = buffRead.readLine();
            //depending on the line read, set a colours average x and y point
            if ((i % 5) == 1) {
                keys[index].setBlueX(Integer.parseInt(line.substring(1, line.indexOf(","))));
                keys[index].setBlueY(Integer.parseInt(line.substring(line.indexOf(",") + 1, line.length() - 1)));
                keys[index].setBlue(true);
            } else if (i % 5 == 2) {
                keys[index].setRedX(Integer.parseInt(line.substring(1, line.indexOf(","))));
                keys[index].setRedY(Integer.parseInt(line.substring(line.indexOf(",") + 1, line.length() - 1)));
                keys[index].setRed(true);
            } else if (i % 5 == 3) {
                keys[index].setGreenX(Integer.parseInt(line.substring(1, line.indexOf(","))));
                keys[index].setGreenY(Integer.parseInt(line.substring(line.indexOf(",") + 1, line.length() - 1)));
                keys[index].setGreen(true);
            } else if (i % 5 == 4) {
                keys[index].setYellowX(Integer.parseInt(line.substring(1, line.indexOf(","))));
                keys[index].setYellowY(Integer.parseInt(line.substring(line.indexOf(",") + 1, line.length() - 1)));
                keys[index].setYellow(true);
            } else if (i % 5 == 0) {
                keys[index - 1].setPurpleX(Integer.parseInt(line.substring(1, line.indexOf(","))));
                keys[index - 1].setPurpleY(Integer.parseInt(line.substring(line.indexOf(",") + 1, line.length() - 1)));
                keys[index - 1].setPurple(true);
            }

            //check if a new keyframe needs to be made
            if (i % 5 == 0 && i < lines - 1) {
                keys[index] = new KeyFrame();
            }

        }

        return keys;
    }

    /**
     * Update a gesture's data file using an array of images
     *
     * @param path to the file being updated
     * @param buffImg the array of images used to update the file
     * @throws IOException (file/image exception)
     */
    public void updateFile(String path, BufferedImage[] buffImg) throws IOException {
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
        buffWrite.flush();
    }
    /**
     * creates an array of images inside a given file
     * @param path the file that will be edited
     * @return the array of images
     * @throws IOException throws an exception if file reading goes wrong
     */
    public BufferedImage[] buffLoad(String path) throws IOException {
        long count = 0;
        //gets the series of files within a folder
        try (Stream<Path> files = Files.list(Paths.get(path))) {
            //gets the amount of files in a usuable form for the loop
            count = files.count() - 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //initializing the array of images
        BufferedImage[] buff = new BufferedImage[(int) count - 1];
        //puts all of the imagesw within the folder into the array of images
        for (int i = 1; i < count; i++) {
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(proc.returnUncoded(path + "\\rawImage" + i + ".txt")));
            buff[i - 1] = (BufferedImage) img;
        }
        //returns the array of images
        return buff;
    }
}
