package com.rjfoods.model;

public class Security {
	
	public static String callEncryption(String text) {
		String encriptedValue = "";

		for (int i = 0; i < text.length(); i++) {
			char charvalue = text.charAt(i);

			int asciiValue = charvalue;

			int encryptingVaLue = asciiValue - 12878;  //+50 use

			char encrname = (char) encryptingVaLue;

			encriptedValue = encriptedValue + encrname;

		}
		return encriptedValue;

	}
	
	
	
	
	

	// to decrypt data
	public static String callDecryption(String text) {
		String decryptioncode = "";

		for (int i = 0; i < text.length(); i++) {
			char charValue = text.charAt(i);

			int decryptionvalue = charValue;

			int decryptedcode = decryptionvalue + 12878;  //-50

			char recharavalue = (char) decryptedcode;

			decryptioncode = decryptioncode + recharavalue;

		}
		return decryptioncode;
	}


}
