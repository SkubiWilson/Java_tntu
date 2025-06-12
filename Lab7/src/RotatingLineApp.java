import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotatingLineApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Обертання відрізка");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);

            DrawingPanel drawingPanel = new DrawingPanel();
            frame.add(drawingPanel, BorderLayout.CENTER);
            frame.setJMenuBar(createMenuBar(frame, drawingPanel));

            frame.setVisible(true);
        });
    }

    private static JMenuBar createMenuBar(JFrame frame, DrawingPanel drawingPanel) {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Файл");
        JMenuItem restartItem = new JMenuItem("Перезапустити");
        JMenuItem exitItem = new JMenuItem("Вийти");

        restartItem.addActionListener(e -> drawingPanel.restart());
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(restartItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu helpMenu = new JMenu("Довідка");
        JMenuItem aboutItem = new JMenuItem("Про програму");

        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(
                frame,
                "Програма демонструє обертання відрізка навколо однієї з його точок.\n" +
                        "Варіант 11. Лабораторна №7.",
                "Про програму",
                JOptionPane.INFORMATION_MESSAGE
        ));

        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }
}

class DrawingPanel extends JPanel implements ActionListener {

    private Timer timer;
    private double angle = 0;
    private final int delay = 30;
    private final int length = 150;
    private final Point pivot = new Point(300, 300);
    private Color lineColor = getRandomColor();
    private int colorChangeCounter = 0;

    public DrawingPanel() {
        setBackground(Color.WHITE);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void restart() {
        angle = 0;
        colorChangeCounter = 0;
        lineColor = getRandomColor();
        repaint();
    }

    private Color getRandomColor() {
        return new Color(
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255)
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        double rad = Math.toRadians(angle);
        int x1 = (int)(pivot.x + length * Math.cos(rad));
        int y1 = (int)(pivot.y + length * Math.sin(rad));

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(pivot.x, pivot.y, x1, y1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle += 2;
        if (angle >= 360) {
            angle = 0;
        }

        // змінюємо колір кожні 10 кадрів
        colorChangeCounter++;
        if (colorChangeCounter % 10 == 0) {
            lineColor = getRandomColor();
        }

        repaint();
    }
}
