package com.fa.inventory.encryptdecrypt;

import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

import com.fa.inventory.constants.InventoryConstant;

public class FaSoftwareSolutinonEncryptionDecryption {

	private static String UTF = "UTF-8";
/*	private Pattern BCRYPT_PATTERN = Pattern
			.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");*/
	protected final Logger logger = Logger.getLogger(getClass());

	public FaSoftwareSolutinonEncryptionDecryption() {
		/*
		 * 
		 */
	}

	public String encryptionText(String text, String key) {
		String encText = "";
		byte[] keyArray = new byte[24];
		byte[] toEncryptArray = null;
		try {
			toEncryptArray = text.getBytes(UTF);
			MessageDigest m = MessageDigest.getInstance("MD5");
			byte temporaryKey[] = m.digest(key.getBytes(UTF));
			if (temporaryKey.length < 24) {
				int index = 0;
				for (int i = temporaryKey.length; i < 24; i++)
					keyArray[i] = temporaryKey[index];

			}
			Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			c.init(1, new SecretKeySpec(keyArray, "DESede"), new IvParameterSpec(sharedvector));
			byte encrypted[] = c.doFinal(toEncryptArray);
			encText = Base64.getEncoder().encodeToString(encrypted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encText;
	}

	public String decryptText(String text, String key) {
		String decrypText = "";
		byte keyArray[] = new byte[24];
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			byte temporaryKey[] = m.digest(key.getBytes(UTF));
			if (temporaryKey.length < 24) {
				int index = 0;
				for (int i = temporaryKey.length; i < 24; i++)
					keyArray[i] = temporaryKey[index];

			}
			Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			c.init(2, new SecretKeySpec(keyArray, "DESede"), new IvParameterSpec(sharedvector));
			//Base64.getDecoder().
			
			//byte decrypted[] = c.doFinal(Base64.getDecoder().decode(text.getBytes()));
			byte[] decrypted = c.doFinal(Base64.getDecoder().decode(text));
			
			decrypText = new String(decrypted, UTF);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decrypText;
	}

	private static byte[] sharedvector = { 1, 2, 3, 5, 7, 11, 13, 17 };
	
/*	
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		if (encodedPassword == null || encodedPassword.length() == 0) {
			logger.warn("Empty encoded password");
			return false;
		}

		if (!BCRYPT_PATTERN.matcher(encodedPassword).matches()) {
			logger.warn("Encoded password does not look like BCrypt");
			return false;
		}

		return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
	}*/
	
	public static void main(String args[]){
		FaSoftwareSolutinonEncryptionDecryption obj = new FaSoftwareSolutinonEncryptionDecryption();
		String name = "asdfasdfasdfasdfsadf";
		String encName = obj.encryptionText(name, InventoryConstant.PASSWORD_KEY);
		System.out.println(encName);
		String decName = obj.decryptText("oQTPxFriEt3gyr6YxFmuE2IjKNBi7v1o", InventoryConstant.PASSWORD_KEY);
		System.out.println(decName);
	}
	
	

}