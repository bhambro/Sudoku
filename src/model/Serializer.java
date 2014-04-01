package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
	
	private static Serializer self;
	
	private Serializer(){
		
	}
	
	public static Serializer getInstance(){
		if(self == null){
			self = new Serializer();
		}
		return self;
	}
	
	public int serialize(Object o, String location){
		try{
			FileOutputStream out = new FileOutputStream(location);
			ObjectOutputStream outStream = new ObjectOutputStream(out);
			outStream.writeObject(o);
			out.close();
			return 0;
		} catch(Exception e){
			e.printStackTrace();
			return 1;
		}
	}
	
	public Object unSerialize(String location){
		Object returnable = null;
		try{
			FileInputStream in = new FileInputStream(location);
			ObjectInputStream inStream = new ObjectInputStream(in);
			returnable = inStream.readObject();
			in.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		return returnable;
	}

}
