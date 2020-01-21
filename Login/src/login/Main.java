/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import org.opencv.core.Core;

/**
 *
 * @author Pures6322
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    ProcessImage proc = new ProcessImage();
    
    public static void main(String[] args) throws IOException {
        //load in the opencv java library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //open gesture window (with the gesture input mode)
        new Gesture(true).setVisible(true);
        
    }

    public boolean compareKeys(KeyFrame[] keys1, KeyFrame[] keys2) {
        //the max difference threshold to deem two keyframes not the same
        int diff = 10;
        
        //the number of incorrect keypoint distances
        int incorrectDist = 0;
        //the number of total keypoints
        int points = 0;
        //the maximum percentage (in decimal form) of incorrect points
        double maxPercentDec = 0.1;
        
        //compare the distance betweem each keyframe
        for (int i = 0; i < keys1.length; i++) {
            //blue to red
            if (keys1[i].getBlue() && keys2[i].getBlue() && keys1[i].getRed() && keys2[i].getRed()) {
                if (this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getRedX(), keys2[i].getRedY()) < -(diff) || this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getRedX(), keys2[i].getRedY()) > diff) {
                    incorrectDist++;
                }
            }

            //blue to green
            if (keys1[i].getBlue() && keys2[i].getBlue() && keys1[i].getGreen() && keys2[i].getGreen()) {
                if (this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getGreenX(), keys1[i].getGreenY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getGreenX(), keys2[i].getGreenY()) < -(diff) || this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getGreenX(), keys1[i].getGreenY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getGreenX(), keys2[i].getGreenY()) > diff) {
                    incorrectDist++;
                }
            }

            //blue to yellow
            if (keys1[i].getBlue() && keys2[i].getBlue() && keys1[i].getYellow() && keys2[i].getYellow()) {
                if (this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getYellowX(), keys1[i].getYellowY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getYellowX(), keys2[i].getYellowY()) < -(diff) || this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getYellowX(), keys1[i].getYellowY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getYellowX(), keys2[i].getYellowY()) > diff) {
                    incorrectDist++;
                }
            }

            //blue to orange
            if (keys1[i].getBlue() && keys2[i].getBlue() && keys1[i].getOrange() && keys2[i].getOrange()) {
                if (this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getOrangeX(), keys1[i].getOrangeY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getOrangeX(), keys2[i].getOrangeY()) < -(diff) || this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getOrangeX(), keys1[i].getOrangeY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getOrangeX(), keys2[i].getOrangeY()) > diff) {
                    incorrectDist++;
                }
            }

            //red to green
            if (keys1[i].getRed() && keys2[i].getRed() && keys1[i].getGreen() && keys2[i].getGreen()) {
                if (this.getDist(keys1[i].getGreenX(), keys1[i].getGreenY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getRedX(), keys2[i].getRedY()) < -(diff) || this.getDist(keys1[i].getGreenX(), keys1[i].getGreenY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getRedX(), keys2[i].getRedY()) > diff) {
                    incorrectDist++;
                }
            }

            //red to yellow
            if (keys1[i].getRed() && keys2[i].getRed() && keys1[i].getYellow() && keys2[i].getYellow()) {
                if (this.getDist(keys1[i].getYellowX(), keys1[i].getGreenY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getRedX(), keys2[i].getRedY()) < -(diff) || this.getDist(keys1[i].getGreenX(), keys1[i].getGreenY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getRedX(), keys2[i].getRedY()) > diff) {
                    incorrectDist++;
                }
            }

            //red to orange
            if (keys1[i].getRed() && keys2[i].getRed() && keys1[i].getOrange() && keys2[i].getOrange()) {
                if (this.getDist(keys1[i].getOrangeX(), keys1[i].getOrangeY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getOrangeX(), keys2[i].getOrangeY(), keys2[i].getRedX(), keys2[i].getRedY()) < -(diff) || this.getDist(keys1[i].getOrangeX(), keys1[i].getOrangeY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getOrangeX(), keys2[i].getOrangeY(), keys2[i].getRedX(), keys2[i].getRedY()) > diff) {
                    incorrectDist++;
                }
            }

            //green to yellow
            if (keys1[i].getYellow() && keys2[i].getYellow() && keys1[i].getGreen() && keys2[i].getGreen()) {
                if (this.getDist(keys1[i].getGreenX(), keys1[i].getGreenY(), keys1[i].getYellowX(), keys1[i].getYellowY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getYellowX(), keys2[i].getYellowY()) < -(diff) || this.getDist(keys1[i].getGreenX(), keys1[i].getGreenY(), keys1[i].getYellowX(), keys1[i].getYellowY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getYellowX(), keys2[i].getYellowY()) > diff) {
                    incorrectDist++;
                }
            }

            //green to orange
            if (keys1[i].getOrange() && keys2[i].getOrange() && keys1[i].getGreen() && keys2[i].getGreen()) {
                if (this.getDist(keys1[i].getGreenX(), keys1[i].getGreenY(), keys1[i].getOrangeX(), keys1[i].getOrangeY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getOrangeX(), keys2[i].getOrangeY()) < -(diff) || this.getDist(keys1[i].getGreenX(), keys1[i].getGreenY(), keys1[i].getOrangeX(), keys1[i].getOrangeY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getOrangeX(), keys2[i].getOrangeY()) > diff) {
                    incorrectDist++;
                }
            }

            //yellow to orange
            if (keys1[i].getOrange() && keys2[i].getOrange() && keys1[i].getYellow() && keys2[i].getYellow()) {
                if (this.getDist(keys1[i].getYellowX(), keys1[i].getYellowY(), keys1[i].getOrangeX(), keys1[i].getOrangeY()) - this.getDist(keys2[i].getYellowX(), keys2[i].getYellowY(), keys2[i].getOrangeX(), keys2[i].getOrangeY()) < -(diff) || this.getDist(keys1[i].getYellowX(), keys1[i].getYellowY(), keys1[i].getOrangeX(), keys1[i].getOrangeY()) - this.getDist(keys2[i].getYellowX(), keys2[i].getYellowY(), keys2[i].getOrangeX(), keys2[i].getOrangeY()) > diff) {
                    incorrectDist++;
                }
            }
            
            
            //add to the number of points
            points += 10;
        }
        
        //check if enough key points are correct (or not too many are wrong)
        if(incorrectDist == 0 || (incorrectDist/points) <= maxPercentDec){
            System.out.println((incorrectDist/points)*100 + "%");
            return true;
        }
        System.out.println((incorrectDist/points)*100 + "%");
        //otherwise return false because too many keypoint were incorrect
        return false;

    }
    
    public int getDist(int x1, int y1, int x2, int y2) {
        int distance = (int) (Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))));
        return distance;
    }

}
