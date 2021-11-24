package com.gmail.kutepov89.sergey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class RepetitionRate {
	private char symbol;
	private long num;
	private ArrayList<RepetitionRate> symbolArr = new ArrayList<RepetitionRate>();

	public RepetitionRate() {
		super();
	}

	public RepetitionRate(char symbol, long num) {
		super();
		this.symbol = symbol;
		this.num = num;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String readTextFromFile() {
		try (BufferedReader f = new BufferedReader(new FileReader("english_text.txt"))) {
			String str = "";
			String res = "";
			for (; (str = f.readLine()) != null;)
				res += str + " ";
			return res;
		} catch (IOException e) {
			return "ERROR";
		}
	}

	public ArrayList<RepetitionRate> arSymblols() {
		int counts[] = new int[26];
		String s = readTextFromFile().toLowerCase();
		int start = 97;
		
		for (int i = 0; i < s.length(); i++) {
			try {
				int val = (int) (s.charAt(i)) - 97;
				counts[val]++;
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		for (int i = 0; i < counts.length; i++) {
			symbolArr.add(new RepetitionRate((char) start, counts[i]));
			start += 1;
		}

		return symbolArr;
	}

	@Override
	public String toString() {
		Collections.sort(arSymblols(), new SymbolNumComparator());

		StringBuilder stringBuilder = new StringBuilder();

		for (RepetitionRate sym : symbolArr) {
			if (sym != null) {
				stringBuilder.append(sym.getSymbol() + " - " + sym.getNum()).append("\n");
			}
		}
		return stringBuilder.toString();
	}

}
