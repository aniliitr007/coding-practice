package com.akgcloud.geeksforgeeks;

public class BitMagic {
	
	public static int swapNibbles(int x) {
		return (x << 4) | (x >> 4);
	}

	public static void main(String[] args) {
		int n = 100;
		System.out.println(BitMagic.swapNibbles(n));

	}

}
