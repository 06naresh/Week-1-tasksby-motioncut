import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinkShortenerGUI {

    // Simulating LinkShortener functionalities
    private static class LinkShortener {
        public String shortenUrl(String longUrl) {
            // Simulating shortening functionality (replace this with actual logic)
            return "http://short.url/" + longUrl.hashCode(); // Generating a fake shortened URL
        }
    }

    private LinkShortener linkShortener;

    public LinkShortenerGUI() {
        linkShortener = new LinkShortener();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Link Shortener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel longUrlLabel = new JLabel("Long URL:");
        JTextField longUrlTextField = new JTextField(20);
        JButton shortenButton = new JButton("Shorten");
        JLabel shortUrlLabel = new JLabel("Shortened URL:");

        panel.add(longUrlLabel);
        panel.add(longUrlTextField);
        panel.add(shortenButton);
        panel.add(shortUrlLabel);

        shortenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String longUrl = longUrlTextField.getText();
                if (!longUrl.isEmpty()) {
                    try {
                        String shortUrl = linkShortener.shortenUrl(longUrl);
                        shortUrlLabel.setText("Shortened URL: " + shortUrl);
                    } catch (Exception ex) {
                        shortUrlLabel.setText("Error: " + ex.getMessage());
                    }
                } else {
                    shortUrlLabel.setText("Please enter a long URL.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LinkShortenerGUI().createAndShowGUI();
            }
        });
    }
}
