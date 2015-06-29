import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.IOException;

public class myManderactal extends ManderbrotFractal implements KeyListener{
  // inherits ManderbrotFractal aka the original ManderbrotFractal
  
  public myManderactal()throws java.io.FileNotFoundException
  {
    colors = new ColorListCont().colList;
    surface = new BufferedImage(X_RES,Y_RES,BufferedImage.TYPE_INT_RGB);
    view = new JLabel(new ImageIcon(surface));
    view.addKeyListener(this);
    view.setFocusable(true);
    Graphics g = surface.getGraphics();
    g.setColor(Color.BLACK);
    g.fillRect(0,0,X_RES,Y_RES);
    scale = 1;
    g.dispose();
    xcen = 0; ycen = 0;
    pwrPara = 2; // change the power of the iteration
    toPaint();
  }//constructor
  public void keyTyped(KeyEvent e){};//not in use
  public void keyReleased(KeyEvent e){};//not in use
  public void keyPressed(KeyEvent e)  {//listener
    int loc = e.getKeyCode();
    if (loc == KeyEvent.VK_LEFT){
      xcen -= 1/ scale * 0.4;
    }else if (loc == KeyEvent.VK_UP){
      ycen -= 1 / scale * 0.4;
    }else if (loc == KeyEvent.VK_DOWN){
      ycen += 1/scale * 0.4;
    }else if (loc == KeyEvent.VK_RIGHT){
      xcen += 1/scale * 0.4;
    }else if (loc == KeyEvent.VK_ENTER){
      scale += scale * 0.35;
    }else if (loc == KeyEvent.VK_SPACE){
      scale = scale * 0.75;
    }//end if
    System.out.println("Waiting Patiently: System generating new image and writing PPM file....");
    try{
      
      toPaint();}
    catch(java.io.FileNotFoundException ee){
      System.out.println(ee.getMessage());
    }
  };
  
  public static void main(String[] args) throws java.io.FileNotFoundException
  {
    myManderactal canvas = new myManderactal();
    JFrame frame = new JFrame();
    int vertexes = 0;
    // Change this next part later to be dynamic.
    vertexes = 10;
    int canvasSize = vertexes * vertexes;
    frame.setSize(canvasSize, canvasSize);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(canvas.view);
    frame.pack();
    frame.setLocationByPlatform(true);
    frame.setVisible(true);
    System.out.println("Advanced Version of Manderbrot, by Chengxi Shi:");
    System.out.println("Use arrow keys to move and enter to zoom in and space to zoom out.");
    System.out.println("Enjoy:");
  }
  
};