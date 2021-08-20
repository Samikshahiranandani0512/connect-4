/* 

Introductory Java Project

Terminal Based Game: Two Player Connect 4 
Author: Samiksha Hiranandani (2016). 

*/



import java.util.Scanner;

public class project {
  static int size_c = 7;
  static int size_r = 6;
  static int arr[][] = new int[size_r][size_c];

  project() // constructor to initialise values of array to 0.
  {
    for (int i = 0; i < size_r; i++) {
      for (int x = 0; x < size_c; x++)
        arr[i][x] = 0;
    }
  }

  public static void main() {
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to Connect 4 !");
    System.out.println("Player 1 please enter your name: ");
    String p1 = in.next();
    System.out.println("Player 2 please enter your name: ");
    String p2 = in.next();
    System.out.println(p1 + ", you will play first.Your token will be represented by 'X' ");
    System.out.println(p2 + ", you will play second.Your token will be represented by 'O' ");
    System.out.println("The aim of the game is to make a horizontal/vertical row of 4 of your own tokens.");

    boolean game_over = false;
    int input = 0;
    int column_number = 0;
    int found = 0;
    int check = 0;

    while (game_over == false) {

      System.out
          .println(p1 + ", please enter the column number in which you wish to play. You may enter numbers from 1-7.");
      input = in.nextInt();
      column_number = input - 1;
      found = 0;
      if (column_number >= size_c && column_number < 0) // invalid inputs
      {
        System.out.println("Invalid column number.");
        continue;
      }

      for (int i = size_r - 1; i >= 0; i--) {
        if (arr[i][column_number] == 0) {
          arr[i][column_number] = 1;
          found = 1;
          break;
        }
      }

      if (found == 0) // if entered column number is already full
      {
        System.out.println("You may not enter your token in this column.");
        continue;
      }

      print_board();
      check = game_over(1);

      if (check == 1) {
        System.out.println(p1 + " WINS !");
        System.out.println("Thank you for playing connect 4 !");
        game_over = true;
        continue;
      }

      if (check == -1) {
        System.out.println("The game is a draw!");
        System.out.println("Thank you for playing connect 4 !");
        break;
      }

      System.out
          .println(p2 + ", please enter the column number in which you wish to play. You may enter numbers from 1-7.");

      input = in.nextInt();

      column_number = input - 1;

      found = 0;

      if (column_number >= size_c && column_number < 0) // invalid inputs
      {
        System.out.println("Invalid column number.");
        continue;
      }

      for (int i = size_r - 1; i >= 0; i--) {
        if (arr[i][column_number] == 0) {
          arr[i][column_number] = 2;
          found = 1;
          break;
        }
      }

      if (found == 0) // if entered column number is already full
      {
        System.out.println("You may not enter your token in this column.");
        continue;
      }

      print_board();

      check = game_over(2);

      if (check == 2) {
        System.out.println(p2 + " WINS !");
        System.out.println("Thank you for playing connect 4 !");
        game_over = true;
        continue;
      }
      if (check == -1) {
        System.out.println("The game is a draw!");
        System.out.println("Thank you for playing connect 4 !");
        break;
      }
    }

  }

  public static int game_over(int find) {
    boolean found = false;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 4; j++) {
        if (arr[i][j] == find) {
          if (arr[i][j] == arr[i][j + 1] && arr[i][j + 1] == arr[i][j + 2] && arr[i][j + 2] == arr[i][j + 3]) {
            found = true;
            return find;

          }
        }
      }
    }
    for (int j = 0; j < 7; j++) {
      for (int i = 0; i < 3; i++) {
        if (arr[i][j] == find) {
          if (arr[i][j] == arr[i + 1][j] && arr[i + 1][j] == arr[i + 2][j] && arr[i + 2][j] == arr[i + 3][j]) {
            found = true;
            return find;

          }
        }
      }
    }

    int count = 0;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 7; j++) {
        if (arr[i][j] == 0) {
          count++;
          break;
        }

      }
    }
    if (count == 0)
      return -1;

    return 0;
  }

  public static void print_board() {
    int x = 0;
    int y = 0;
    char token = ' ';

    for (int a = 0; a < size_c * 9; a++)
      System.out.print("_");
    for (int i = 0; i < size_r; i++) {
      System.out.println();
      for (int b = 0; b < size_c + 1; b++)
        System.out.print("|        ");
      System.out.println();
      for (int c = 0; c < size_c; c++) {
        if (arr[i][c] == 1)
          token = 'X';
        if (arr[i][c] == 2)
          token = '0';
        if (arr[i][c] == 0)
          token = ' ';

        System.out.print("|    " + token + "   ");
      }
      System.out.println("|");
      for (int b = 0; b < size_c + 1; b++)
        System.out.print("|        ");
      System.out.println();
      y++;
      if (y == size_c && x < size_r) {
        y = 0;
        x++;
      }
      for (int a = 0; a < size_c * 9; a++)
        System.out.print("_");

    }
    System.out.println();
  }
}
