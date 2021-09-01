package com.algo.practice;
public class FamilySeatAllocation {
	public static void main(String[] args) {
		int N = 2;
		String S = "1A 2F 1C";
		System.out.println(solution2(N, S));

		int N2 = 1;
		String S2 = "";
		System.out.println(solution2(N2, S2));
	}
	
	public static int solution2(int N, String S) {
		//TODO:: To analyze
		int[][] seat = new int[N + 1][10];
		int num = 0;
		char[] s = S.toCharArray();
		for (int i = 0; i < S.length(); i++) {
			if (s[i] == ' ')
				continue;
			else if (s[i] >= '0' && s[i] <= '9')
				num = num * 10 + s[i] - '0';
			else {
				seat[num][s[i] - 'A'] = 1;
				num = 0;
			}
		}
		int ret = 0;
		for (int i = 1; i <= N; i++) {
			if (seat[i][1] + seat[i][2] + seat[i][3] + seat[i][4] == 0) {
				seat[i][1] = seat[i][2] = seat[i][3] = seat[i][4] = 1;
				ret++;
			}
			if (seat[i][3] + seat[i][4] + seat[i][5] + seat[i][6] == 0) {
				seat[i][3] = seat[i][4] = seat[i][5] = seat[i][6] = 1;
				ret++;
			}
			if (seat[i][5] + seat[i][6] + seat[i][7] + seat[i][8] == 0) {
				seat[i][5] = seat[i][6] = seat[i][7] = seat[i][8] = 1;
				ret++;
			}
		}
		return ret;
	}

	public static int solution(int N, String S) {
		String[] reserved = S.split(" ");
		String[][] allocation = new String[N][10];

		if (reserved.length > 1) {
			for (int i = 0; i < reserved.length; i++) {
				int row = Character.getNumericValue(reserved[i].charAt(0)) - 1;
				int column = (reserved[i].charAt(1) - 'A' + 1) - 1;
				allocation[row][column] = "reserved";
			}
		} else {
			for (int i = 0; i < N; i++) {
				allocation[i][0] = "reserved";
				allocation[i][9] = "reserved";
			}
		}
		// print(allocation);
		int occurances = 0;
		for (int i = 0; i < allocation.length; i++) {
			int counter = 0;
			for (int j = 0; j < allocation[i].length; j++) {
				if ("reserved".equalsIgnoreCase(allocation[i][j])) {
					if (j > 0) {
						allocation[i][j - 1] = null;
						counter--;
					}
					continue;
				} else {
					allocation[i][j] = "occupies";
					counter++;
				}
				if (counter == 4) {
					occurances++;
					counter = 0;
				}
				if (occurances == 2)
					break;
			}
		}
		// print(allocation);
		return occurances;
	}

	public static void print(String[][] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				// System.out.print(data[i]+""+data[j]);
			}
			System.out.println();
		}
	}
}
