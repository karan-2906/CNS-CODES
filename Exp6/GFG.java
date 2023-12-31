import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Java program to calculate SHA-256 hash value
class GFG2 {
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // digest() method called to calculate the message digest of an input
        // and return an array of bytes
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        // Convert the byte array into a signum representation
        BigInteger number = new BigInteger(1, hash);
        // Convert the message digest into a hex value
        String hexString = number.toString(16);

        // Pad with leading zeros if needed
        while (hexString.length() < 64) {
            hexString = "0" + hexString;
        }

        return hexString;
    }

    // Driver code
    public static void main(String[] args) {
        try {
            System.out.println("HashCode Generated by SHA-256 for:\n");
            String s1 = "Batchfour";
            System.out.println(s1 + " : " + toHexString(getSHA(s1)));
            String s2 = "\n hello world";
            System.out.println(s2 + " : " + toHexString(getSHA(s2)));
            String s3 = "K1t4fo0V";
            System.out.println(s3 + " : " + toHexString(getSHA(s3)));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
    }
}
