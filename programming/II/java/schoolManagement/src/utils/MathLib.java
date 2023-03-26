package utils;
import java.util.ArrayList;

public interface MathLib<T> {

  public ArrayList<T> computeLowest();
  
  public ArrayList<T> computeGreatest();

  public double computeGeneralAverage();

  public ArrayList<T> computeOldestStudent();

  public ArrayList<T> computeYoungestStudent();
}
