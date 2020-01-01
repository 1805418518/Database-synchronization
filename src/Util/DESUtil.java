package Util;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DESUtil {
	 
    /**
     * ƫ�Ʊ������̶�ռ8λ�ֽ�
     */
    private final static String IV_PARAMETER = "12345678";
    /**
     * ��Կ�㷨
     */
    private static final String ALGORITHM = "DES";
    /**
     * ����/�����㷨-����ģʽ-���ģʽ
     */
    private static final String CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding";
    /**
     * Ĭ�ϱ���
     */
    private static final String CHARSET = "utf-8";
 
    /**
     * ����key
     *
     * @param password
     * @return
     * @throws Exception
     */
    private static Key generateKey(String password) throws Exception {
        DESKeySpec dks = new DESKeySpec(password.getBytes(CHARSET));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        return keyFactory.generateSecret(dks);
    }
 
 
    /**
     * DES�����ַ���
     *
     * @param password �������룬���Ȳ��ܹ�С��8λ
     * @param data �������ַ���
     * @return ���ܺ�����
     */
    public static String encrypt(String password, String data) {
        if (password== null || password.length() < 8) {
            throw new RuntimeException("����ʧ�ܣ�key����С��8λ");
        }
        if (data == null)
            return null;
        try {
            Key secretKey = generateKey(password);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            byte[] bytes = cipher.doFinal(data.getBytes(CHARSET));
 
            //JDK1.8�����Ͽ�ֱ��ʹ��Base64��JDK1.7�����¿���ʹ��BASE64Encoder
            //Androidƽ̨����ʹ��android.util.Base64
            return new String(Base64.getEncoder().encode(bytes));
 
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }
 
    /**
     * DES�����ַ���
     *
     * @param password �������룬���Ȳ��ܹ�С��8λ
     * @param data �������ַ���
     * @return ���ܺ�����
     */
    public static String decrypt(String password, String data) {
        if (password== null || password.length() < 8) {
            throw new RuntimeException("����ʧ�ܣ�key����С��8λ");
        }
        if (data == null)
            return null;
        try {
            Key secretKey = generateKey(password);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data.getBytes(CHARSET))), CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }
}