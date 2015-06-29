import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

class ColorListCont {
  public ArrayList<Color> colList = new ArrayList<Color>();
  public final int COL_SIZE = 256;
  public final int RND_VELOCITY = 10;
  public final int RND_INTERVAL = COL_SIZE / RND_VELOCITY;
  ColorListCont() {
    Random rng = new Random(); // rand num generator 
    int[] rgbC = new int[3] ; boolean[] rgbUP = new boolean[3];
    for(int k = 0;k<3;k++){
      rgbC[k] = rng.nextInt(COL_SIZE);
      rgbUP[k] = rng.nextBoolean();
    }//end for i
    for(int i = 0; i< COL_SIZE-1;i++){
      for(int j = 0; j < 3; j++){
        if(rgbUP[j]){
          rgbC[j] += rng.nextInt(RND_INTERVAL);
          if(rgbC[j]>255){
            rgbC[j] = 255;
            rgbUP[j] = false;
          }//end for >255
        }else{
          rgbC[j] -= rng.nextInt(RND_INTERVAL);
          if(rgbC[j]<0){
            rgbC[j] = 0;
            rgbUP[j] = true;
          }//end for >255
        }//end if rgbUP[j]
      }//end for j
      Color c = new Color(rgbC[0], rgbC[1], rgbC[2]);
      colList.add(c);
    }// end for i
    Color c = new Color(0, 0, 0);
    colList.add(c);
    //System.out.println("collist size:" + colList.size());
  }// constructor
}// ColorList