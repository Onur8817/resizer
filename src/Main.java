import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static double ScreenHeight = 683.4285;
    private static double ScreenWidth = 411.4285;

    public static void main(String[] args) {
        // JFrame oluştur
        JFrame frame = new JFrame("Genişlik ve Yükseklik Hesaplayıcı");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel oluştur ve LayoutManager kullanarak bileşenleri yerleştir
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(600 , 600)); // Panel boyutu ayarlandı

        // Genişlik ve Yükseklik bileşenlerini oluştur
        JLabel widthLabel = new JLabel("Genişlik:");
        JTextField widthField = new JTextField(10);
        JLabel heightLabel = new JLabel("Yükseklik:");
        JTextField heightField = new JTextField(10);
        JButton hesaplaButton = new JButton("Hesapla");
        JLabel resultLabel = new JLabel("");

        // Genişlik ve Yükseklik değerlerini eklemek için yeni alanlar ekleyin
        JLabel screenWidthLabel = new JLabel("Ekran Genişliği:");
        JTextField screenWidthField = new JTextField(10);
        JLabel screenHeightLabel = new JLabel("Ekran Yüksekliği:");
        JTextField screenHeightField = new JTextField(10);

        // Bileşenleri panele sırayla ekle
        panel.add(widthLabel);
        panel.add(widthField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(screenWidthLabel);
        panel.add(screenWidthField);
        panel.add(screenHeightLabel);
        panel.add(screenHeightField);
        panel.add(hesaplaButton);
        panel.add(resultLabel);

        // Hesapla JButton'ına ActionListener ekle
        hesaplaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String widthText = widthField.getText();
                String heightText = heightField.getText();

                // Sadece biri boşsa hesaplama yap
                if ((!widthText.isEmpty() && heightText.isEmpty()) || (widthText.isEmpty() && !heightText.isEmpty()) ||(!widthText.isEmpty() && !heightText.isEmpty())) {
                    double width = !widthText.isEmpty() ? Double.parseDouble(widthText) : 1.0;
                    double height = !heightText.isEmpty() ? Double.parseDouble(heightText) : 1.0;
                    double widthResult = ScreenWidth / width;
                    double heightResult = ScreenHeight / height;
                    resultLabel.setText("Genişlik: ScreenWidth/" + widthResult + "   Yükseklik: ScreenHeight/" + heightResult);
                } else {
                    resultLabel.setText("");
                }

                // Ekran genişliği ve yüksekliği değerlerini al
                if (!screenWidthField.getText().isEmpty()) {
                    ScreenWidth = Double.parseDouble(screenWidthField.getText());
                }
                if (!screenHeightField.getText().isEmpty()) {
                    ScreenHeight = Double.parseDouble(screenHeightField.getText());
                }
            }
        });

        // JPanel'i JFrame'e ekle ve JFrame'i görünür yap
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
