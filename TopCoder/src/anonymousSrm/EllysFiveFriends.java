package anonymousSrm;

import java.util.Arrays;

public class EllysFiveFriends
{
	public static int MAX = 5;
	public static int BASE = 26;
	public static int MASK = 11881376;
	public static int MOD = 1000000007;

	int[][] a;
	int[] dyn, len, idx;
	
	public int recurse()
	{
		int flag = 1, mask = 0;
		for (int i = 0; i < MAX; i++)
		{
			if (idx[i] < len[i])
				flag = 0;
			mask = mask * BASE + idx[i];
		}
		if (flag == 1) return 1;
		if (dyn[mask] != -1) return dyn[mask];
		
		int ans = 0;
		for (int i1 = 0; i1 < MAX; i1++) if (idx[i1] < len[i1])
		{
			int i2 = (i1 + 1) % MAX;
			if (idx[i2] < len[i2])
			{
				// Try to subtract
				if (a[i1][idx[i1]] == 1 && a[i2][idx[i2]] == 1)
				{
					idx[i1]++; idx[i2]++;
					ans += recurse(); if (ans >= MOD) ans -= MOD;
					idx[i1]--; idx[i2]--;
				}
				// Try to divide
				int s1 = idx[i1], s2 = idx[i2];
				idx[i1] = Math.min(idx[i1] + a[i1][idx[i1]] + 1, len[i1]);
				idx[i2] = Math.min(idx[i2] + a[i2][idx[i2]] + 1, len[i2]);
				ans += recurse(); if (ans >= MOD) ans -= MOD;
				idx[i1] = s1; idx[i2] = s2;
			}
		}
		return dyn[mask] = ans;
	}
	
	public int getZero(int[] numbers)
	{
		a = new int[MAX][BASE];
		len = new int[MAX]; Arrays.fill(len, 0);
		idx = new int[MAX]; Arrays.fill(idx, 0);
		dyn = new int[MASK]; Arrays.fill(dyn, -1);
		for (int i = 0; i < MAX; i++)
		{
			while (numbers[i] > 0)
			{
				if (numbers[i] % 2 == 1) {a[i][len[i]++] = 1; numbers[i]--;}
				else {a[i][len[i]++] = 0; numbers[i] >>= 1;}
			}
		}
		return recurse();
	}
}