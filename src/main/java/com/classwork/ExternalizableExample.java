package com.classwork;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizableExample 
{
  public static void main(String[] args) 
  {
    UserSettings settings = new UserSettings();
    settings.setDoNotStoreMe("Sensitive info");
    settings.setFieldOne(10000);
    settings.setFieldTwo("HowToDoInJava.com");
    settings.setFieldThree(false);
     
    //Before
    System.out.println(settings);
    storeUserSettings(settings);
    UserSettings loadedSettings = loadSettings();
    System.out.println(loadedSettings);
  }
   
  private static UserSettings loadSettings() {
        try {
            FileInputStream fis = new FileInputStream("object.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            UserSettings settings =  (UserSettings) ois.readObject();
            ois.close();
            return settings;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
   
  private static void storeUserSettings(UserSettings settings)
  {
    try {
            FileOutputStream fos = new FileOutputStream("object.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(settings);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
  }
}