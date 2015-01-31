import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class Main{
    private static final String ENCRYPTION_KEY="hlqjncOTyf4Xgx48pAwRbSO2YH9z4iRv";
    public static void main(String[]args){
        System.out.println(decrypt("4wqBuHu1+iUOgrxpaFVJ/A=="));
    }
    public static String encrypt(String input) {
		byte[] crypted = null;
		try {
			SecretKeySpec skey = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skey);
			crypted = cipher.doFinal(input.getBytes());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new String(Base64.encode(crypted,0));
	}

	public static String decrypt(String input) {
		byte[] output = null;
		try {
			SecretKeySpec skey = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skey);
			output = cipher.doFinal(Base64.decode(input,0));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new String(output);
	}
}