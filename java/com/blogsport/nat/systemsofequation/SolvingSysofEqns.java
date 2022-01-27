package com.blogsport.nat.systemsofequation;

//logics adapted from Technical Java[
public class SolvingSysofEqns {
  public static void gaussJordan(double[][] a, double[] b) {
    int numRows = a.length;
    int numCols = (a[0]).length;
    int[][] index = new int[numRows][2];
    partialPivot(a, b, index);
    int i;
    for (i = 0; i < numRows; i++) {
      double temp = a[i][i];
      int m;
      for (m = 0; m < numCols; m++)
        a[i][m] = a[i][m] / temp; 
      b[i] = b[i] / temp;
      a[i][i] = 1.0D / temp;
      for (int k = 0; k < numRows; k++) {
        if (k != i) {
          temp = a[k][i];
          for (m = 0; m < numCols; m++)
            a[k][m] = a[k][m] - temp * a[i][m]; 
          b[k] = b[k] - temp * b[i];
          a[k][i] = -temp * a[i][i];
        } 
      } 
    } 
    for (int j = numCols - 1; j >= 0; j--) {
      int k = index[j][0];
      int m = index[j][1];
      if (k != m)
        for (i = 0; i < numRows; i++) {
          double temp = a[i][m];
          a[i][m] = a[i][k];
          a[i][k] = temp;
        }  
    } 
  }
  
  public static void gaussian(double[][] a, double[] b) {
    int numRows = a.length;
    int numCols = (a[0]).length;
    int[][] index = new int[numRows][2];
    partialPivot(a, b, index);
    int i;
    for (i = 0; i < numRows; i++) {
      b[i] = b[i] / a[i][i];
      for (int j = numCols - 1; j >= i; j--)
        a[i][j] = a[i][j] / a[i][i]; 
      for (int k = i + 1; k < numRows; k++) {
        b[k] = b[k] - a[k][i] * b[i];
        for (int m = i + 1; m < numCols; m++)
          a[k][m] = a[k][m] - a[k][i] * a[i][m]; 
      } 
    } 
    for (i = numRows - 2; i >= 0; i--) {
      for (int j = i + 1; j < numRows; j++)
        b[i] = b[i] - a[i][j] * b[j]; 
    } 
  }
  
  public static void luDecomp(double[][] a, double[] b) {
    int numRows = a.length;
    int numCols = (a[0]).length;
    int j = 0;
    if (j < numCols) {
      int i;
      for (i = 0; i <= j; i++) {
        for (int k = 0; k < j; k++)
          a[i][j] = a[i][j] - a[i][k] * a[k][j]; 
        int m = j;
        for (i = j + 1; i < numRows; i++) {
          if (Math.abs(a[i][j]) > Math.abs(a[m][j]))
            m = i; 
        } 
        if (m != j) {
          double[] tempRow = a[j];
          a[j] = a[m];
          a[m] = tempRow;
          double temp = b[j];
          b[j] = b[m];
          b[m] = temp;
        } 
        for (i = j + 1; i < numRows; i++)
          a[i][j] = a[i][j] / a[j][j]; 
      } 
      for (i = 1; i < numRows; i++) {
        for (j = 0; j < i; j++)
          b[i] = b[i] - a[i][j] * b[j]; 
      } 
      b[numRows - 1] = b[numRows - 1] / a[numRows - 1][numRows - 1];
      for (i = numRows - 2; i >= 0; i--) {
        for (j = i + 1; j < numCols; j++)
          b[i] = b[i] - a[i][j] * b[j]; 
        b[i] = b[i] / a[i][i];
      } 
      return;
    } 
  }
  
  public static void invertMatrix(double[][] a) {
    int numRows = a.length;
    int numCols = (a[0]).length;
    int[][] index = new int[numRows][2];
    partialPivot(a, new double[numRows], index);
    int i;
    for (i = 0; i < numRows; i++) {
      double temp = a[i][i];
      int m;
      for (m = 0; m < numCols; m++)
        a[i][m] = a[i][m] / temp; 
      a[i][i] = 1.0D / temp;
      for (int k = 0; k < numRows; k++) {
        if (k != 1) {
          temp = a[k][i];
          for (m = 0; m < numCols; m++)
            a[k][m] = a[k][m] - temp * a[i][m]; 
          a[k][i] = -temp * a[i][i];
        } 
      } 
    } 
    for (int j = numCols - 1; j >= 0; j--) {
      int k = index[j][0];
      int m = index[j][1];
      if (k != m)
        for (i = 0; i < numRows; i++) {
          double temp = a[i][m];
          a[i][m] = a[i][k];
          a[i][k] = temp;
        }  
    } 
  }
  
  private static void partialPivot(double[][] a, double[] b, int[][] index) {
    int numRows = a.length;
    int numCols = (a[0]).length;
    double[] scale = new double[numRows];
    int i;
    for (i = 0; i < numRows; i++) {
      index[i][0] = i;
      index[i][1] = i;
      for (int k = 0; k < numCols; k++)
        scale[i] = Math.max(scale[i], Math.abs(a[i][k])); 
    } 
    for (int j = 0; j < numCols - 1; j++) {
      int m = j;
      for (i = j + 1; i < numRows; i++) {
        if (Math.abs(a[i][j]) / scale[i] > Math.abs(a[m][j]) / scale[m])
          m = i; 
      } 
      if (m != j) {
        index[j][0] = j;
        index[j][1] = m;
        double[] tempRow = a[j];
        a[j] = a[m];
        a[m] = tempRow;
        double temp = b[j];
        b[j] = b[m];
        b[m] = temp;
        temp = scale[j];
        scale[j] = scale[m];
        scale[m] = temp;
      } 
    } 
  }
}
