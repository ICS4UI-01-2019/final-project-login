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

}
