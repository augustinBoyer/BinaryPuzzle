package main.model.factories;

import java.util.*;

public class PuzzleFactory {

	public static int numberChoice = 5;

	public static ArrayList<String> getPuzzle(int gridNumber) {
		if (gridNumber > 0 && gridNumber <= numberChoice) {
			if (gridNumber == 1)
				return PuzzleFactory.getPuzzle1();

			if (gridNumber == 2)
				return PuzzleFactory.getPuzzle2();

			if (gridNumber == 3)
				return PuzzleFactory.getPuzzle3();

			if (gridNumber == 4)
				return PuzzleFactory.getPuzzle4();
			if (gridNumber == 5)
				return PuzzleFactory.getPuzzle5();
		} else if (gridNumber == -1) {
			return PuzzleFactory.getPuzzleTest_GoodSolved();
		}
		return null;
	}

	// E1
	public static ArrayList<String> getPuzzle1() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("       0");
		rows.add(" 00  1  ");
		rows.add(" 0   1 0");
		rows.add("  1     ");
		rows.add("00 1  1 ");
		rows.add("    1   ");
		rows.add("11   0 1");
		rows.add(" 1     1");

		return rows;
	}

	// M1
	public static ArrayList<String> getPuzzle2() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("    0 0 ");
		rows.add("0 0 0 0 ");
		rows.add("        ");
		rows.add("    1 1 ");
		rows.add("0  0    ");
		rows.add("0  00   ");
		rows.add("       1");
		rows.add(" 1 1    ");

		return rows;
	}

	// M12
	public static ArrayList<String> getPuzzle3() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("1   0   ");
		rows.add("0   0   ");
		rows.add("   1    ");
		rows.add("0 0    1");
		rows.add("    1  1");
		rows.add("0       ");
		rows.add("1  1 11 ");
		rows.add("  00    ");

		return rows;
	}

	// M20
	public static ArrayList<String> getPuzzle4() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("        ");
		rows.add("1 0  11 ");
		rows.add(" 0      ");
		rows.add("    1   ");
		rows.add("  0  1 1");
		rows.add(" 01 0 01");
		rows.add("        ");
		rows.add(" 0  11  ");

		return rows;
	}

	// M40
	public static ArrayList<String> getPuzzle5() {

		ArrayList<String> rows = new ArrayList<>();

		rows.add("1       ");
		rows.add(" 0  1   ");
		rows.add("   0   1");
		rows.add("00   1 1");
		rows.add("   1    ");
		rows.add(" 0 1    ");
		rows.add("     1  ");
		rows.add(" 00   0 ");

		return rows;
	}

	public static ArrayList<String> getPuzzle6() {

		ArrayList<String> rows = new ArrayList<>();

		rows.add("01101010");
		rows.add("10010101");
		rows.add("10010110");
		rows.add("01101001");
		rows.add("00110110");
		rows.add("10011010");
		rows.add("11001001");
		rows.add("01100101");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest1() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("00101011");
		rows.add("10010011");
		rows.add("01101100");
		rows.add("00110101");
		rows.add("11001010");
		rows.add("00110101");
		rows.add("11010010");
		rows.add("11001100");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_GoodSolved() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("0101");
		rows.add("1010");
		rows.add("1100");
		rows.add("0011");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_OneZeroMore() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("0100");
		rows.add("1001");
		rows.add("0110");
		rows.add("0011");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_OneOneMore() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("1011");
		rows.add("0110");
		rows.add("1001");
		rows.add("1100");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_TwoSameRows() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("1110");
		rows.add("1110");
		rows.add("1001");
		rows.add("0011");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_TwoSameRows_AtBeginningAndAtEnd() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("1110");
		rows.add("1001");
		rows.add("0011");
		rows.add("1110");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_TwoSameColumns() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("1101");
		rows.add("0000");
		rows.add("0010");
		rows.add("0011");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_TwoSameColumns_AtBeginningAndAtEnd() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("1011");
		rows.add("0000");
		rows.add("0100");
		rows.add("0110");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_FirstSequenceZero() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("0101");
		rows.add("0100");
		rows.add("0010");
		rows.add("1011");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_LastSequenceZero() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("1011");
		rows.add("0010");
		rows.add("1100");
		rows.add("0110");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_FirstSequenceOne() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("1010");
		rows.add("1011");
		rows.add("1101");
		rows.add("0100");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_LastSequenceOne() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("0100");
		rows.add("1101");
		rows.add("0011");
		rows.add("1001");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_FirstSequenceZeroAtRow() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("0101");
		rows.add("0100");
		rows.add("0010");
		rows.add("1011");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_LastSequenceZeroAtRow() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("1011");
		rows.add("0010");
		rows.add("1100");
		rows.add("0110");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_FirstSequenceOneAtRow() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("1010");
		rows.add("1011");
		rows.add("1101");
		rows.add("0100");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_LastSequenceOneAtRow() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("0100");
		rows.add("1101");
		rows.add("0011");
		rows.add("1001");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_MiddleSequenceOneAtRow() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("1010");
		rows.add("0111");
		rows.add("1001");
		rows.add("0100");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_MiddleSequenceZeroAtRow() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("0101");
		rows.add("1000");
		rows.add("0110");
		rows.add("1011");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_MiddleSequenceZeroAtColumn() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("1010");
		rows.add("0101");
		rows.add("1001");
		rows.add("0100");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_MiddleSequenceOneAtColumn() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("0101");
		rows.add("1010");
		rows.add("0110");
		rows.add("1011");

		return rows;
	}

	public static ArrayList<String> getPuzzleTest_NothingButZeros() {
		ArrayList<String> rows = new ArrayList<>();

		rows.add("0000");
		rows.add("0000");
		rows.add("0000");
		rows.add("0000");

		return rows;
	}

}
