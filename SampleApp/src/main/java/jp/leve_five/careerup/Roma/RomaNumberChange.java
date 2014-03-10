package jp.leve_five.careerup.Roma;

import java.util.regex.Pattern;

public class RomaNumberChange {

	public String replaceArabicRoman(int Number) {
		ReplaceArabicToRoman replaceArabicRoman = new ReplaceArabicToRoman();
		return replaceArabicRoman.changeNumberToRoman(Number);
	}

	public int arabic(String romaString) {
		boolean romaTrue = false;
		char[] inputChar = romaString.toLowerCase().toCharArray();
		int minNumber = 0;
		int currentNumber = 0;
		int result = 0;
		int trueAdd = 0;
		int count = 0;
		for (int i = inputChar.length - 1; i >= 0; i--) {
			// ���Ă͂܂郍�[�}����������΁A�l������B
			currentNumber = changeNumber(inputChar, i);
			count++;
			System.out.println(count);
			if (i != inputChar.length - 1
					&& minNumber > currentNumber
					&& !(currentNumber == minNumber
							|| currentNumber * 5 == minNumber || currentNumber * 10 == minNumber)
					|| (minNumber > currentNumber && count >=  3)) {
				throw new RuntimeException("���[�}���L�@�̕��@�ł͂���܂���B");
			}
			if (count > 4) {
				throw new RuntimeException("���[�}���L�@�̕��@�ł͂���܂���B");
			}
			isEquivalentNumber(inputChar, currentNumber, i);
			// ���[�}�����̈ꕶ���Ƃ��Ĕ��肳����true���Aresult�ɉ��Z����

			if (minNumber == 5 && currentNumber == 1 || minNumber == 10
					&& currentNumber == 1 || minNumber == 50
					&& currentNumber == 10 || minNumber == 100
					&& currentNumber == 10 || minNumber == 500
					&& currentNumber == 100 || minNumber == 1000
					&& currentNumber == 100) {
				romaTrue = true;
				trueAdd += currentNumber * -1;
				if (i > 0) {
					if (currentNumber > changeNumber(inputChar, i - 1)) {
						throw new RuntimeException("��������[�}���L�@�ł��B");
					}
				}
			} else if (count == 3) {

				romaTrue = true;
				trueAdd += currentNumber;
				// ���̗v�f�������ł���΁A��O����������B
				if (i > 0) {
					if (currentNumber == changeNumber(inputChar, i - 1)) {
						throw new RuntimeException("�����������S�ȏ�g���Ă͂����܂���B");
					}
				}

			} else if ((minNumber * 5 != currentNumber || minNumber * 10 != currentNumber)
					&& currentNumber > minNumber && i != inputChar.length - 1) {
				romaTrue = true;
				trueAdd += currentNumber;
			} else {
				trueAdd += currentNumber;
				if (i == 0) {
					romaTrue = true;
				}
			}

			// �ꕶ���ɂȂ�������Z
			if (romaTrue) {
				result += trueAdd;
				count = 0;
				trueAdd = 0;
				romaTrue = false;
			}

			minNumber = currentNumber;

		}

		return result;
	}

	public void isEquivalentNumber(char[] inputChar, int currentNumber, int i) {
		if (i != 0
				&& (currentNumber == 5 || currentNumber == 50 || currentNumber == 500)) {
			for (int j = i - 1; j >= 0; j--) {
				if (currentNumber == changeNumber(inputChar, j)) {
					throw new RuntimeException("���[�}���L�@�̕��@������Ă܂��B");
				}
			}
		}
	}

	public int changeNumber(char[] inputChar, int i) {
		switch (inputChar[i]) {
		case 'i':
			return 1;
		case 'v':
			return 5;
		case 'x':
			return 10;
		case 'l':
			return 50;
		case 'c':
			return 100;
		case 'd':
			return 500;
		case 'm':
			return 1000;
		default:
			throw new RuntimeException("���[�}�����ȊO�̕���������܂��B");
		}
	}

}
