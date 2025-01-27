import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class OnlineExamSystem {
    private static List<Question> questionBank = new ArrayList<>();

    // Initialize the question bank with sample questions
    private static void initializeQuestionBank() {
        questionBank.add(new Question("Which keyword is used to define a class in Java?", new String[]{"class", "Class", "struct", "def"}, 1));
        questionBank.add(new Question("Which data type is used to store decimal numbers in Java?", new String[]{"int", "float", "char", "boolean"}, 2));
        questionBank.add(new Question("What is the default value of a boolean variable in Java?", new String[]{"true", "false", "null", "undefined"}, 2));
        questionBank.add(new Question("Which of the following is NOT a valid access modifier in Java?", new String[]{"public", "protected", "private", "defaulted"}, 4));
    }


}

// Question class
class Question {
    private String questionText;
    private String[] options;
    private int correctOption;

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}