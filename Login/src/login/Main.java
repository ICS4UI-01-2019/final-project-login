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
    public static void main(String[] args) throws IOException {
        //load in the opencv java library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //open gesture window (with the gesture input mode)
        new Gesture(true).setVisible(true);
        
    }

    public boolean compareKeys(KeyFrame[] keys1, KeyFrame[] keys2) {
        //the max difference threshold to deem two keyframes not the same
        int diff = 100;

        //compare the distance betweem each keyframe
        for (int i = 0; i < keys1.length; i++) {
            //blue to red
            if (keys1[i].getBlue() && keys2[i].getBlue() && keys1[i].getRed() && keys2[i].getRed()) {
                if (this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getRedX(), keys2[i].getRedY()) < -(diff) || this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getRedX(), keys2[i].getRedY()) > diff) {
                    return false;
                }
            }

            //blue to green
            if (keys1[i].getBlue() && keys2[i].getBlue() && keys1[i].getGreen() && keys2[i].getGreen()) {
                if (this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getGreenX(), keys1[i].getGreenY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getGreenX(), keys2[i].getGreenY()) < -(diff) || this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getGreenX(), keys1[i].getGreenY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getGreenX(), keys2[i].getGreenY()) > diff) {
                    return false;
                }
            }

            //blue to yellow
            if (keys1[i].getBlue() && keys2[i].getBlue() && keys1[i].getYellow() && keys2[i].getYellow()) {
                if (this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getYellowX(), keys1[i].getYellowY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getYellowX(), keys2[i].getYellowY()) < -(diff) || this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getYellowX(), keys1[i].getYellowY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getYellowX(), keys2[i].getYellowY()) > diff) {
                    return false;
                }
            }

            //blue to orange
            if (keys1[i].getBlue() && keys2[i].getBlue() && keys1[i].getOrange() && keys2[i].getOrange()) {
                if (this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getOrangeX(), keys1[i].getOrangeY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getOrangeX(), keys2[i].getOrangeY()) < -(diff) || this.getDist(keys1[i].getBlueX(), keys1[i].getBlueY(), keys1[i].getOrangeX(), keys1[i].getOrangeY()) - this.getDist(keys2[i].getBlueX(), keys2[i].getBlueY(), keys2[i].getOrangeX(), keys2[i].getOrangeY()) > diff) {
                    return false;
                }
            }

            //red to green
            if (keys1[i].getRed() && keys2[i].getRed() && keys1[i].getGreen() && keys2[i].getGreen()) {
                if (this.getDist(keys1[i].getGreenX(), keys1[i].getGreenY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getRedX(), keys2[i].getRedY()) < -(diff) || this.getDist(keys1[i].getGreenX(), keys1[i].getGreenY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getRedX(), keys2[i].getRedY()) > diff) {
                    return false;
                }
            }

            //red to yellow
            if (keys1[i].getRed() && keys2[i].getRed() && keys1[i].getYellow() && keys2[i].getYellow()) {
                if (this.getDist(keys1[i].getYellowX(), keys1[i].getGreenY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getRedX(), keys2[i].getRedY()) < -(diff) || this.getDist(keys1[i].getGreenX(), keys1[i].getGreenY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getRedX(), keys2[i].getRedY()) > diff) {
                    return false;
                }
            }

            //red to orange
            if (keys1[i].getRed() && keys2[i].getRed() && keys1[i].getOrange() && keys2[i].getOrange()) {
                if (this.getDist(keys1[i].getOrangeX(), keys1[i].getOrangeY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getOrangeX(), keys2[i].getOrangeY(), keys2[i].getRedX(), keys2[i].getRedY()) < -(diff) || this.getDist(keys1[i].getOrangeX(), keys1[i].getOrangeY(), keys1[i].getRedX(), keys1[i].getRedY()) - this.getDist(keys2[i].getOrangeX(), keys2[i].getOrangeY(), keys2[i].getRedX(), keys2[i].getRedY()) > diff) {
                    return false;
                }
            }

            //green to yellow
            if (keys1[i].getYellow() && keys2[i].getYellow() && keys1[i].getGreen() && keys2[i].getGreen()) {
                if (this.getDist(keys1[i].getGreenX(), keys1[i].getGreenY(), keys1[i].getYellowX(), keys1[i].getYellowY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getYellowX(), keys2[i].getYellowY()) < -(diff) || this.getDist(keys1[i].getGreenX(), keys1[i].getGreenY(), keys1[i].getYellowX(), keys1[i].getYellowY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getYellowX(), keys2[i].getYellowY()) > diff) {
                    return false;
                }
            }

            //green to orange
            if (keys1[i].getOrange() && keys2[i].getOrange() && keys1[i].getGreen() && keys2[i].getGreen()) {
                if (this.getDist(keys1[i].getGreenX(), keys1[i].getGreenY(), keys1[i].getOrangeX(), keys1[i].getOrangeY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getOrangeX(), keys2[i].getOrangeY()) < -(diff) || this.getDist(keys1[i].getGreenX(), keys1[i].getGreenY(), keys1[i].getOrangeX(), keys1[i].getOrangeY()) - this.getDist(keys2[i].getGreenX(), keys2[i].getGreenY(), keys2[i].getOrangeX(), keys2[i].getOrangeY()) > diff) {
                    return false;
                }
            }

            //yellow to orange
            if (keys1[i].getOrange() && keys2[i].getOrange() && keys1[i].getYellow() && keys2[i].getYellow()) {
                if (this.getDist(keys1[i].getYellowX(), keys1[i].getYellowY(), keys1[i].getOrangeX(), keys1[i].getOrangeY()) - this.getDist(keys2[i].getYellowX(), keys2[i].getYellowY(), keys2[i].getOrangeX(), keys2[i].getOrangeY()) < -(diff) || this.getDist(keys1[i].getYellowX(), keys1[i].getYellowY(), keys1[i].getOrangeX(), keys1[i].getOrangeY()) - this.getDist(keys2[i].getYellowX(), keys2[i].getYellowY(), keys2[i].getOrangeX(), keys2[i].getOrangeY()) > diff) {
                    return false;
                }
            }

        }

        return true;

    }

    public int getDist(int x1, int y1, int x2, int y2) {
        int distance = (int) (Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))));
        return distance;
    }

}
