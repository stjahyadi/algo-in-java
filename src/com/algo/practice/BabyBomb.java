package com.algo.practice;

public class BabyBomb {
	public static void main(String[] args) {
		System.out.println(solution3("2", "1")); // 1
		System.out.println(solution3("4", "7")); // 4
		System.out.println(solution3("2", "4")); // impossible
	}
	
	
	public static String solution3(String x, String y) {
		int m = Integer.parseInt(x);
		int f = Integer.parseInt(y);

		int total = 0;
		while (m > 1 && f > 1) {
			if (m > f) {
				int tmp = f;
				f = m;
				m = tmp;
			}

			total += f / m;
			f = f % m;
		}
		if (m > f) {
			int tmp = f;
			f = m;
			m = tmp;
		}
		if (f <= 0 || m <= 0)
			return "imposible";
		else return String.valueOf(total + (f / m) - 1);
	}
	
	public static long multiplier(long a, long b) {
		long diff = a - b;
		return (diff / b) + 1;
	}

	public static String solution(String x, String y) {
		long step = 0L, m = Long.parseLong(x), f = Long.parseLong(y);
		while (true) {
			if (m <= 0 || f <= 0)
				break;
			if (m > 100 || f > 100) {
				if (m > f) {
					long mul = multiplier(m, f);
					m -= f * mul;
					step += mul;
				} else if (f > m) {
					long mul = multiplier(f, m);
					f -= m * mul;
					step += mul;
				} else {
					break;
				}
			} else {
				if (m > f)
					m -= f;
				else if (f > m)
					f -= m;
				else
					break;
				step += 1;
			}
		}

		if (m == 1 && f == 1 && step >= 0) {
			return Long.toString(step);
		}
		return "impossible";
	}
}
