import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private final JTextArea fortuneTextArea;
    private final List<String> fortunes;
    private int lastFortuneIndex = -1; // To track the last fortune displayed

    public FortuneTellerFrame() {
        // Set up the JFrame
        super("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Adjust size as needed`
        setLocationRelativeTo(null); // Center the frame

        Font titleFont = new Font("Chiller", Font.PLAIN, 69);
        Font fortuneFont = new Font("Comic Sans MS",Font.PLAIN, 18);
        Font buttonFont = new Font("Courier Regular", Font.PLAIN, 16);

        JPanel topPanel = getjPanel(titleFont);

        JPanel middlePanel = new JPanel(new BorderLayout());
        fortuneTextArea = new JTextArea();
        fortuneTextArea.setFont(fortuneFont);
        fortuneTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        middlePanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(buttonFont);
        JButton quitButton = new JButton("Quit");
        quitButton.setFont(buttonFont);

        readFortuneButton.addActionListener(_ -> displayFortune());

        quitButton.addActionListener(_ -> System.exit(0));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        fortunes = new ArrayList<>();
        fortunes.add("You will meet a tall, dark stranger... and they will be very confused.");
        fortunes.add("Your dreams will come true... but only if you're asleep.");
        fortunes.add("You will win a big prize... but it's a participation trophy.");
        fortunes.add("You have a bright future... but it's probably just the reflection of your phone screen.");
        fortunes.add("You will travel far and wide... to the bathroom.");
        fortunes.add("A new adventure awaits... in your sock drawer.");
        fortunes.add("You will be surrounded by friends... who are also hungry.");
        fortunes.add("You will find a pot of gold... but it's just a really expensive pot.");
        fortunes.add("You will be a success... at making terrible puns.");
        fortunes.add("You will be rich... in experiences you'll never remember.");
        fortunes.add("You will find true love... in a video game.");
        fortunes.add("You will be the life of the party... even if it's just in your head.");
        fortunes.add("You will have a long and happy life... if you can survive the next five minutes.");
        fortunes.add("You will be a great parent... to your houseplants.");
        fortunes.add("You will be a famous artist... but only in your own mind.");


        // Make the frame visible
        setVisible(true);
    }

    private static JPanel getjPanel(Font titleFont) {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ImageIcon fortuneTellerIcon = new ImageIcon("C:\\Users\\becke\\IdeaProjects\\Lab 04 FortuneTeller\\src\\fortuneTeller.jpg");
        JLabel titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        titleLabel.setFont(titleFont);
        topPanel.add(titleLabel);
        JLabel iconLabel = new JLabel(fortuneTellerIcon, JLabel.CENTER);
        topPanel.add(iconLabel);
        return topPanel;
    }

    private void displayFortune() {
        Random random = new Random();
        int fortuneIndex;
        do {
            fortuneIndex = random.nextInt(fortunes.size());
        } while (fortuneIndex == lastFortuneIndex); // Ensure a different fortune

        lastFortuneIndex = fortuneIndex;
        fortuneTextArea.append(fortunes.get(fortuneIndex) + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FortuneTellerFrame::new);
    }
}
