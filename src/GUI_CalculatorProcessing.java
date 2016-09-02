package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;

//Class for processing of calculator

public class GUI_CalculatorProcessing extends JFrame implements ActionListener,
		KeyListener {

	static String operand1 = "0";
	static String operand2 = "0";
	static char operation = '0';// ���� �������� (���� �� �������������� ��=0)
	static String oldTField = "";// ���� � ������� ������������ ����� ������ �
	// ����� ��� ������ �����. �������� ��� =, �� � ����� ����
	// ��������� � ���� �� ���������

	static String memory = "0";

	// ������ ������� ������� ����� ����� ���������� � ����������� �����������
	static JButton[] massOfComponents = {
			// ������ c 1 �� 9 arrDigitsButt
			GUI_Calculator.arrDigitsButt[0], GUI_Calculator.arrDigitsButt[1],
			GUI_Calculator.arrDigitsButt[2], GUI_Calculator.arrDigitsButt[3],
			GUI_Calculator.arrDigitsButt[4], GUI_Calculator.arrDigitsButt[5],
			GUI_Calculator.arrDigitsButt[6], GUI_Calculator.arrDigitsButt[7],
			GUI_Calculator.arrDigitsButt[8], GUI_Calculator.buttZero,// ����
			GUI_Calculator.buttComa,// �������
			GUI_Calculator.arrButtArZn[0],// +
			GUI_Calculator.arrButtArZn[1],// -
			GUI_Calculator.arrButtArZn[2],// *
			GUI_Calculator.arrButtArZn[3],// (/)
			GUI_Calculator.buttEqually, // 15-� ������ "="
			GUI_Calculator.arrButtBS[0],// "BS"- 16-� ������
			GUI_Calculator.arrButtBS[1],// "CE"- 17-� ������
			GUI_Calculator.arrButtBS[2],// "C"- 18-� ������
			GUI_Calculator.arrButtBS[3],// ������ ��.- 19-� ������
			GUI_Calculator.arrButtMC[0],// 20 - ������, "M+"
			GUI_Calculator.arrButtMC[1],// 21 - ������, "MR"
			GUI_Calculator.arrButtMC[2],// 22 - ������, "MC"
			GUI_Calculator.arrButtMC[3],// 23 - ������, "MS"

	};

	public static void metodDoArifmZnakiWork(JButton componenta) {

		// ����� ������ ����� �������� ������ ����� �� ������� �
		// ������� 1
		operand1 = GUI_Calculator.txtField.getText();
		// �������� ������� ���� oldTField
		oldTField = "";

		// ������� � ���� �������� ��������� ��������
		operation = componenta.getText().trim().charAt(0);

		// ���������� ���������� �������� �������� � ���������
		GUI_Calculator.txtField.setText(String.valueOf(componenta.getText()
				.trim()));

		// System.out.println("operation = " + operation);

	}// metodArifmZnakiWork

	public static void metodDoEquallyWork() {

		// System.out.println("��� ������ �����");
		// System.out.println("operand1 = " + operand1);
		// System.out.println("operand2 = " + operand2);

		// ���� ��� �������� ������
		if (((operand1 == "") && (operand2 == ""))
				|| ((operand1 == "0") && (operand2 == "0"))) {
			// ������ �� ������

		}// if ( (operand1 == "") && (operand2 == "") )

		// �� ������ ���������� ��������� ����� ����� �����
		// � ����� ���� ��� �������� �����
		else if ((operand1.equalsIgnoreCase("+"))
				|| (operand1.equalsIgnoreCase("-"))
				|| (operand1.equalsIgnoreCase("*"))
				|| (operand1.equalsIgnoreCase("/"))) {
			// System.out.println("������� 1 ���� ����� "+operand1);
			// System.out.println("operand1 = "+operand1);
			// System.out.println("operand2 = "+operand2);
			operand1 = "0";

		}

		else {

			// ----------------------------------------------------------------------
			// ���� ������ �����, �� �� ����� �������2 ��� � �� ��������
			// ��������: �������� ������ �������
			// ����� ����� "+"
			// � ����� ������ "="
			// ��� ������� � ������� �������� 2

			// �������� �� ������ ���� �������2 ������
			// �.�. ��� ������ ������ ������� , ����� ������ , ��������, "+"
			// � ����� ����� �� ������ ������ �������, � ������ �����
			// �����(=)
			if (operand2 == "") {// ���� ������2 ������, ��
				operand2 = operand1;// ��������� ��� ������� 1
			}
			// -------------------------------------------------------------------

			String tempResult = "";// ��������� ��������� ��������

			// �������� �� ������, ���� �� ������� �����(=) ��� � �� ����
			// ������ �������
			// ��������

			if (operation == '0') {
				tempResult = oldTField;// ����� ������� ������ ���������

			}// if (operation == '0')

			// -------------------------------------------------------------
			// ����� ���������� �������� � �������� �� Ũ ������:
			if (operation == '+') {// ���� ���� ������� �������� "+"
				tempResult = String.valueOf(Double.valueOf(operand1)
						+ Double.valueOf(operand2));

			}// if (operation == '+')

			if (operation == '-') {// ���� ���� ������� �������� "-"
				tempResult = String.valueOf(Double.valueOf(operand1)
						- Double.valueOf(operand2));

			}// if (operation == '-')

			if (operation == '*') {// ���� ���� ������� �������� " * "
									// �������� ���������
				tempResult = String.valueOf(Double.valueOf(operand1)
						* Double.valueOf(operand2));

			}// if (operation == '*') - �������� ���������

			if (operation == '/') {// ���� ���� ������� �������� "( / )" -
									// �������� �������
				tempResult = String.valueOf(Double.valueOf(operand1)
						/ Double.valueOf(operand2));

			}// if (operation == '/') - �������� �������

			// -----------------------------------------------------------------------------
			// ������������� ��������:
			// ����� �� �������� � ���������� "������ ���� ����� �������"
			if (tempResult.matches("([0-9]+.[0]+)")) {//
				// ("([0-9]+.[0]+)")-������= ����� ����� ����� ��� � ������
				// ���� ����� ���
				// System.out.println("����� ������� ���� ����");

				// �������� �� �� �������
				tempResult = tempResult.substring(0, tempResult.indexOf("."));

			}// if (tempResult.matches("([0-9]+.[0]+)"))
				// ------------------------------------------------------------------------------------

			// ��������� ������� � ���������
			GUI_Calculator.txtField.setText(tempResult);
			// ��������� ������� � �������1
			operand1 = GUI_Calculator.txtField.getText();
			// �������� ������� ����
			oldTField = "";

		}// else ( (operand1 == "") && (operand2 == "") )

	}// metodEquallyWork()

	public static void metodDoComaWork() {

		// ���� ������� ��� ���� �� ������ ������ �� ����
		// � ���� ���������� ���� �����
		if (oldTField.indexOf(".") != -1) {

		}// if (oldTField.indexOf(".")!=-1)

		else {

			if (oldTField == "") {// ���� ���� ������ �� ����
									// �������� "0"
				oldTField = oldTField + "0.";
			}// if (oldTField=="")

			else {// ���� ���� �������� �� �� ���� ��������� "0"
				oldTField = oldTField + ".";
			}// else
		}// else (if (oldTField.indexOf(".") != -1))

		// ���� � ���� ���� ���� - �� ������� ���� ����
		if (oldTField.matches("([0]+)")) {// ���� ���� ����
			// ������ ������
			oldTField = "0";
			// System.out.println("����� ����� � ������" + oldTField);
		}// if (oldTField.matches("([0]+)"))
			// --------------------------------------------------------------

		// ���� � ���� ���� ����� ����� ������- �� ��� ����������� ���
		// ���� �������

		if (oldTField.matches("([0]{1}[1-9]+)")) {// ���� ���� �����
													// ������
			// ������ ������ ����, ������� ������� ����
			oldTField = oldTField.substring(1);

			// System.out.println("����� ����� ���� �������" +
			// oldTField);
		}// if (oldTField.matches("([0]{1}[1-9]+)"))
			// -----------------------------------------------------------------------

		// �������� � ���� �������� ������� ������
		GUI_Calculator.txtField.setText(oldTField);

		// �������� ������ �������� �� ������� ����� �� ������ ����
		if (operation != '0') {// ���� �� ������� �� ������ ���� �������
								// ����� �� �� ��������
			// �� ������� �� �������� ���� � �������2
			operand2 = oldTField;
		}// if (operation!='0')

		// System.out.println("operand1 � ���� ������= " + operand1);
		// System.out.println("operand2 � ���� ������= " + operand2);

	}// metodComaWork()

	public static void metodDoDigitsWork(JButton componenta) {

		oldTField = oldTField + componenta.getText().trim();
		// ���� � ���� ���� ���� - �� ������� ���� ����
		if (oldTField.matches("([0]+)")) {// ���� ���� ����
			// ������ ������
			oldTField = "0";
			// System.out.println("����� ����� � ������" + oldTField);
		}// if (oldTField.matches("([0]+)"))
			// --------------------------------------------------------------

		// ���� � ���� ���� ����� ����� ������- �� ��� ����������� ���
		// ���� �������

		if (oldTField.matches("([0]{1}[1-9]+)")) {// ���� ���� �����
													// ������
			// ������ ������ ����, ������� ������� ����
			oldTField = oldTField.substring(1);

			// System.out.println("����� ����� ���� �������" +
			// oldTField);
		}// if (oldTField.matches("([0]{1}[1-9]+)"))
			// -----------------------------------------------------------------------

		// �������� � ���� �������� ������� ������
		GUI_Calculator.txtField.setText(oldTField);

		// �������� ������ �������� �� ������� ����� �� ������ ����
		if (operation != '0') {// ���� �� ������� �� ������ ���� �������
								// ����� �� �� ��������
			// �� ������� �� �������� ���� � �������2
			operand2 = oldTField;
		}// if (operation!='0')

		// System.out.println("operand1 � ���� ������= " + operand1);
		// System.out.println("operand2 � ���� ������= " + operand2);

	}// metodDigitsWork

	public static void metodDoButtCwork() {

		// ���� ���� ������ �,�� �������� ��� ��������
		// � ������� � ��������� "0"

		operand1 = "0";
		operand2 = "0";
		GUI_Calculator.txtField.setText("0");
		oldTField = "0";
	}// metodDoButtCwork()

	public static void metodDoButtCEwork() {

		// ���� ���� ������ �E,�� �������� �����
		// � �������� oldTField="0"
		// �.�. ����� ������� ����� ������ ��� �
		// ����� ����� ������� 2
		GUI_Calculator.txtField.setText("0");
		oldTField = "0";

	}// metodDoButtCEwork()

	public static void metodDoButtBSwork() {

		String temp = GUI_Calculator.txtField.getText();

		// ���� ������ ���� ����� � ������, �� ���������� "0"
		if ((temp.length() == 1)) {

			// System.out.println("����� ����� ������");
			GUI_Calculator.txtField.setText("0");

		}// if ((temp.length()==1) ) {

		else {// ���� ���, �� �������� �� ���� �����

			temp = temp.substring(0, temp.length() - 1);
			// System.out.println("temp=" + temp);
			GUI_Calculator.txtField.setText(temp);

		}// else

	}// metodDoButtBSwork()

	public static void metodDoButtSQRTwork() {

		// ���� � ������ � ����� ����� ����
		if ((GUI_Calculator.txtField.getText().equalsIgnoreCase("+"))
				|| (GUI_Calculator.txtField.getText().equalsIgnoreCase("-"))
				|| (GUI_Calculator.txtField.getText().equalsIgnoreCase("*"))
				|| (GUI_Calculator.txtField.getText().equalsIgnoreCase("/"))) {
			GUI_Calculator.txtField.setText("������ �����");

		}// if

		else {
			// �������� � ���� �������� ������
			Double tempDouble = Double.valueOf(GUI_Calculator.txtField
					.getText());
			tempDouble = Math.sqrt(tempDouble);// ������ �����
			String tempStr = String.valueOf(tempDouble);

			// ����� �� �������� � ���������� "������ ���� ����� �������"
			if (tempStr.matches("([0-9]+.[0]+)")) {//
				// ("([0-9]+.[0]+)")-������= ����� ����� ����� ���
				// � ������ ���� ����� ���

				// �������� �� �� �������
				tempStr = tempStr.substring(0, tempStr.indexOf("."));

			}// if (tempResult.matches("([0-9]+.[0]+)"))

			// ����������� � ����� ���������� ��������
			GUI_Calculator.txtField.setText(tempStr);
			oldTField = "0";
		}// else

	}// metodDoButtSQRTwork()

	public static void metodDoButtMCwork() {

		memory = "0";

	}// metodDoButtMCwork()

	public static void metodDoButtM_PLUS_work() {
		Double tempDouble = Double.valueOf(GUI_Calculator.txtField.getText());

		memory = String.valueOf(Double.valueOf(memory) + tempDouble);
		oldTField = "0";
	}// metodDoButtMCwork()

	public static void metodDoButtMRwork() {
		// ����� �� �������� � ���������� "������ ���� ����� �������"

		if (memory.matches("([0-9]+.[0]+)")) {//
			// ("([0-9]+.[0]+)")-������= ����� ����� ����� ���
			// � ������ ���� ����� ���

			// �������� �� �� �������
			memory = memory.substring(0, memory.indexOf("."));

		}// if (tempResult.matches("([0-9]+.[0]+)"))

		GUI_Calculator.txtField.setText(memory);
		oldTField = "0";
	}// metodDoButtMRwork()

	public static void metodDoButtMSwork() {
		// ��������� � ������ ����� � ������
		memory = GUI_Calculator.txtField.getText();
		// � ����� ���������� ����� ����� 0
		GUI_Calculator.txtField.setText("0");
		// �������������� ��� � ������ �������
		oldTField = "0";

	}// metodDoButtMCwork()

	public static void main(String[] args) {

	}// main

	// __���������________________________________________________

	// ����� ActionListener()
	@Override
	public void actionPerformed(ActionEvent event) {
		// System.out.println("event.getModifiers()= " + event.getModifiers());

		// ���� ���� ������ ����� ������� CTRL+�����
		if ((event.getModifiers() == 18)) {
			for (int i = 0; i < 10; i++) {
				// ��� ��������� ���� ������ � CTRL
				if ((event.getSource() == massOfComponents[i]) && (i < 10)
						&& (event.getModifiers() == 18)) {
					// System.out.println("��� ������ �������� ������ + CTRL");

					// -----------------------------------------------------
					// ��������� ������ � ���� �� ������
					// (0-9)--------------------------------------------
					// ������ ���������� ���� ����� � ����� ����������()
					metodDoDigitsWork(massOfComponents[i]);
					metodDoEquallyWork();
					break;
				}// if ((event.getSource()==massOfComponents[i])&&(i<11))
			}// for
		}// if ((event.getModifiers()==18)) {

		else {// ���� �� ���� ����� �������, �� ������� ���������

			// ��� ���������� ������� - ������� �� ������
			// ����������� ����, � ������� ����������� ����� ���� ������ ������
			for (int i = 0; i < massOfComponents.length; i++) {

				if ((event.getSource() == massOfComponents[i]) && (i < 11)) {
					// System.out.println("��� ������ �������� ������");

					// ��������� ��������� ������� "," ����� ��� ������� ","
					// ��������� "0,"--------------
					if (i == 10) {

						metodDoComaWork();

					}// if (i==10) {

					// --------------------------------------------------------------------------------------
					// ��������� ������ � ���� �� ������
					// (0-9)--------------------------------------------
					if (i != 10) {// ��� ���� ��������� ������ ������ ���������

						metodDoDigitsWork(massOfComponents[i]);

					}// if (i!=10)

					break;

				}// if ((event.getSource()==massOfComponents[i])&&(i<11))

				// --------------------------------------------------------------------------------------
				// ������������� ������: + - * /
				if ((event.getSource() == massOfComponents[i]) && (i > 10)
						&& (i < 15)) {// ���

					metodDoArifmZnakiWork(massOfComponents[i]);
					break;// ����������� ����

				}// if ((event.getSource()==massOfComponents[i])&&(i>10))

				// -------------------------------------------------------------------------

				// ���� ������ ������ �����
				if ((event.getSource() == GUI_Calculator.buttEqually)) {

					metodDoEquallyWork();
					break;

				}// if

				// ������ ������ BS -backspace
				if ((event.getSource() == GUI_Calculator.arrButtBS[0])) {

					metodDoButtBSwork();
					break;

				}// if

				// ������ ������ CE - ������� ����������� ������
				if ((event.getSource() == GUI_Calculator.arrButtBS[1])) {

					metodDoButtCEwork();
					break;

				}// if

				// ���� ������ ������ "�" - �������� ���� ���������
				if ((event.getSource() == GUI_Calculator.arrButtBS[2])) {

					metodDoButtCwork();
					break;

				}// if

				if ((event.getSource() == GUI_Calculator.arrButtBS[3])) {

					metodDoButtSQRTwork();
					break;

				}// if

				// ���� ������ MC-��� delete(������� ������)
				if ((event.getSource() == GUI_Calculator.arrButtMC[2])) {

					metodDoButtMCwork();
					break;

				}// if

				// ���� ������ M+ ��������� � ����� � ������
				if ((event.getSource() == GUI_Calculator.arrButtMC[0])) {

					metodDoButtM_PLUS_work();
					break;

				}// if

				// ���� ������ MR - ������� �� ������ (�� �����) = Insert
				if ((event.getSource() == GUI_Calculator.arrButtMC[1])) {

					metodDoButtMRwork();
					break;

				}// if

				// ���� ������ MS - c�������� � ������ � ������ = Pause
				if ((event.getSource() == GUI_Calculator.arrButtMC[3])) {

					metodDoButtMSwork();
					break;

				}// if

			}// for (int i = 0; i < massOfComponents.length; i++)

		}// else

	}// public void actionPerformed(ActionEvent event) {

	// ��������� ������� KeyListener()-------------------------
	@Override
	public void keyPressed(KeyEvent event) {

		// System.out.println("event.getKeyChar() = " + event.getKeyChar());

		if ((event.getModifiersExText(event.getModifiersEx())
				.equalsIgnoreCase("Ctrl"))
				&& ((event.getKeyChar() == '0') || (event.getKeyChar() == '1')
						|| (event.getKeyChar() == '2')
						|| (event.getKeyChar() == '3')
						|| (event.getKeyChar() == '4')
						|| (event.getKeyChar() == '5')
						|| (event.getKeyChar() == '6')
						|| (event.getKeyChar() == '7')
						|| (event.getKeyChar() == '8') || (event.getKeyChar() == '9'))) {

			// System.out.println("������ ������� +" + event.getKeyChar());

			switch (event.getKeyChar()) {// ������������ �� ����������� �������
											// ��
			// �����
			case '0':
				metodDoDigitsWork(GUI_Calculator.buttZero);

				// ����� ���������� �� ������, ��������������� ������� 0 - �.�.
				// buttZero
				GUI_Calculator.buttZero.requestFocus(); // ��������� ������ ��
				// ����������, ���� �����
				// �������� ������ ����� ��������� ���������� �� ������
				break;

			case '1':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[0]);
				GUI_Calculator.arrDigitsButt[0].requestFocus();
				break;
			case '2':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[1]);
				GUI_Calculator.arrDigitsButt[1].requestFocus();
				break;
			case '3':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[2]);
				GUI_Calculator.arrDigitsButt[2].requestFocus();
				break;
			case '4':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[3]);
				GUI_Calculator.arrDigitsButt[3].requestFocus();
				break;
			case '5':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[4]);
				GUI_Calculator.arrDigitsButt[4].requestFocus();
				break;
			case '6':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[5]);
				GUI_Calculator.arrDigitsButt[5].requestFocus();
				break;
			case '7':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[6]);
				GUI_Calculator.arrDigitsButt[6].requestFocus();
				break;
			case '8':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[7]);
				GUI_Calculator.arrDigitsButt[7].requestFocus();
				break;
			case '9':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[8]);
				GUI_Calculator.arrDigitsButt[8].requestFocus();
				break;

			} // switch

			metodDoEquallyWork();
			// ������� ������ ����� ��� ������� �������
		} else {

			// ������ ������������� switch case
			// ������� � 7� ������ ����� � �����-��������� ����� ������������
			// ������
			switch (event.getKeyChar()) {// ������������ �� ����������� �������
											// ��
											// �����
			case '0':
				metodDoDigitsWork(GUI_Calculator.buttZero);

				// ����� ���������� �� ������, ��������������� ������� 0 - �.�.
				// buttZero
				GUI_Calculator.buttZero.requestFocus(); // ��������� ������ ��
				// ����������, ���� �����
				// �������� ������ ����� ��������� ���������� �� ������
				break;

			case '1':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[0]);
				GUI_Calculator.arrDigitsButt[0].requestFocus();
				break;
			case '2':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[1]);
				GUI_Calculator.arrDigitsButt[1].requestFocus();
				break;
			case '3':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[2]);
				GUI_Calculator.arrDigitsButt[2].requestFocus();
				break;
			case '4':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[3]);
				GUI_Calculator.arrDigitsButt[3].requestFocus();
				break;
			case '5':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[4]);
				GUI_Calculator.arrDigitsButt[4].requestFocus();
				break;
			case '6':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[5]);
				GUI_Calculator.arrDigitsButt[5].requestFocus();
				break;
			case '7':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[6]);
				GUI_Calculator.arrDigitsButt[6].requestFocus();
				break;
			case '8':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[7]);
				GUI_Calculator.arrDigitsButt[7].requestFocus();
				break;
			case '9':
				metodDoDigitsWork(GUI_Calculator.arrDigitsButt[8]);
				GUI_Calculator.arrDigitsButt[8].requestFocus();
				break;

			case ',':
				metodDoComaWork();
				GUI_Calculator.buttComa.requestFocus();
				break;

			case '.':
				metodDoComaWork();
				GUI_Calculator.buttComa.requestFocus();
				break;

			case '+':
				metodDoArifmZnakiWork(GUI_Calculator.arrButtArZn[0]);
				GUI_Calculator.arrButtArZn[0].requestFocus();
				break;

			case '-':
				metodDoArifmZnakiWork(GUI_Calculator.arrButtArZn[1]);
				GUI_Calculator.arrButtArZn[1].requestFocus();
				break;

			case '*':
				metodDoArifmZnakiWork(GUI_Calculator.arrButtArZn[2]);
				GUI_Calculator.arrButtArZn[2].requestFocus();
				break;

			case '/':
				metodDoArifmZnakiWork(GUI_Calculator.arrButtArZn[3]);
				GUI_Calculator.arrButtArZn[3].requestFocus();
				break;

			case '=':
				metodDoEquallyWork();
				GUI_Calculator.buttEqually.requestFocus();
				break;

			} // switch

		}// else

		// ���� ������ Backspace
		if (event.getKeyText(event.getExtendedKeyCode()).equals("Backspace")) {

			metodDoButtBSwork();
			GUI_Calculator.arrButtBS[0].requestFocus();

		}// if

		// ���� ������ Delete
		if (event.getKeyText(event.getExtendedKeyCode()).equals("Delete")) {

			metodDoButtMCwork();
			GUI_Calculator.arrButtMC[2].requestFocus();

		}// if

		// ���� ������ - Pg Up ( M+)
		if (event.getKeyText(event.getExtendedKeyCode()).equals("Page Up")) {

			metodDoButtM_PLUS_work();
			GUI_Calculator.arrButtMC[0].requestFocus();

		}// if

		// ���� ������ - Insert ( MR )
		if (event.getKeyText(event.getExtendedKeyCode()).equals("Insert")) {

			metodDoButtMRwork();
			GUI_Calculator.arrButtMC[1].requestFocus();

		}// if

		// ���� ������ - "Pause" ( MS )
		if (event.getKeyText(event.getExtendedKeyCode()).equals("Pause")) {

			metodDoButtMSwork();
			GUI_Calculator.arrButtMC[3].requestFocus();

		}// if
		
		// ���� ������ - "Ctrl + C" ( CE )
		if ((event.getModifiers() & event.CTRL_MASK) != 0
				&& (event.getKeyCode() == event.VK_C)) {

			metodDoButtCEwork();
			GUI_Calculator.arrButtBS[1].requestFocus();

		}// if
		
		// ���� ������ - "Ctrl + "+" " ( M+ )
		if ((event.getModifiers() & event.CTRL_MASK) != 0
				&& (event.getKeyCode() == event.VK_PLUS)) {

			metodDoButtM_PLUS_work();
			GUI_Calculator.arrButtMC[0].requestFocus();

		}// if

	}// public void keyPressed(KeyEvent event) {

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}// class
