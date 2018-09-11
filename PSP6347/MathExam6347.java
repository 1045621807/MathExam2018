package com._01BlogWork;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MathExam {
	// �Ӽ�����
	private static String symbol;

	public static void Math() {
		File file = new File("out.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("�ļ��������");
		}
		Scanner input = new Scanner(System.in);
		System.out.print("����������������n:");
		String str = input.nextLine();
		char c = str.charAt(0);
		if (str == null || str.isEmpty()) {
			System.out.println("δ�������ݣ����������룡");
			System.exit(0);
		} else if (!Character.isDigit(c)) {
			System.out.println("���������������֣�");
			System.exit(0);
		} else if (str.length() >= 1) {
			int n = Integer.valueOf(str);
			if (n <= 0) {
				System.out.println("���������������֣�");
				System.exit(0);
			} else {
				// ��¼��
				ArrayList<String> info = new ArrayList<String>();
				String answerinfo = "";
				for (int m = 0; m < n; m++) {
					int x = (int) (Math.random() * 2);
					int y = (int) (Math.random() * 101);
					int z = (int) (Math.random() * 101);
					if ((y - z) < 0) {
						x = 0;
					}
					if (x == 0) {
						symbol = "+";
						answerinfo = y + " " + "+" + " " + z + " " + "=" + " "
								+ (y + z);
						info.add("\n" + "(" + (m + 1) + ")" + " " + answerinfo);
					} else {
						symbol = "-";
						answerinfo = y + " " + "-" + " " + z + " " + "=" + " "
								+ (y - z);
						info.add("\n" + "(" + (m + 1) + ")" + " " + answerinfo);
					}

					System.out.println("(" + (m + 1) + ")" + " " + y + " "
							+ symbol + " " + z + " " + "=");
					input.close();
				}
				System.out.println("----------------------" + "��׼�� "
						+ "-----------------------");
				System.out.println(info);
			}
		}
	}

	public static void main(String[] args) {
		MathExam.Math();
		System.out.println("\t\t" + "211606347  �ܽ���  2018��09��09��  15:00");
	}

}
