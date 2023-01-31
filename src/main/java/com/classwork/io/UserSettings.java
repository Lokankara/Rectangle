package com.classwork.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class UserSettings implements Externalizable {
	 
	  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
	    fieldOne = in.readInt();
	    fieldTwo = in.readUTF();
	    fieldThree = in.readBoolean();
	  }
	 
	  public void writeExternal(ObjectOutput out) throws IOException {
	    out.writeInt(fieldOne);
	    out.writeUTF(fieldTwo);
	    out.writeBoolean(fieldThree);
	  }
	   
	  //This is required
	  public UserSettings(){
	     
	  }
	 
	  private String doNotStoreMe;
	 
	  private Integer fieldOne;
	  private String fieldTwo;
	  private boolean fieldThree;
	 
	  public String getDoNotStoreMe() {
	    return doNotStoreMe;
	  }
	 
	  public void setDoNotStoreMe(String doNotStoreMe) {
	    this.doNotStoreMe = doNotStoreMe;
	  }
	 
	  public Integer getFieldOne() {
	    return fieldOne;
	  }
	 
	  public void setFieldOne(Integer fieldOne) {
	    this.fieldOne = fieldOne;
	  }
	 
	  public String getFieldTwo() {
	    return fieldTwo;
	  }
	 
	  public void setFieldTwo(String fieldTwo) {
	    this.fieldTwo = fieldTwo;
	  }
	 
	  public boolean isFieldThree() {
	    return fieldThree;
	  }
	 
	  public void setFieldThree(boolean fieldThree) {
	    this.fieldThree = fieldThree;
	  }

	 
	  @Override
	  public String toString() {
	    return "UserSettings [doNotStoreMe=" + doNotStoreMe + ", fieldOne="
	        + fieldOne + ", fieldTwo=" + fieldTwo + ", fieldThree="
	        + fieldThree + "]";
	  }
	}