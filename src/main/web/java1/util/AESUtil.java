package java1.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * @author Suncm
 * @ClassName java1.util.AESUtil
 * @Date 2018/12/29 14:18
 * @Version 1.0
 */
public class AESUtil {
    private static final String ALGORITHM = "AES";
    private static final String ALGORITHM_STR = "AES/ECB/PKCS5Padding";

    private SecretKeySpec key;

    public AESUtil(String hexKey) {
        key = new SecretKeySpec(hex2byte(hexKey), ALGORITHM);
    }

    public String encryptData(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return new BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
    }

    public String decryptData(String base64Data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(new BASE64Decoder().decodeBuffer(base64Data)));
    }

    private static byte[] hex2byte(String s) {
        if (s.length() % 2 == 0) {
            return hex2byte(s.getBytes(), 0, s.length() >> 1);
        } else {
            return hex2byte("0" + s);
        }
    }

    private static byte[] hex2byte(byte[] b, int offset, int len) {
        // System.out.println(len);
        byte[] d = new byte[len];
        for (int i = 0; i < len * 2; i++) {
            int shift = i % 2 == 1 ? 0 : 4;
            d[i >> 1] |= Character.digit((char) b[offset + i], 16) << shift;
            // System.out.println (new String(d));
        }
        // System.out.println (new String(d));
        return d;
    }

    public static void main(String[] args) throws Exception {

        byte[] helloBytes = "1234567890123456".getBytes();
        String helloHex = DatatypeConverter.printHexBinary(helloBytes);
        System.out.printf("Hello hex: 0x%s\n", helloHex);
       // System.out.println(new String(AESUtil.hex2byte("81920539956472106470348497542172"), "utf-8"));
        //AESUtil util = new AESUtil("05407227153439909468147522555427");
        AESUtil util = new AESUtil("25325634613534543229039428375923");

        System.out.println("cardNo:" + util.encryptData("100000000000745"));
        System.out.println("exp:" + util.encryptData("1501"));
        System.out.println("csc:" + util.encryptData("123"));
       // System.out.println("cardNo:" + util.decryptData("z/pnUAjW35zCea7yaMhktFU382W9tsMpfOynb/71WnI=&"));
        //System.out.println("exp:" + util.decryptData("QyRU8Mq+oKDG/gV+EGSNYw=="));
       // System.out.println("csc:" + util.decryptData("szk7tPu0vUwq5+HRM1Gc9w=="));




        // java1.util.AESUtil util = new java1.util.AESUtil("1234567890123456");
        // System.out.println("cardNo:" + util.encryptData("5309700000000001"));
        // System.out.println("exp:" + util.encryptData("202001"));
        // System.out.println("csc:" + util.encryptData("123"));
    }
}
