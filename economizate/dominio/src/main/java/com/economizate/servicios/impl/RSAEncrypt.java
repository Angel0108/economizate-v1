package com.economizate.servicios.impl;

import javax.crypto.Cipher;
import java.security.*;
import com.economizate.servicios.IEncryption;

public class RSAEncrypt implements IEncryption {

	
	byte[] input;
	
	private final String TRANSFORMATION = "RSA";
	 
	public RSAEncrypt() {
		
		generateKeyPair();
	}
	
	private Key pubkey;
	private Key seckey;
	 
	public void generateKeyPair() {
	  try {
	    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
	    keyPairGen.initialize(2048);
	    KeyPair keyPair = keyPairGen.generateKeyPair();
	    seckey = keyPair.getPrivate();
	    pubkey = keyPair.getPublic();
	  }
	  catch (Exception e) {
	    e.getMessage();
	  }
	}
	 
	@Override
	public byte[] encrypt(String data) {
	  try {
	    Cipher cipher = Cipher.getInstance(TRANSFORMATION);
	    cipher.init(Cipher.ENCRYPT_MODE, pubkey);
	    return cipher.doFinal(data.getBytes());
	  }
	  catch (Exception e) {
	    return new byte[0];
	  }
	}
	 
	public String decrypt(byte[] data) {
	  try {
	    Cipher cipher = Cipher.getInstance(TRANSFORMATION);
	    cipher.init(Cipher.DECRYPT_MODE, seckey);
	    return new String(cipher.doFinal(data));
	  }
	  catch (Exception e) {
	  return new String(new byte[0]);
	  }
	}
	
}
