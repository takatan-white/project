package jp.ac.asojuku.asojobs.util;

import org.apache.commons.codec.binary.Base64;

public class EncodeUtil {
	public static String decode(String text){
	     byte[] encoded = text.getBytes();
		 byte[] decoded = Base64.decodeBase64(encoded);//デコード処理
	     String decodedStr = new String(decoded);//デコード結果のbyte[]を文字列にする
	     return decodedStr;
	}
}
