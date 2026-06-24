Cipher cipher = Cipher.getInstance("AES/GCM/NoPADDING");

// Added import
import javax.crypto.spec.GCMParameterSpec;

// Changed code from ECB to GCM
public byte[] encrypt(byte[] plaintext, byte[] iv) {
    GCMParameterSpec spec = new GCMParameterSpec(128, iv);
    cipher.init(Cipher.ENCRYPT_MODE, secretKey, spec);
    return cipher.doFinal(plaintext);
}

public byte[] decrypt(byte[] ciphertext, byte[] iv) {
    GCMParameterSpec spec = new GCMParameterSpec(128, iv);
    cipher.init(Cipher.DECRYPT_MODE, secretKey, spec);
    return cipher.doFinal(ciphertext);
}