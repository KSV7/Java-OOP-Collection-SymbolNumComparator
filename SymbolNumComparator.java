package com.gmail.kutepov89.sergey;

import java.util.Comparator;

public class SymbolNumComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		
		RepetitionRate n1 = (RepetitionRate)o1;
		RepetitionRate n2 = (RepetitionRate)o2;
		
		long num1 = n1.getNum();
		long num2 = n2.getNum();

		if (num1 < num2) {
			return 1;
		}
		if (num1 > num2) {
			return -1;
		}
		
		return 0;
		
	}
	
}