package Assignment4;

import java.util.*;

//*********************************************************************************************************
//Assignment 4 Grade App        Author: Carlos Fernandez/L30031020
//
//Program to grade scores for a given number of students with 4 Assignments and 4 Test
//*********************************************************************************************************

public class GradeApp {

	public static int getInput(double[][] scores) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the number of students you would like to grade:");

		int n = scan.nextInt();

		for (int a = 0; a < n; a++) {

			System.out.println("Enter Student # " + (a + 1) + " scores: ");

			for (int b = 0; b < 4; b++) {

				System.out.print("Enter Exam # " + (b + 1) + " Score(0-50):");

				scores[a][b] = scan.nextDouble();

			}

			for (int b = 4; b < 8; b++) {

				System.out.print("Enter Assignment # " + (b + 1) + " Score(0-75):");

				scores[a][b] = scan.nextDouble();

			}

		}

		return n;

	}

	public static double calculateMeanGrade(double[][] data, int n, String[] grades) {

		double total = 0;

		for (int a = 0; a < n; a++) {

			double sum = 0;

			for (int b = 0; b < 8; b++) {

				sum = sum + data[a][b];

			}

			if (sum >= 450)

				grades[a] = "A";

			else if (sum >= 400)

				grades[a] = "B";

			else if (sum >= 350)

				grades[a] = "C";

			else if (sum >= 300)

				grades[a] = "D";

			else

				grades[a] = "F";

			data[a][8] = sum;

			total = total + sum;

		}

		return total / n;

	}

	public static double Deviation(double data[][], int n, double m) {

		double total = 0;

		for (int a = 0; a < n; a++) {

			total = total + (data[a][8] - m) * (data[a][8] - m);

		}

		double avg = total / n;

		return Math.sqrt(avg);

	}

	public static void calculateModified(double[][] data, int n, String[] grades, double mean, double deviation) {

		for (int a = 0; a < n; a++) {

			if (data[a][8] >= (mean + 2 * deviation))

				grades[a] = "A";

			else if (data[a][8] >= (mean + 1 * deviation))

				grades[a] = "B";

			else if (data[a][8] >= mean)

				grades[a] = "C";

			else if (data[a][8] >= (mean - 1 * deviation))

				grades[a] = "D";

			else if (data[a][8] < (mean - 2 * deviation))

				grades[a] = "F";

		}

	}

	public static void Display(double[][] data, int n, String[] mgrades) {

		for (int a = 0; a < n; a++) {

			System.out.println("Student # " + (a + 1) + " Final Grade: " + mgrades[a]);

		}

	}

	public static void main(String[] args) {

		double[][] scores = new double[100][9];

		String[] grades = new String[100];

		String[] mgrades = new String[100];

		int n = getInput(scores);

		double mean = calculateMeanGrade(scores, n, grades);

		double stddeviation = Deviation(scores, n, mean);

		for (int a = 0; a < n; a++) {

			mgrades[a] = grades[a];

		}

		calculateModified(scores, n, mgrades, mean, stddeviation);

		Display(scores, n, mgrades);

	}

}