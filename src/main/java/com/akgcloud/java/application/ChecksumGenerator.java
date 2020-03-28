package com.akgcloud.java.application;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Random;
import java.util.zip.Adler32;
import java.util.zip.Checksum;
import org.apache.commons.codec.binary.Base64;

/**
 * @author Anil
 * 
 */

public class ChecksumGenerator implements Cloneable {
	public static final String postParam = "TBZ008BDOJ7" + "2791" + "920822"
			+ "A0137119207783466600" + "24,3"
			+ "https://www.travelbindaaz.com/nav/payworld_res" + "checksum";

	private String memoryString;

	private static final int num = 0;

	public ChecksumGenerator() {

	}

	public String getMemoryString() {
		return memoryString;
	}

	public void setMemoryString(String memoryString) {
		this.memoryString = memoryString;
	}

	/**
	 * 
	 * @param origString
	 * @return
	 */
	public static String calculateAdler32Checksum(String origString) {
		byte bytes[] = origString.getBytes();
		Checksum checksum = new Adler32();
		checksum.update(bytes, 0, bytes.length);
		String strChecksum = Long.toString(checksum.getValue());

		return strChecksum;
	}

	/**
	 * 
	 * @param foreignUserKey
	 * @return
	 */

	public static String calculateAuthKeyForSSOLogin() {
		String compare = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(("37/14/844912290bWr1fGoifHw6EFgi2G9G0TgfqEjfe")
					.getBytes("UTF-8"));
			byte raw[] = md.digest();
			compare = new String(Base64.encodeBase64(raw));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return compare;
	}

	public static String scramble(String word) {
		String newword = "";
		int rndnum;
		Random randGen = new Random();
		boolean letter[] = new boolean[word.length()];
		do {
			rndnum = randGen.nextInt(word.length());
			if (letter[rndnum] == false) {
				newword = newword + word.charAt(rndnum);
				letter[rndnum] = true;
			}
		} while (newword.length() < word.length());
		return newword;
	}

	public static void main(String args[]) throws Exception {

		// System.out.println(TestExample.calculateAdler32Checksum(postParam));
		// System.out.println(TestExample.scramble("thomascookzillious".toUpperCase()));
		System.out.println("Output here");
		System.out.println(URLEncoder.encode(calculateAuthKeyForSSOLogin(),
				"UTF-8"));

	}
}
