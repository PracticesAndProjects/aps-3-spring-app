package com.example.demo.implementation.services.common;

import java.security.SecureRandom;
import java.util.Base64;

public class TokenGenerator {
	private static final SecureRandom secureRandom = new SecureRandom(); // threadsafe
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); // threadsafe

	private String token = "auth";

	public static String generateNewToken() {
		byte[] randomBytes = new byte[24];
		secureRandom.nextBytes(randomBytes);
		return base64Encoder.encodeToString(randomBytes);
	}

	public static String token(String token) {
		return "{\n\"AccessToken\": \"" + token + "\"\n}";
	}

}
