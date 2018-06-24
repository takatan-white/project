package jp.ac.asojuku.asojobs.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author 
 * 暗号化クラス
 */
public class Encryption {

	/* メッセージダイジェストアルゴリズム */
	public MessageDigest md = null;

	/**
	 * 引数でメッセージダイジェストアルゴリズムを指定する。
	 *  MD2, MD5, SHA, SHA-256, SHA-384, SHA-512が利用可能。
	*/
	public Encryption(String algorithmName) {
		try {
			md = MessageDigest.getInstance(algorithmName);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * メッセージダイジェストアルゴリズムを使い、文字列をハッシュ値へ変換する。
	 */
	public byte[] toHashValue(String password) {
		md.update(password.getBytes());
		return md.digest();
	}

	/**
	 *
	 * バイト配列を16進数の文字列に変換し、連結して返す。
	*/
	public String toEncryptedString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			String hex = String.format("%02x", b);
			sb.append(hex);
		}
		return sb.toString();
	}
}
