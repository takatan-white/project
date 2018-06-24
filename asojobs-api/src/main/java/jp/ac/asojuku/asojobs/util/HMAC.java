package jp.ac.asojuku.asojobs.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author
 * HMAC暗号クラス
 */
public class HMAC {
	/*
	 HMAC_MD5("key", "The quick brown fox jumps over the lazy dog") = 0x80070713463e7749b90c2dc24911e275
	 HMAC_SHA1("key", "The quick brown fox jumps over the lazy dog") = 0xde7c9b85b8b78aa6bc8a7a36f70a90701c9db4d9
	 HMAC_SHA256("key", "The quick brown fox jumps over the lazy dog") = 0xf7bc83f430538424b13298e6aa6fb143ef4d59a14946175997479dbc2d1a3cd8
	  System.out.println(hmacDigest("The quick brown fox jumps over the lazy dog", "key", "HmacSHA1"));
	 */
	/**
	 * ハッシュ関数を用いて「秘密鍵」と「認証すべき任意長のメッセージ」から暗号認証コード(MAC値)を生成する。
	 * @param msg
	 * @param keyString
	 * @param algo
	 * @return digest
	 */
	public static String hmacDigest(String msg, String keyString, String algo) {
	    String digest = null;
	    try {
	      SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
	      Mac mac = Mac.getInstance(algo);
	      mac.init(key);

	      byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));

	      StringBuffer hash = new StringBuffer();
	      for (int i = 0; i < bytes.length; i++) {
	        String hex = Integer.toHexString(0xFF & bytes[i]);
	        if (hex.length() == 1) {
	          hash.append('0');
	        }
	        hash.append(hex);
	      }
	      digest = hash.toString();
	    } catch (UnsupportedEncodingException e) {
	    } catch (InvalidKeyException e) {
	    } catch (NoSuchAlgorithmException e) {
	    }
	    return digest;
	  }
}
