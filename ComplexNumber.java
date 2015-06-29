
public class ComplexNumber{
//class Complex Number
  private double real;
  private double imag;
  
public ComplexNumber(double i, double j)
{
    real = i;
    imag = j;
}

public ComplexNumber add(ComplexNumber c2)
{
    return new ComplexNumber(real + c2.getReal(), imag + c2.getImag());
}

public ComplexNumber power(int pwr )
{
    if(pwr == 0)
      return new ComplexNumber(1,0);
    else if (pwr == 1)
      return new ComplexNumber(real, imag);
    else
    {//calculate power
      double realP = real, imagP = imag;
      double realP0 = 0, imagP0 = 0;
      for(int i = pwr; i>1 ; i--){
        realP0 = realP; imagP0 = imagP;
        realP = realP0 * real - imagP0 * imag;
        imagP = realP0 * imag + imagP0 * real;
        //System.out.println(i + " time");
      }// calc power
      return new ComplexNumber(realP,imagP);
    }
    
}


public ComplexNumber times(ComplexNumber c2)
{
    return new ComplexNumber(real * c2.getReal() - imag * c2.getImag(), real * c2.getImag() + c2.getReal()*imag);
}

public ComplexNumber squared()
{
    return new ComplexNumber(real * real - imag * imag,real * imag *  2.0);
}
public double abs()
{
    return Math.sqrt(real*real + imag*imag);
}

public double getReal()
{
    return real;
}
public double getImag()
{
    return imag;
}

public void setReal(double val)
{
    real = val;
}

public void setImag(double val)
{
    imag = val;
}

  
  
  
};