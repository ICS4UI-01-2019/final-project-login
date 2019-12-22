/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author Pures6322
 */
public class Login {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        long count;
        
        try (Stream<Path> files = Files.list(Paths.get("C:\\Users\\Purew\\OneDrive\\Documents\\NetBeansProjects\\4u-individual-assignments\\final-project-login\\Login\\LOCKED\\Password"))) {
            count = files.count();
        }
        
        for (int i = 0; i < count; i++) {
            int photoNum = i + 1;

            BufferedImage img = null;
            img = ImageIO.read(new File("C:\\Users\\Purew\\OneDrive\\Documents\\NetBeansProjects\\4u-individual-assignments\\final-project-login\\Login\\LOCKED\\Password\\KeyFrame_" + photoNum + ".jpg"));

            ProcessImage proc = new ProcessImage();
            img = proc.ProcessImage(img);

            ImageIO.write(img, "jpg", new File("C:\\Users\\Purew\\OneDrive\\Documents\\NetBeansProjects\\4u-individual-assignments\\final-project-login\\Login\\LOCKED\\Password\\Blacked_KeyFrame_" + photoNum + ".jpg"));
        }
    }

}
