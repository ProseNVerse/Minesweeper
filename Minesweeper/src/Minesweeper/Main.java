package Minesweeper;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;


public class Main {
	
	static boolean Bomb = false;
	private static String answer = "";
	private static String reply = "";
	private static Scanner keyboard = new Scanner (System.in);
	static int A = (int)(Math.random()*9);
	static int B = (int)(Math.random()*9);
	static int C = (int)(Math.random()*9);
	static int D = (int)(Math.random()*9);
	static String Bomb1 = ("("+A + ", " + B+")");
	static String Bomb2 = ("("+C + ", " + D+")");

	public static void main(String[] args) {
		
		
		int X, Y;
		X = 0;
		Y = 0;
		Grid G = new Grid();		
		System.out.println(Bomb1);
		System.out.println(Bomb2);
		
		
		reply = keyboard.nextLine();
		answer = reply;
		switch(answer) {
		default:
		case "(0,0)":
			System.out.println("this is where you are");
		}
	}

}
