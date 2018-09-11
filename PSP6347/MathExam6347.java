package com._01BlogWork;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MathExam {
	// 加减符号
	private static String symbol;

	public static void Math() {
		File file = new File("out.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("文件创建完成");
		}
		Scanner input = new Scanner(System.in);
		System.out.print("请输入计算题的数量n:");
		String str = input.nextLine();
		char c = str.charAt(0);
		if (str == null || str.isEmpty()) {
			System.out.println("未输入内容，请重新输入！");
			System.exit(0);
		} else if (!Character.isDigit(c)) {
			System.out.println("请输入大于零的数字！");
			System.exit(0);
		} else if (str.length() >= 1) {
			int n = Integer.valueOf(str);
			if (n <= 0) {
				System.out.println("请输入大于零的数字！");
				System.exit(0);
			} else {
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

					System.out.println("(" + (m + 1) + ")" + " " + y + " "
							+ symbol + " " + z + " " + "=");
					input.close();
				}
				System.out.println("----------------------" + "标准答案 "
						+ "-----------------------");
				System.out.println(info);
			}
		}
	}

	public static void main(String[] args) {
		MathExam.Math();
		System.out.println("\t\t" + "211606347  周建峰  2018年09月09日  15:00");
	}

}
