package com.bms.controller;

import java.security.Key;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class UUIDGnerator {

	public String idGenarate(){
		UUID id = UUID.randomUUID();
		String x=id.toString().replaceAll("-", "");
		return x;
	}
	
	  public String encodePassword(String password){
		  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		  String hashedPassword = passwordEncoder.encode(password);
		  return hashedPassword;
		  
	  }
	  
	  private static final String ALGO = "AES";
	  private static final byte[] keyValue
	          = new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't',
	              'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};

	
	public  String encrypt(String Data) throws Exception {
	      Key key = generateKey();
	      Cipher c = Cipher.getInstance(ALGO);
	      c.init(Cipher.ENCRYPT_MODE, key);
	      byte[] encVal = c.doFinal(Data.getBytes());
	      String encryptedValue = new BASE64Encoder().encode(encVal);
	      return encryptedValue;
	  }

	
	public  String decrypt(String encryptedData) throws Exception {
	      Key key = generateKey();
	      Cipher c = Cipher.getInstance(ALGO);
	      c.init(Cipher.DECRYPT_MODE, key);
	      byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
	      byte[] decValue = c.doFinal(decordedValue);
	      String decryptedValue = new String(decValue);
	      return decryptedValue;
	  }
	  
	  private static Key generateKey() throws Exception {
	      Key key = new SecretKeySpec(keyValue, ALGO);
	      return key;
	  }

	  
	public static void main(String[] args){
		
	//	System.out.println(idGenarate());
	
	
	
		String password = "123456";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);
		
		/*public static String hashPassword(String password) throws NoSuchAlgorithmException{
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] b =md.digest();
			StringBuffer sb=new StringBuffer();
			for(byte b1:b){
				sb.append(Integer.toHexString(b1 & 0xff).toString());
			}
			return sb.toString();
		}
	  */
	
	}
	
}
