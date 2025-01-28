import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class OnlineExamSystem {
    private static List<Question> questionBank = new ArrayList<>();
    private static List<String> studentUsernames = new ArrayList<>();
    private static List<String> studentPasswords = new ArrayList<>();

    
    private static final Color PRIMARY_CLR1 = new Color(0x143f40); 
    private static final Color PRIMARY_CLR2 = new Color(0xe0bb68);
    private static final Color WHITE_CLR = new Color(0xffffff);
    private static final Color DARK_CLR = new Color(0x111a19);



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

        studentLoginButton.addActionListener(e -> {
            mainMenuFrame.dispose();
            showStudentLogin();
        });

        registerButton.addActionListener(e -> {
            mainMenuFrame.dispose();
            showRegistrationForm();
        });

        exitButton.addActionListener(e -> System.exit(0));

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBackground(WHITE_CLR);

        panel.add(titleLabel);
        panel.add(studentLoginButton);
        panel.add(registerButton);
        panel.add(exitButton); 

        mainMenuFrame.add(panel);
        mainMenuFrame.setVisible(true);

    }
    
    private static void showRegistrationForm() {
        JFrame registrationFrame = new JFrame("Student Registration");
        registrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registrationFrame.setSize(400, 300);
        registrationFrame.getContentPane().setBackground(WHITE_CLR); // Set background color

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");

        //button colors
        registerButton.setBackground(PRIMARY_CLR2);
        registerButton.setForeground(DARK_CLR);
        backButton.setBackground(PRIMARY_CLR2);
        backButton.setForeground(DARK_CLR);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(registrationFrame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (studentUsernames.contains(username)) {
                JOptionPane.showMessageDialog(registrationFrame, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                studentUsernames.add(username);
                studentPasswords.add(password);
                JOptionPane.showMessageDialog(registrationFrame, "Registration successful!");
                registrationFrame.dispose();
                showMainMenu();
            }
        });

        backButton.addActionListener(e -> {
            registrationFrame.dispose();
            showMainMenu();
        });

        
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBackground(WHITE_CLR); 


        // add button and labels to panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(registerButton);
        panel.add(backButton);

        registrationFrame.add(panel);
        registrationFrame.setVisible(true)


        
    }

    private static void showStudentLogin() {
        JFrame studentLoginFrame = new JFrame("Student Login");
        studentLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentLoginFrame.setSize(400, 300);
        studentLoginFrame.getContentPane().setBackground(WHITE_CLR);

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");

        //button colors
        loginButton.setBackground(PRIMARY_CLR2);
        loginButton.setForeground(DARK_CLR);
        backButton.setBackground(PRIMARY_CLR2);
        backButton.setForeground(DARK_CLR);

         loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            
            int index = studentUsernames.indexOf(username);
            if (index >= 0 && studentPasswords.get(index).equals(password)) {
                currentUser  = username;
                currentQuestionIndex = 0;
                score = 0;
                studentLoginFrame.dispose();
                showExam();
            } else {
                JOptionPane.showMessageDialog(studentLoginFrame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton.addActionListener(e -> {
            studentLoginFrame.dispose();
            showMainMenu();
        });


        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBackground(WHITE_CLR);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(backButton);

        studentLoginFrame.add(panel);
        studentLoginFrame.setVisible(true);
    }

    private static void showExam() {

        // check if all questions are answered
        if (currentQuestionIndex >= questionBank.size()) {
            showResult();
            return;
        }

        Question currentQuestion = questionBank.get(currentQuestionIndex);

        JFrame frame = new JFrame("Exam - Question " + (currentQuestionIndex + 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.getContentPane().setBackground(WHITE_CLR); 

        JLabel questionLabel = new JLabel("<html>" + currentQuestion.getQuestionText() + "</html>");
        questionLabel.setForeground(PRIMARY_CLR1);
        // create radio buttons for options
        JRadioButton[] options = new JRadioButton[4];
        ButtonGroup group = new ButtonGroup();
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        optionsPanel.setBackground(WHITE_CLR); 

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton(currentQuestion.getOptions()[i]);
            options[i].setBackground(WHITE_CLR); 
            options[i].setForeground(DARK_CLR); 
            group.add(options[i]);
            optionsPanel.add(options[i]);
        }

        JButton nextButton = new JButton("Next");
        nextButton.setBackground(PRIMARY_CLR2);
        nextButton.setForeground(DARK_CLR);

        nextButton.addActionListener(e -> {
            for (int i = 0; i < 4; i++) {
                if (options[i].isSelected()) {
                    if (i + 1 == currentQuestion.getCorrectOption()) {
                        score++;
                    }
                    break;
                }
            }
            currentQuestionIndex++;
            frame.dispose();
            showExam();
        });

        frame.add(questionLabel, BorderLayout.NORTH);
        frame.add(optionsPanel, BorderLayout.CENTER);
        frame.add(nextButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }


    private static void showResult() {
        JFrame resultFrame = new JFrame("Exam Result");
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultFrame.setSize(400, 300);
        resultFrame.getContentPane().setBackground(WHITE_CLR); 

        int totalQuestions = questionBank.size();
        int obtainedMarks = score * 100 / totalQuestions;
        String result = "Score: " + score + "/" + totalQuestions + " (" + obtainedMarks + "%)";
        studentResults.add(currentUser  + ": " + result);

        JLabel resultLabel = new JLabel(result, SwingConstants.CENTER);
        resultLabel.setForeground(PRIMARY_CLR1); 
        JButton backButton = new JButton("Back to Main Menu");

        backButton.addActionListener(e -> {
            resultFrame.dispose();
            showMainMenu();
        });

        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        panel.setBackground(WHITE_CLR); 
        panel.add(resultLabel);
        panel.add(backButton);

        resultFrame.add(panel);
        resultFrame.setVisible(true);
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