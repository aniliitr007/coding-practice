package com.akgcloud.topcoder;

public class BishopMove {

    public static int howManyMoves(int r1, int c1, int r2, int c2) {
        int moveCount = -1;
        if ((isBothSameType(r1, c1) && isBothSameType(r2, c2)) || (!isBothSameType(r1, c1) && !isBothSameType(r2, c2))) {
            if (r1 == r2 && c1 == c2) {
                moveCount = 0;
            } else if (Math.abs(r1 - r2) == Math.abs(c1 - c2)) {
                moveCount = 1;
            } else {
                moveCount = 2;
            }
        }
        return moveCount;
    }

    public static boolean isBothSameType(int a, int b) {
        if (a % 2 == 0 && b % 2 == 0) {
            return true;
        }
        if (a % 2 != 0 && b % 2 != 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(BishopMove.howManyMoves(4, 6, 3, 7));
        System.out.println(BishopMove.howManyMoves(1, 3, 5, 5));

    }
}
