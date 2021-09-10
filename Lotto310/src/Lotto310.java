import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Lotto310 extends JFrame implements ActionListener {
	JLabel firstLabel;
	JLabel secondLabel;
	JLabel thirdLabel;
	JButton lottery;
	JButton reset;
	JButton close;

	public Lotto310() {
		super("Lotto 310 프로그램");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		try {
			UIManager.setLookAndFeel("com.sun.java.swing." + "plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(Lotto310.this);
		} catch (Exception e) {
		}
		makeGUI();
	}

	public void makeGUI() {
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(255, 245, 235));

		firstLabel = new JLabel(new ImageIcon("res/1.jpg"));
		secondLabel = new JLabel(new ImageIcon("res/2.jpg"));
		thirdLabel = new JLabel(new ImageIcon("res/3.jpg"));
		lottery = new JButton("번호 추첨");
		reset = new JButton("초기화", new ImageIcon("res/reset.png"));
		close = new JButton("종료");

		firstLabel.setBounds(20, 20, 100, 100);
		secondLabel.setBounds(170, 20, 100, 100);
		thirdLabel.setBounds(320, 20, 100, 100);

		lottery.setBounds(10, 140, 120, 30);
		reset.setBounds(160, 140, 120, 30);
		close.setBounds(310, 140, 120, 30);

		c.add(firstLabel);
		c.add(secondLabel);
		c.add(thirdLabel);

		c.add(lottery);
		c.add(reset);
		c.add(close);

		lottery.addActionListener(this);
		reset.addActionListener(this);
		close.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lottery) {
			int number[] = new int[10];
			for (int i = 0; i < number.length; i++) {
				number[i] = i + 1;
			}
			int temp = 0;
			int j = 0;
			for (int i = 0; i < 10; i++) {
				j = (int) (Math.random() * 10);
				temp = number[0];
				number[0] = number[j];
				number[j] = temp;
			}
			firstLabel.setIcon(new ImageIcon("res/" + number[0] + ".jpg"));
			secondLabel.setIcon(new ImageIcon("res/" + number[1] + ".jpg"));
			thirdLabel.setIcon(new ImageIcon("res/" + number[2] + ".jpg"));

		} else if (e.getSource() == reset) {
			firstLabel.setIcon(new ImageIcon("res/1.jpg"));
			secondLabel.setIcon(new ImageIcon("res/2.jpg"));
			thirdLabel.setIcon(new ImageIcon("res/3.jpg"));

		} else if (e.getSource() == close) {
			System.exit(0);
		}
	}

	public static void main(String args[]) {
		Lotto310 ee = new Lotto310();
		ee.setSize(460, 220);
		ee.setVisible(true);
	}
}
