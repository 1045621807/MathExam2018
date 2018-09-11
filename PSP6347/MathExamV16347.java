package com._01BlogWork;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MathExamV1 {
	private static String symbol;

	public static void main(String[] args) throws Throwable {
		File file = new File("out.txt");
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("文件创建完成");
		}

		int n, i = 1, grade;
		Scanner input = new Scanner(System.in);
		System.out.print("请输入计算题的数量n:");
		String str1 = input.next();
		char v1 = str1.charAt(0);
		if (str1 == null || str1.isEmpty() || !Character.isDigit(v1)) {
			System.out.println("请输入正确的数量n！");
			System.exit(0);
		}
		n = Integer.valueOf(str1);

		System.out.print("请输入年级(1或2):");
		String str2 = input.next();
		char v2 = str2.charAt(0);
		if (str2 == null || str2.isEmpty() || !Character.isDigit(v2)
				|| (Integer.valueOf(str2) < 1 || Integer.valueOf(str2) > 2)) {
			System.out.println("请输入正确的年级！");
			System.exit(0);
		}
		grade = Integer.valueOf(str2);

		String[] a1 = new String[n + 1];
		@SuppressWarnings("unused")
		String[] b1 = new String[n + 1];
		String[] c1 = new String[n + 1];
		StringBuffer q1 = null;
		StringBuffer r1 = null;
		@SuppressWarnings("resource")
		FileOutputStream in = new FileOutputStream(file);

		if (grade == 1) {
			// 记录答案
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

				System.out.println("(" + (m + 1) + ")" + " " + y + " " + symbol
						+ " " + z + " " + "=");
				input.close();
			}
			System.out.println("----------------------" + "标准答案 "
					+ "-----------------------");
			System.out.println(info);
		} else {
			for (i = 0; i < n; i++) {
				int a = (int) (Math.random() * 10 + 1);
				int b = (int) (Math.random() * 10 + 1);
				int c = (int) (Math.random() * 2);
				if (c % 2 == 0) {
					System.out.println("(" + (i + 1) + ")" + " " + a + " "
							+ "x" + " " + b + " " + "=");
					q1 = new StringBuffer("(" + (i + 1) + ")" + " " + a + " "
							+ "x" + " " + b + " " + "=");
					r1 = new StringBuffer(" " + (a * b));
					a1[i] = ("(" + (i + 1) + ")" + " " + a + " " + "x" + " "
							+ b + " " + "=");
					q1.append(r1);
					c1[i] = q1.toString();
				} else {
					if (a == b) {
						System.out.println("(" + (i + 1) + ")" + " " + a + " "
								+ "÷" + " " + b + " " + "=");
						q1 = new StringBuffer("(" + (i + 1) + ")" + " " + a
								+ " " + "÷" + " " + b + " " + "=");
						r1 = new StringBuffer(" " + (a / b));
						a1[i] = ("(" + (i + 1) + ")" + " " + a + " " + "÷"
								+ " " + b + " " + "=");
						q1.append(r1);
						c1[i] = q1.toString();

					} else {
						System.out.println("(" + (i + 1) + ")" + " " + a + " "
								+ "÷" + " " + b + " " + "=");
						q1 = new StringBuffer("(" + (i + 1) + ")" + " " + a
								+ " " + "÷" + " " + b + " " + "=");
						r1 = new StringBuffer(" " + (a / b) + " " + "..." + " "
								+ a % b);
						a1[i] = ("(" + (i + 1) + ")" + " " + a + " " + "÷"
								+ " " + b + " " + "=");
						q1.append(r1);
						c1[i] = q1.toString();
					}

				}

				byte[] ba = a1[i].getBytes();
				String ka = "\n\r";
				byte[] ra = ka.getBytes();

				in.write(ba);
				in.write(ra);
			}
			String daan = "----------------------" + "标准答案 "
					+ "-----------------------";
			byte[] pm = daan.getBytes();
			String km = "\n\r";
			byte[] rm = km.getBytes();
			in.write(pm);
			in.write(rm);

			System.out.println("----------------------" + "标准答案 "
					+ "-----------------------");
			for (i = 0; i < n; i++) {
				System.out.println(c1[i]);
				byte[] tm = c1[i].getBytes();
				in.write(tm);
				in.write(rm);

			}
		}

	}
}
