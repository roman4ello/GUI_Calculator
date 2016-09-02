
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DebugGraphics;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;
//Main class, here method main()

public class GUI_Calculator extends JFrame {


	static GUI_CalculatorProcessing objProcess;
	static JTextField txtField = new JTextField();
	static JButton buttZero = new JButton("0");
	static JButton buttComa = new JButton("   ,  ");
	static JButton buttEqually = new JButton(" = ");
	static JButton[] arrDigitsButt = new JButton[9];
	static JButton[] arrButtArZn = new JButton[4];
	{
		arrButtArZn[0] = new JButton("       +       ");
		arrButtArZn[1] = new JButton("       -       ");
		arrButtArZn[2] = new JButton("       *       ");
		arrButtArZn[3] = new JButton("       /       ");
	}

	static JButton[] arrButtMC = new JButton[4];
	{
		arrButtMC[0] = new JButton("M+");
		arrButtMC[1] = new JButton("MR");
		arrButtMC[2] = new JButton("MC");
		arrButtMC[3] = new JButton("MS");
	}

	static JButton[] arrButtBS = new JButton[4];
	{
		arrButtBS[0] = new JButton("BS");
		arrButtBS[1] = new JButton("CE");
		arrButtBS[2] = new JButton("C");
		arrButtBS[3] = new JButton("sqrt");
	}

	Font font = new Font("Arial", Font.BOLD, 15);
	Font font1 = new Font("Arial", Font.BOLD, 20);
	Font font3 = new Font("Arial", Font.BOLD, 30);

	static JPanel mainPanel = new JPanel(new BorderLayout(5, 5));

	public GUI_Calculator(String title) throws HeadlessException {
		super(title);

		setLocation(300, 300);
		setSize(370, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		// _____________________________________________________________________________

		setContentPane(mainPanel);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		txtField.setHorizontalAlignment(JTextField.RIGHT);
		txtField.setCaretColor(Color.blue);
		txtField.setFont(font3);
		txtField.setText("0");
		mainPanel.add(txtField, BorderLayout.CENTER);
		// --------------------------------------------------------------------------
		JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));

		JPanel allSpecialPanel = new JPanel(new BorderLayout(5, 5));
		bottomPanel.add(allSpecialPanel, BorderLayout.NORTH);

		JPanel specialVertical = new JPanel();//
		specialVertical.setLayout(new BoxLayout(specialVertical,
				BoxLayout.Y_AXIS));
		allSpecialPanel.add(specialVertical, BorderLayout.CENTER);
		buttEqually.setFont(font1);
		JPanel forButtPanel = new JPanel(new BorderLayout(50, 50));//

		forButtPanel.add(buttEqually, BorderLayout.CENTER);
		allSpecialPanel.add(forButtPanel, BorderLayout.EAST);

		JPanel specialMC = new JPanel(new GridLayout(1, 4, 5, 5));

		for (int i = 0; i < arrButtMC.length; i++) {

			arrButtMC[i].setFont(font);
			arrButtMC[i].setForeground(Color.BLUE);
			specialMC.add(arrButtMC[i]);

		}// for

		specialVertical.add(specialMC);

		JPanel specialBS = new JPanel(new GridLayout(1, 4, 5, 5));
		specialBS.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

		for (int i = 0; i < arrButtBS.length; i++) {

			arrButtBS[i].setFont(font);
			arrButtBS[i].setForeground(Color.BLUE);
			specialBS.add(arrButtBS[i]);
		}// for

		specialVertical.add(specialBS);

