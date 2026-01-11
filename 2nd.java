import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CaptchaPopup {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CaptchaPopup::showCaptcha);
    }

    static void showCaptcha() {
        while (true) {
            String captcha = generateCaptcha(6);

            JLabel captchaLabel = new JLabel("CAPTCHA: " + captcha);
            captchaLabel.setFont(new Font("Arial", Font.BOLD, 20));

            JTextField inputField = new JTextField(10);

            JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
            panel.add(captchaLabel);
            panel.add(inputField);

            int result = JOptionPane.showConfirmDialog(
                    null,
                    panel,
                    "Verifikasi CAPTCHA",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (result != JOptionPane.OK_OPTION) {
                System.exit(0); // jika user cancel
            }

            if (inputField.getText().equals(captcha)) {
                JOptionPane.showMessageDialog(null, "CAPTCHA benar! Akses diterima.");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "CAPTCHA salah! Coba lagi.");
            }
        }
    }

    static String generateCaptcha(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder captcha = new StringBuilder();

        for (int i = 0; i < length; i++) {
            captcha.append(chars.charAt(random.nextInt(chars.length())));
        }

        return captcha.toString();
    }
}
