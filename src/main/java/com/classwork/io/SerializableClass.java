package com.classwork.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
public class SerializableClass implements Serializable
{
 
  private static final long serialVersionUID = 1L;
 
  private String firstName = null;
  private String lastName = null;
 
  @SuppressWarnings("serial")
  private List permissions = new ArrayList()
                      {
                        {
                          add("ADMIN");
                          add("USER");
                        }
                      };
 
  public SerializableClass(final String fName, final String lName)
  {
    //validateNameParts(fName);
    //validateNameParts(lName);
    this.firstName = fName;
    this.lastName = lName;
  }
 
  public SerializableClass deepCopy() throws Exception
    {
      //Serialization of object
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(this);
 
        //De-serialization of object
        ByteArrayInputStream bis = new   ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bis);
        SerializableClass copied = (SerializableClass) in.readObject();
 
        //Verify that object is not corrupt
 
        //validateNameParts(fName);
        //validateNameParts(lName);
 
        return copied;
    }
 
  public String getFirstName() {
    return firstName;
  }
 
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
 
  public String getLastName() {
    return lastName;
  }
 
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
 
  @Override
  public String toString() {
    return new StringBuilder().append(getFirstName()+",")
                  .append(getLastName()+",")
                  .append(permissions)
                  .toString();
  }
}