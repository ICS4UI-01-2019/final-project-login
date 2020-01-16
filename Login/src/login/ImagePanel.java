/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author lalim6488
 */
public class ImagePanel extends JComponent{
    private BufferedImage img;
    
    public void paintComponent(Graphics g){
        if(img != null){
            g.drawImage(img,0,0,this.getWidth(), this.getHeight(),null);
        }
    }
    
    public void setImage(BufferedImage img){
        this.img = img;
    }
}
