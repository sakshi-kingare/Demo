package Demo;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String questionText;
    private String[] options;
    private int correctOptionIndex;

    public QuizQuestion(String questionText, String[] options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

class Quiz {
    private QuizQuestion[] questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;

    public Quiz(QuizQuestion[] questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public void startQuiz() {
        displayQuestion();
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.length) {
            QuizQuestion currentQuestion = questions[currentQuestionIndex];
            System.out.println("Question: " + currentQuestion.getQuestionText());

            String[] options = currentQuestion.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            startTimer();

            // Get user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your answer (1-" + options.length + "): ");
            int userAnswerIndex = scanner.nextInt() - 1;

            stopTimer(); // Stop the timer after the user submits an answer

            // Check if the user's answer is correct
            if (userAnswerIndex >= 0 && userAnswerIndex < options.length
                    && userAnswerIndex == currentQuestion.getCorrectOptionIndex()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " + (currentQuestion.getCorrectOptionIndex() + 1) + "\n");
            }

            // Move to the next question
            currentQuestionIndex++;
            displayQuestion();
        } else {
            displayResult();
        }
    }

    private void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! Moving to the next question.\n");
                stopTimer();
                currentQuestionIndex++;
                displayQuestion();
            }
        }, 10000); // Set the timer duration (in milliseconds) - 10 seconds in this example
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
    }

    private void displayResult() {
        System.out.println("Quiz Completed!");
        System.out.println("Your Score: " + score + " out of " + questions.length);
    }
}

 class QuizApplication {
    public static void main(String[] args) {
        // Create quiz questions
        QuizQuestion question1 = new QuizQuestion("What is the capital of France?",
                new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2);
        QuizQuestion question2 = new QuizQuestion("Which planet is known as the Red Planet?",
                new String[]{"Mars", "Jupiter", "Venus", "Saturn"}, 0);

        // Create a quiz with the questions
        Quiz quiz = new Quiz(new QuizQuestion[]{question1, question2});

        // Start the quiz
        quiz.startQuiz();
    }
}
