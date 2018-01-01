package com.sample.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CGlobal {

  public static void initialize(String[] args) {
    String filePathName = args[0];
    File file = new File(filePathName);

    try {
      FileInputStream fileInputStream = new FileInputStream(filePathName);
      int i;
      while ((i = fileInputStream.read()) != -1) {
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e){// TODO Auto-generated catch block
  e.printStackTrace();}
  }
}
