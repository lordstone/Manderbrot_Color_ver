import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.awt.Color;
import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.IOException;

public class ManderbrotFractal
{
  public final int MAX_ITER = 255;
  public final double THRESHOLD = 1.5;
  JLabel view;
  BufferedImage surface;
  Random random = new Random();
  public double xcen, ycen;
  public double scale;
  public final int X_RES = 640;
  public final int Y_RES = 480;
  public final String DEF_FILE_NAME = "C:\\temp\\temp.PPM";
  public int pwrPara = 2;
  ArrayList<Color> colors;
  public ManderbrotFractal(){
    colors = new ColorListCont().colList;
  }
  /*
  public void ManderbrotFractal_1()throws java.io.FileNotFoundException
  {
    
    surface = new BufferedImage(640,480,BufferedImage.TYPE_INT_RGB);
    view = new JLabel(new ImageIcon(surface));
    Graphics g = surface.getGraphics();
    g.setColor(Color.BLACK);
    g.fillRect(0,0,640,480);
    scale = 1;
    g.dispose();
    xcen = -0.75; ycen = 0.1;
    ActionListener listener = new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        toPaint();
      }
    };
  }
  */
  public void toPaint()throws java.io.FileNotFoundException {
    double cxmin=-2, cymin=-1,cxmax=1,  cymax=1;
    //write file
    File f = new File(DEF_FILE_NAME);
    FileOutputStream fout = new FileOutputStream(f);
    PrintStream out = new PrintStream(fout);
    out.println("P3");
    out.println(X_RES + " " + Y_RES);
    out.println(MAX_ITER);
    cxmin = xcen - 1.5 / scale;
    cxmax = xcen + 1.5 / scale;
    cymin = ycen - 1 / scale;
    cymax = ycen + 1 / scale;
    Graphics g = surface.getGraphics();
    System.out.println("Calculating Manderbrot...");
    for(int i = 0; i< Y_RES; i++)
    {
      for(int j = 0; j<X_RES; j++)
      {
        ComplexNumber c = new ComplexNumber(0,0);
        c.setReal(cxmin + (double)j/(X_RES-1.0)*(cxmax-cxmin)); //[maps x to cxmin..cxmax]
        c.setImag(cymin + (double)i/(Y_RES-1.0)*(cymax-cymin));// [maps y to cymin..cymax]
        ComplexNumber z = new ComplexNumber(0,0);
        int k = 0;
        while(k < MAX_ITER && z.abs() < THRESHOLD)
        {
          z = z.power(pwrPara).add(c);
          k++;
        }
        if(k>MAX_ITER){
          k=MAX_ITER;
        }
        
        //surface.setRGB(j,i,clr.getRGB());
        g.setColor(colors.get(k));
        g.drawLine(j,i,j,i);
        out.println(( colors.get(k).getRed()) + " "
                      +( colors.get(k).getGreen()) + " "
                      + (colors.get(k).getBlue()));
      }// end for j 
    }// end for i
    
    g.dispose();
    view.repaint();
    out.close();
    System.out.println("Finished...");
    //scale += scale * 0.4;
  }//end of topaint
  
};//end of class