package jp.leve_five.careerup.Roma;

public class RomaNumberChange {
	//�����������ł���΁A���[�}������Ԃ��B
	public String convertRomanNumber(int inputNumber) {
		ReplaceArabicToRoman replaceArabicRoman = new ReplaceArabicToRoman();
		return replaceArabicRoman.convertNumberToRoman(inputNumber);
	}
	//�����������ł���΁A�A���r�A������Ԃ��B
	public int convertRomanNumber(String inputRoman) {
		ReplaceRomanToArabic replaceRomanArabic = new ReplaceRomanToArabic();
		return replaceRomanArabic.convertRomanToNumber(inputRoman);
	}


}
