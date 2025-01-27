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
        questionBank.add(new Question("Which of the following is a valid way to start the main method in Java?", new String[]{"public static void main(String[] args)", "void main(String[] args)", "static void main()", "main()"}, 1));
        questionBank.add(new Question("What is the size of an 'int' data type in Java?", new String[]{"16 bits", "32 bits", "64 bits", "8 bits"}, 2));
        questionBank.add(new Question("Which method is used to print something on the console in Java?", new String[]{"System.output()", "System.print()", "System.out.println()", "System.console()"}, 3));
        questionBank.add(new Question("Which exception is thrown when dividing by zero in Java?", new String[]{"ArithmeticException", "NullPointerException", "NumberFormatException", "IOException"}, 1));
        questionBank.add(new Question("What is the keyword used to inherit a class in Java?", new String[]{"implement", "inherits", "extends", "super"}, 3));
        questionBank.add(new Question("Which package is automatically imported in every Java program?", new String[]{"java.util", "java.io", "java.lang", "java.net"}, 3));
    }

    public static void main(String[] args) {
        initializeQuestionBank();
        SwingUtilities.invokeLater(OnlineExamSystem::showMainMenu);
    }

     // Main menu
    private static void showMainMenu() {
        JFrame mainMenuFrame = new JFrame("Online Exam System");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(400, 300);
        mainMenuFrame.getContentPane().setBackground(WHITE_CLR);

        JLabel titleLabel = new JLabel("Online Exam System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(PRIMARY_CLR1); 

        JButton studentLoginButton = new JButton("Student Login");
        JButton registerButton = new JButton("Register");
        JButton exitButton = new JButton("Exit");

        
        studentLoginButton.setBackground(PRIMARY_CLR2);
        studentLoginButton.setForeground(DARK_CLR);
        registerButton.setBackground(PRIMARY_CLR2);
        registerButton.setForeground(DARK_CLR);
        exitButton.setBackground(PRIMARY_CLR2);
        exitButton.setForeground(DARK_CLR);
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