/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Pures6322
 */
public class Login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File file = new File("X:\\vlcplayer\\vlc.exe");
        Desktop.getDesktop().open(file);
        System.out.println("Worked!");
        
    }
    
}
