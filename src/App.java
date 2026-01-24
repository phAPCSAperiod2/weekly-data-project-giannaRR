import java.util.Scanner;

/**
 * App class - Movie Tracker Application
 * 
 * This application tracks the number of movies watched each day of the week
 * and provides analysis including total, average, minimum, and maximum values.
 * It collects user input for their weekly movie-watching goal and daily movie counts,
 * then displays statistics and feedback based on whether the goal was met.
 * 
 * @author Student
 * @version 1.0
 */
public class App {

    /**
     * Main method - Entry point of the Movie Tracker application.
     * 
     * This method:
     * 1. Creates a Scanner for user input
     * 2. Prompts the user to set a goal for movies to watch
     * 3. Collects daily movie count data for 7 days with input validation
     * 4. Creates a WeeklyData object with the collected data
     * 5. Displays analysis results (total, average, min, max)
     * 6. Shows the complete weekly data
     * 7. Provides feedback on whether the weekly goal was met
     * 
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // -------------------------------------------------------------
        // TODO 1: Create a Scanner for user input
        // -------------------------------------------------------------
        Scanner input = new Scanner(System.in);

        // -------------------------------------------------------------
        // TODO 2: Give information about your program
        //         Ask the user about their goals (if applicable)
        // -------------------------------------------------------------
        System.out.println("This program tracks the number of movies you watch in a week! 📽️ 🍿");
        System.out.println("What is your goal for the number of movies to watch this week? ");
        System.out.println("");
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
        //       Compare the total to the goal and provide feedback
        // -------------------------------------------------------------
        int suggestedGoal;
        if (weeklyData.getTotal() < moviesGoal) {
            System.out.println("You didn't meet your goal of " + moviesGoal + " movies this week. 😞");
            suggestedGoal = moviesGoal - 5;
            System.out.println("Suggestion for next week: Consider decreasing your goal to " + suggestedGoal + " movies to make it more achievable.");
        } else {
            System.out.println("Great job! You met your goal of " + moviesGoal + " movies this week! 🎉");
            suggestedGoal = moviesGoal + 5;
            System.out.println("Suggestion for next week: You could challenge yourself by increasing your goal to " + suggestedGoal + " movies!");
        }

    }
}
