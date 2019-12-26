/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author Purew
 */
public class Gesture extends javax.swing.JFrame {

    //create a thread to run in the background
    //Daemon Thread was used so this process ran in the background 
    private DaemonThread myThread = null;
    //variable to keep track of the number of frames
    private int frameNum = 0;
    //variable to keep track of the number of times six frames have been taken
    private int loops = 0;
    //the video capture device (not intitalized yet)
    private VideoCapture webSource = null;
    //variable to hold each frame (opencv uses something called a 'mat')
    private Mat frame = new Mat();
    //the memory (data) of each frame
    private MatOfByte mem = new MatOfByte();
    //whether or not the window will be used to setup a gesture or input one
    private boolean mode;
    //number of files in the password folder (minus config file)
    long fileCount = new File("C:\\Users\\Purew\\OneDrive\\Documents\\NetBeansProjects\\4u-individual-assignments\\final-project-login\\Login\\LOCKED\\Password").list().length - 1;
    //instance of file info
    FileInfo fInfo = new FileInfo();

    /**
     * Creates new form Window
     *
     * @param mode mode setting (true is inputting a gesture and false is
     * setting up a gesture)
     */
    public Gesture(boolean mode) {
        this.mode = mode;
        initComponents();

        if (this.mode) {
            //initialize the camera to the computer's defaut device
            this.webSource = new VideoCapture(0);
            //intitalize the daemon thread and cast it to a thread
            this.myThread = new DaemonThread();
            Thread t = new Thread(myThread);
            //start the thread
            t.setDaemon(true);
            this.myThread.runnable = true;
            t.start();
            //disable the buttons
            Stop.setEnabled(false);
            Start.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Start = new javax.swing.JButton();
        Stop = new javax.swing.JButton();
        video = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gesture");
        setResizable(false);

        Start.setBackground(new java.awt.Color(0, 204, 0));
        Start.setText("Start");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        Stop.setBackground(new java.awt.Color(255, 51, 51));
        Stop.setText("Stop");
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout videoLayout = new javax.swing.GroupLayout(video);
        video.setLayout(videoLayout);
        videoLayout.setHorizontalGroup(
            videoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
        );
        videoLayout.setVerticalGroup(
            videoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(video, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(video, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        //initialize the camera to the computer's defaut device
        this.webSource = new VideoCapture(0);
        //intitalize the daemon thread and cast it to a thread
        this.myThread = new DaemonThread();
        Thread t = new Thread(myThread);
        //start the thread
        t.setDaemon(true);
        this.myThread.runnable = true;
        t.start();
        //disable the start button (to avoid errors)
        //enable the stop button
        this.Start.setEnabled(false);
        this.Stop.setEnabled(true);
    }//GEN-LAST:event_StartActionPerformed

    private void StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopActionPerformed
        //stop the thread
        this.myThread.runnable = false;
        //enable the start button
        //disable the stop button (to avoid errors)
        this.Stop.setEnabled(false);
        this.Start.setEnabled(true);
        //disable the video capture device
        this.webSource.release();
    }//GEN-LAST:event_StopActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //load in the opencv java library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gesture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gesture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gesture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gesture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gesture(true).setVisible(true);
            }
        });
    }

    /**
     * Class controlling the gathering of the capture device's frames and
     * processing the data into a buffered image for the frame to display. Class
     * is located within the gesture class for easy access to video capture
     * device, gesture window and other local variables in the gesture class
     */
    class DaemonThread implements Runnable {

        //variable for wether or not the thread is running is
        //protected (so classes within this package can access this variable but not the world) and
        //volitile (for easy access amoung different threads)
        protected volatile boolean runnable = false;

        /**
         * Run method to control the thread's function
         */
        @Override
        public void run() {
            //synchronizing thread to allow for multi-threading
            synchronized (this) {
                //loop while the thread is 'active'
                while (this.runnable) {
                    //if the video capture device has a frame to grab
                    if (webSource.grab()) {
                        try {
                            //send the video capture frame's data to the variable 'frame'
                            webSource.retrieve(frame);
                            //seperate the data in 'frame' into it's bytes (into a .bmp format)
                            Imgcodecs.imencode(".bmp", frame, mem);
                            //rearrange the bytes (data) into an image
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                            //if the number of frames is six reset the count to zero and save the image to the 'Password' folder (as a .jpg)
                            if (frameNum == 6) {
                                frameNum = 0;
                                loops++;
                                if (mode) {
                                    Imgcodecs.imwrite("C:\\Users\\Purew\\OneDrive\\Documents\\NetBeansProjects\\4u-individual-assignments\\final-project-login\\Login\\LOCKED\\Guess\\KeyFrame_" + loops + ".jpg", frame);
                                } else {
                                    Imgcodecs.imwrite("C:\\Users\\Purew\\OneDrive\\Documents\\NetBeansProjects\\4u-individual-assignments\\final-project-login\\Login\\LOCKED\\Password\\KeyFrame_" + loops + ".jpg", frame);
                                }
                                System.out.println("Frame_" + loops + " SAVED!");
                            }
                            //turn the image into a buffered image
                            BufferedImage buff = (BufferedImage) im;

                            //get the graphics of the JLabel in the gesture window
                            Graphics g = video.getGraphics();
                            //draw the buffered image to the JLabel (video)
                            g.drawImage(buff, 0, 0, getWidth(), getHeight() - 150, 0, 0, buff.getWidth(), buff.getHeight(), null);
                            //if runnable is false then pause the thread and let the user know ("video paused")
                            if (this.runnable == false) {
                                System.out.println("Video Paused!");
                                this.wait();
                            }

                            //increase the number of frames
                            frameNum++;

                            if (mode) {
                                if (loops == fileCount) {
                                    this.runnable = false;
                                    BufferedImage[] guess = fInfo.buffLoad("C:\\Users\\Purew\\OneDrive\\Documents\\NetBeansProjects\\4u-individual-assignments\\final-project-login\\Login\\LOCKED\\Guess");
                                    fInfo.updateFile("C:\\Users\\Purew\\OneDrive\\Documents\\NetBeansProjects\\4u-individual-assignments\\final-project-login\\Login\\LOCKED\\Guess\\Config.txt", guess);
                                    System.out.println("cool");
                                    KeyFrame[] key1 = fInfo.readFile("C:\\Users\\Purew\\OneDrive\\Documents\\NetBeansProjects\\4u-individual-assignments\\final-project-login\\Login\\LOCKED\\Guess\\Config.txt");

                                    BufferedImage[] pass = fInfo.buffLoad("C:\\Users\\Purew\\OneDrive\\Documents\\NetBeansProjects\\4u-individual-assignments\\final-project-login\\Login\\LOCKED\\Password");
                                    fInfo.updateFile("C:\\Users\\Purew\\OneDrive\\Documents\\NetBeansProjects\\4u-individual-assignments\\final-project-login\\Login\\LOCKED\\Password\\Config.txt", pass);
                                    KeyFrame[] key2 = fInfo.readFile("C:\\Users\\Purew\\OneDrive\\Documents\\NetBeansProjects\\4u-individual-assignments\\final-project-login\\Login\\LOCKED\\Password\\Config.txt");

                                    Main m = new Main();
                                    if (m.compareKeys(key1, key2)) {
                                        System.out.println("Match");
                                        new Menu().setVisible(true);
                                    }else{
                                        System.out.println("No Match");
                                    }
                                }
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Start;
    private javax.swing.JButton Stop;
    private javax.swing.JPanel video;
    // End of variables declaration//GEN-END:variables
}