		// --------------------------------------------------------------------------
		JPanel digArZnpanel = new JPanel(new BorderLayout(5, 5));
		bottomPanel.add(digArZnpanel, BorderLayout.SOUTH);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);

		// -----------------------------------------------------------
		JPanel dig2 = new JPanel();
		dig2.setLayout(new BoxLayout(dig2, BoxLayout.Y_AXIS));
		dig2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));

		JPanel digits = new JPanel(new GridLayout(3, 3, 5, 5));
		digits.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		for (int i = 0; i < arrDigitsButt.length; i++) {
			if (i < 9) {
				arrDigitsButt[i] = new JButton("  " + String.valueOf(i + 1)
						+ "  ");
			}

			arrDigitsButt[i].setFont(font1);
			arrDigitsButt[i].setForeground(Color.BLUE);
			digits.add(arrDigitsButt[i]);
		}// for

		JPanel p1 = new JPanel(new BorderLayout(5, 0));
		buttZero.setFont(font1);
		buttZero.setForeground(Color.BLUE);
		buttComa.setFont(font1);
		buttComa.setForeground(Color.BLUE);

		p1.add(buttZero, BorderLayout.CENTER);
		p1.add(buttComa, BorderLayout.EAST);

		p1.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

		dig2.add(digits);
		dig2.add(p1);

		digArZnpanel.add(dig2, BorderLayout.WEST);

		// ________________________________________________

		JPanel arifmPanel = new JPanel(new GridLayout(4, 0, 0, 5));

		for (int i = 0; i < arrButtArZn.length; i++) {

			arrButtArZn[i].setFont(font1);
			arrButtArZn[i].setForeground(Color.black);
			arifmPanel.add(arrButtArZn[i]);

		}// for

		digArZnpanel.add(arifmPanel, BorderLayout.EAST);

		// ������ objProcess ������� � �����, ����� �����, ����� �� ��� ����� �����
 		objProcess = new GUI_CalculatorProcessing();

		for (int i = 0; i < arrDigitsButt.length; i++) {// addActionListener

			arrDigitsButt[i].addActionListener(objProcess);

		}// for

		buttZero.addActionListener(objProcess);// addActionListener "0"
		buttComa.addActionListener(objProcess);// addActionListener ","

		for (int i = 0; i < arrButtArZn.length; i++) {

			arrButtArZn[i].addActionListener(objProcess);

		}// for

		buttEqually.addActionListener(objProcess);

		for (int i = 0; i < arrButtBS.length; i++) {

			arrButtBS[i].addActionListener(objProcess);

		}// for

		for (int i = 0; i < arrButtMC.length; i++) {

			arrButtMC[i].addActionListener(objProcess);

		}// for

		// ��������� ��������� �� ���������
		txtField.setEditable(false);
		txtField.setBackground(Color.white);

		// --------------------------------------------------------------------------
		// ��� ����������� ����������� �����
		
		// 1.����������� keyListener
		// 2.��������� setFocusable(true)

		metodAddListenerSetFocusableTrueToComponent(mainPanel);
		metodAddListenerSetFocusableTrueToComponent(txtField);
		metodAddListenerSetFocusableTrueToComponent(buttZero);
		metodAddListenerSetFocusableTrueToComponent(buttComa);
		metodAddListenerSetFocusableTrueToComponent(buttEqually);

		for (int i = 0; i < arrDigitsButt.length; i++) {
			metodAddListenerSetFocusableTrueToComponent(arrDigitsButt[i]);
		}

		for (int i = 0; i < arrButtArZn.length; i++) {
			metodAddListenerSetFocusableTrueToComponent(arrButtArZn[i]);
		}

		for (int i = 0; i < arrButtMC.length; i++) {
			metodAddListenerSetFocusableTrueToComponent(arrButtMC[i]);
		}

		for (int i = 0; i < arrButtBS.length; i++) {
			metodAddListenerSetFocusableTrueToComponent(arrButtBS[i]);
		}

		// --------------------------------------------------------------------------
		setVisible(true);

	}// constructor

	//����� ���������� KeyListener+
	// setFocusable(true)
	static public void metodAddListenerSetFocusableTrueToComponent(
			JComponent componenta) {

		componenta.addKeyListener(objProcess);
		componenta.setFocusable(true);

	}// metodAddListenerSetFocusableTrueToComponent

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {

		new GUI_Calculator("My Calculator");

	}// main

}// class
