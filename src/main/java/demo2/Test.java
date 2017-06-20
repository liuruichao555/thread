package demo2;

import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;

/**
 * 如果要把多个操作合并为一个复合操作，还是需要额外的加锁机制
 *
 * @author liuruichao
 * @date 15/6/9 下午3:44
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        /*Integer element = 1;
        Vector<Integer> vector = new Vector<Integer>();
        // 存在竞态条件，需要额外的加锁机制
        if (!vector.contains(element)) {
            vector.add(element);
        }*/
        /*String str = "liuruichao";
        byte[] digest = DigestUtils.getSha256Digest().digest(str.getBytes("utf-8"));
        System.out.println(new String(digest, "utf-8"));*/

        /*String str = "asdfaskdjhgaslkjdfhqwoeuityqwoetuxzjchnbvsaljdfhsadlfasdfsad";
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
        System.out.println(new String(hash, StandardCharsets.UTF_8));*/

        String hashStr = Hashing.sha256().hashString("liuruichao", StandardCharsets.UTF_8).toString();
        System.out.println(hashStr);

        byte[] hash = DigestUtils.sha256("liuruichao".getBytes(StandardCharsets.UTF_8));
        System.out.println(hash2Str(hash));
    }

    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    public static final String hash2Str(byte[] bytes) {
        StringBuilder sb = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            sb.append(hexDigits[(b >> 4) & 0xf]).append(hexDigits[b & 0xf]);
        }
        return sb.toString();
    }
}