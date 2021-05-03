package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static char[] chars = new char[9];
    static int first = 0;
    static int second = 0;
    static int empty = 0;
    static String c1 = " ";
    static String c2 = " ";
    static int ile = 0;
    static int ile1 = 0;
    static int ile2 = 0;
    static int pos = -1;
    static boolean flag = false;
    static boolean oes = false;
    static boolean xos = false;
    static boolean draw = false;
    static String res = null;


    static char array2d[][] = new char[3][3];

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);

        String reg = "[1-3]";
        String reg1 = "[4-9]";
        String reg2 = "[0-9]";


        chars = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',};

        System.out.println("---------");
        System.out.print("| ");
        for (int i = 0; i <= 2; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println("|");
        System.out.print("| ");
        for (int i = 3; i <= 5; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println("|");
        System.out.print("| ");
        for (int i = 6; i <= 8; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.print("|");
        System.out.println();
        System.out.println("---------");

        for (char aChar : chars) {
            if (aChar == 'O') {
                first++;
            }
            if (aChar == 'X') {
                second++;
            }
            if (aChar == '_') {
                empty++;
            }
        }
        for (int i = 0; i < 3; i++) {
            System.arraycopy(chars, (i * 3), array2d[i], 0, 3);
        }


        while (flag = true) {
            System.out.print("Enter coordinates: ");
            c1 = sca.next();
            c2 = sca.next();


            try {
                if (!c1.matches(reg2) || !c2.matches(reg2)) {
                    System.out.println("You should enter numbers!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            try {
                if (Integer.parseInt(c1) - 1 < 0 || Integer.parseInt(c1) - 1 > 2 ||
                        Integer.parseInt(c2) - 1 < 0 || Integer.parseInt(c2) - 1 > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    ile++;
                    continue;

                }
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            try {
                if (
                        (array2d[Integer.parseInt(c1) - 1][Integer.parseInt(c2) - 1] == 'X' || array2d[Integer.parseInt(c1) - 1][Integer.parseInt(c2) - 1] == 'O')) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }


            try {
                if (ile > 0
                        &&
                        Integer.parseInt(c1) - 1 < 0 || Integer.parseInt(c1) - 1 > 2 ||
                        Integer.parseInt(c2) - 1 < 0 || Integer.parseInt(c2) - 1 > 2
                ) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            ile1++;
            ile2++;
            flag = true;
            currentGrid(c1, c2);
            result();
            if (res != null) {
                System.out.println(res);
                System.exit(0);

            } else continue;


        }


    }

    private static void result() {
        if ((chars[0] == 'O' && chars[1] == 'O' && chars[2] == 'O') ||
                (chars[3] == 'O' && chars[4] == 'O' && chars[5] == 'O') ||
                (chars[6] == 'O' && chars[7] == 'O' && chars[8] == 'O') ||
                (chars[0] == 'O' && chars[3] == 'O' && chars[6] == 'O') ||
                (chars[1] == 'O' && chars[4] == 'O' && chars[7] == 'O') ||
                (chars[2] == 'O' && chars[5] == 'O' && chars[8] == 'O') ||
                (chars[0] == 'O' && chars[4] == 'O' && chars[8] == 'O') ||
                (chars[2] == 'O' && chars[4] == 'O' && chars[6] == 'O')) {
            oes = true;
            res = "O wins";


        }


        if ((chars[0] == 'X' && chars[1] == 'X' && chars[2] == 'X') ||
                (chars[3] == 'X' && chars[4] == 'X' && chars[5] == 'X') ||
                (chars[6] == 'X' && chars[7] == 'X' && chars[8] == 'X') ||
                (chars[0] == 'X' && chars[3] == 'X' && chars[6] == 'X') ||
                (chars[1] == 'X' && chars[4] == 'X' && chars[7] == 'X') ||
                (chars[2] == 'X' && chars[5] == 'X' && chars[8] == 'X') ||
                (chars[0] == 'X' && chars[4] == 'X' && chars[8] == 'X') ||
                (chars[2] == 'X' && chars[4] == 'X' && chars[6] == 'X')) {
            xos = true;
            res = "X wins";
        }


        for (int i = 0; i < chars.length; i++) {
            if (!oes && !xos && ile2 == 9) {
                res = "Draw";
                draw = true;


                break;
            }
        }

    }


    private static void currentGrid(String c1, String c2) {

        if (c1.equals("1") && c2.equals("1")) {
            pos = 0;
        } else if (c1.equals("1") && c2.equals("2")) {
            pos = 1;
        } else if (c1.equals("1") && c2.equals("3")) {
            pos = 2;
        } else if (c1.equals("2") && c2.equals("1")) {
            pos = 3;
        } else if (c1.equals("2") && c2.equals("2")) {
            pos = 4;
        } else if (c1.equals("2") && c2.equals("3")) {
            pos = 5;
        } else if (c1.equals("3") && c2.equals("1")) {
            pos = 6;
        } else if (c1.equals("3") && c2.equals("2")) {
            pos = 7;
        } else if (c1.equals("3") && c2.equals("3")) {
            pos = 8;
        }
        if (ile1 % 2 == 0) {
            chars[pos] = 'O';
        } else {
            chars[pos] = 'X';
        }


        System.out.println("---------");
        System.out.print("| ");
        for (
                int i = 0;
                i <= 2; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println("|");
        /*   System.out.println();*/
        System.out.print("| ");
        for (
                int i = 3;
                i <= 5; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println("|");
        System.out.print("| ");
        for (
                int i = 6;
                i <= 8; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.print("|");
        System.out.println();
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.arraycopy(chars, (i * 3), array2d[i], 0, 3);
        }


    }


}