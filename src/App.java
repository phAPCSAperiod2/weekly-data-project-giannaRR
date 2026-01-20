import java.util.Scanner;

/**
 * Instructions:
 * - Complete the WeeklyData.java class first.
 * - Use this App class to collect user input and test your WeeklyData methods.
 * - Follow all TODOs carefully.
 * - Do NOT hard-code values — use loops and method calls.
 */
public class App {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // TODO 1: Create a Scanner for user input
        // -------------------------------------------------------------
        Scanner input = new Scanner(System.in);

        // -------------------------------------------------------------
        // TODO 2: Give information about your program
        //         Ask the user about their goals (if applicable)
        // -------------------------------------------------------------
        System.out.println("This program tracks the number of movies you watch in a week!");
        System.out.print("What is your goal for the number of movies to watch this week? ");
        int moviesGoal = input.nextInt();

        // -------------------------------------------------------------
        // TODO 3: Create an array to hold 7 days of data
        //         Use an appropriate data type (int or double)
        //         Name the array weekData
        // -------------------------------------------------------------
        int[] weekData = new int[7];

        // -------------------------------------------------------------
        // TODO 4: Use a for loop to collect data for each day of the week
        //         Prompt example:
        //         "Enter <data type> for day X: "
        //
        //         Include input validation:
        //         - Use a while loop to prevent negative values
        //         - Re-prompt if the value is invalid
        // -------------------------------------------------------------
        for (int i = 0; i < weekData.length; i++) {
            System.out.print("Enter the number of movies watched you have watched for day " + (i + 1) + ": ");
            int moviesWatched = input.nextInt();
            while (moviesWatched < 0) {
                System.out.print("Invalid input. Please enter a non-negative number for day " + (i + 1) + ": ");
                moviesWatched = input.nextInt();
            }
            weekData[i] = moviesWatched;
        }

        // -------------------------------------------------------------
        // TODO 5: Create a WeeklyData object
        //         Pass the weekData array into the constructor
        // -------------------------------------------------------------
        WeeklyData weeklyData = new WeeklyData(new double[] {weekData[0], weekData[1], weekData[2], weekData[3],weekData[4], weekData[5], weekData[6]});

        // -------------------------------------------------------------
        // TODO 6: Display the results of the analysis
        //         Call methods from WeeklyData to display:
        //         - Total
        //         - Average
        //         - Minimum
        //         - Maximum
        //
        //         Use clear labels and formatted output if needed
        // -------------------------------------------------------------
        System.out.println("Total movies watched this week: " + weeklyData.getTotal());
        System.out.println("Average movies watched per day: " + weeklyData.getAverage());
        System.out.println("Minimum movies watched in a day: " + weeklyData.getMin());
        System.out.println("Maximum movies watched in a day: " + weeklyData.getMax());

        // -------------------------------------------------------------
        // TODO 7: Display the full week of data
        //         Use the toString() method from WeeklyData
        // -------------------------------------------------------------
        System.out.println("Here is your data for the week:");
        System.out.println(weeklyData.toString());

        // -------------------------------------------------------------
        // TODO 8: Give the user insights about their week
        //         --> "You need to drink more water next week!"
        //         --> "You were very hydrated this week!"
        //         --> etc.
        // -------------------------------------------------------------
        if (weeklyData.getTotal() < moviesGoal) {
            System.out.println("You didn't meet your goal of " + moviesGoal + " movies this week. Keep trying!");
        } else {
            System.out.println("Great job! You met your goal of " + moviesGoal + " movies this week!");
            System.out.println("Maybe try another actvity or start your goal for the next week");
        }

    }
}
