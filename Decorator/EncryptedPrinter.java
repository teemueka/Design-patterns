package Decorator;

import java.io.IOException;

public class EncryptedPrinter extends BaseDecorator {

    public EncryptedPrinter(IPrinter printer) {
        super(printer);
    }

    @Override
    public void print(String text) throws IOException {
        super.print(encrypt(text));
    }

    public String encrypt(String text) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encryptedText.append((char) (c + 5));
        }
        return encryptedText.toString();
    }

    public String decrypt(String encryptedText) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : encryptedText.toCharArray()) {
            decryptedText.append((char) (c - 5));
        }
        return decryptedText.toString();
    }

}
