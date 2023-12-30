package javafx; // Author: wqKang
// Author: wqKang

import ExerciseClass.EquationCheckerOfRange;
import ExerciseClass.EquationCollection;
import ExerciseClass.IEquation;
import Mysql.MySQLUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
// Author: wqKang

/**
 * // Author: wqKang
 * JavaFX 应用程序类，用于生成口算习题并进行用户交互。 // Author: wqKang
 */ // Author: wqKang
public class EquationApplication extends Application { // Author: wqKang
    private static final int NUM_QUESTIONS = 5; // Author: wqKang
    public EquationCollection equationCollection; // Author: wqKang
    private VBox questionVBox; // Author: wqKang
    private TextField[] answerFields; // Author: wqKang
    private PieChart accuracyChart; // Author: wqKang

    // Author: wqKang
    public static void main(String[] args) { // Author: wqKang
        launch(); // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    @Override // Author: wqKang
    public void start(Stage stage) { // Author: wqKang
        // 初始化算式集合 // Author: wqKang
        equationCollection = new EquationCollection(); // Author: wqKang
        // Author: wqKang
        // 菜单 // Author: wqKang
        MenuItem generateMenuItem = new MenuItem("生成习题"); // Author: wqKang
        MenuItem saveMenuItem = new MenuItem("保存习题"); // Author: wqKang
        MenuItem loadMenuItem = new MenuItem("读取习题"); // Author: wqKang
        MenuItem checkMenuItem = new MenuItem("检查习题"); // Author: wqKang
        // Author: wqKang
        // 菜单项事件处理 // Author: wqKang
        generateMenuItem.setOnAction(event -> { // Author: wqKang
            // 生成并展示新的习题 // Author: wqKang
            initializeUI(); // Author: wqKang
        }); // Author: wqKang
        // Author: wqKang
        loadMenuItem.setOnAction(event -> { // Author: wqKang
            // 从数据库加载并展示最新的五道题目 // Author: wqKang
            loadAndDisplayDatabaseQuestions(); // Author: wqKang
        }); // Author: wqKang
        // Author: wqKang
        // 保存习题菜单项事件处理 // Author: wqKang
        saveMenuItem.setOnAction(event -> saveEquationsToDatabase()); // Author: wqKang
        // Author: wqKang
        // 检查习题菜单项事件处理 // Author: wqKang
        checkMenuItem.setOnAction(event -> { // Author: wqKang
            // 检查答案并显示准确度对话框 // Author: wqKang
            int correctCount = checkAnswers(answerFields); // Author: wqKang
            showAccuracyDialog(correctCount); // Author: wqKang
        }); // Author: wqKang
        // Author: wqKang
        Menu fileMenu = new Menu("文件"); // Author: wqKang
        fileMenu.getItems().addAll(generateMenuItem, saveMenuItem, loadMenuItem, checkMenuItem); // Author: wqKang
        MenuBar menuBar = new MenuBar(); // Author: wqKang
        menuBar.getMenus().addAll(fileMenu); // Author: wqKang
        // Author: wqKang
        // 控件 // Author: wqKang
        questionVBox = new VBox(); // Author: wqKang
        questionVBox.setSpacing(10); // Author: wqKang
        questionVBox.setPadding(new Insets(20)); // Author: wqKang
        // Author: wqKang
        answerFields = new TextField[NUM_QUESTIONS]; // Author: wqKang
        accuracyChart = new PieChart(); // 创建新的 PieChart 实例 // Author: wqKang
        // Author: wqKang
        // 初始化 UI // Author: wqKang
        initializeUI(); // Author: wqKang
        // Author: wqKang
        // 布局 // Author: wqKang
        BorderPane borderPane = new BorderPane(); // Author: wqKang
        borderPane.setTop(menuBar); // Author: wqKang
        borderPane.setCenter(questionVBox); // Author: wqKang
        // Author: wqKang
        // 场景和舞台 // Author: wqKang
        Scene scene = new Scene(borderPane, 800, 640); // Author: wqKang
        stage.setTitle("口算习题薄"); // Author: wqKang
        stage.setScene(scene); // Author: wqKang
        stage.show(); // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    // 初始化用户界面 // Author: wqKang
    public void initializeUI() { // Author: wqKang
        // 清空现有题目VBox的内容 // Author: wqKang
        questionVBox.getChildren().clear(); // Author: wqKang
        // Author: wqKang
        // 生成并显示题目 // Author: wqKang
        generateAndDisplayQuestions(); // Author: wqKang
        // Author: wqKang
        // 创建检查按钮和结果标签 // Author: wqKang
        Button checkButton = new Button("检查"); // Author: wqKang
        Label resultLabel = new Label(); // Author: wqKang
        // Author: wqKang
        // 检查按钮事件处理 // Author: wqKang
        checkButton.setOnAction(event -> { // Author: wqKang
            int correctCount = checkAnswers(answerFields); // Author: wqKang
            resultLabel.setText("分数: " + correctCount + "/" + NUM_QUESTIONS); // Author: wqKang
            displayAccuracyChart(correctCount); // Author: wqKang
        }); // Author: wqKang
        // Author: wqKang
        // 添加控件到题目VBox // Author: wqKang
        questionVBox.getChildren().addAll(answerFields); // Author: wqKang
        questionVBox.getChildren().add(checkButton); // Author: wqKang
        questionVBox.getChildren().add(resultLabel); // Author: wqKang
        questionVBox.getChildren().add(accuracyChart); // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    // 从数据库加载并显示题目 // Author: wqKang
    public void loadAndDisplayDatabaseQuestions() { // Author: wqKang
        // 清空现有题目VBox的内容 // Author: wqKang
        questionVBox.getChildren().clear(); // Author: wqKang
        // Author: wqKang
        // 从数据库获取最新的题目 // Author: wqKang
        List<IEquation> latestQuestions = getLatestQuestionsFromDatabase(NUM_QUESTIONS); // Author: wqKang
        equationCollection.clear(); // 清空现有的题目 // Author: wqKang
        equationCollection.addAll(latestQuestions); // 添加最新的题目 // Author: wqKang
        answerFields = new TextField[NUM_QUESTIONS]; // Author: wqKang
        // Author: wqKang
        // 显示题目 // Author: wqKang
        for (int i = 0; i < NUM_QUESTIONS; i++) { // Author: wqKang
            IEquation equation = equationCollection.getEquationsList().get(i); // Author: wqKang
            // Author: wqKang
            // 打印每个生成的习题到控制台 // Author: wqKang
            System.out.println("问题读取 " + (i + 1) + ": " + equation.toString()); // Author: wqKang
            // Author: wqKang
            HBox questionBox = createQuestionBox(i + 1, equation); // Author: wqKang
            questionVBox.getChildren().add(questionBox); // Author: wqKang
        } // Author: wqKang
        // Author: wqKang
        accuracyChart.getData().clear(); // 清空准确度图表 // Author: wqKang
        // Author: wqKang
        // 清空答案输入框 // Author: wqKang
        for (TextField answerField : answerFields) { // Author: wqKang
            answerField.clear(); // Author: wqKang
        } // Author: wqKang
        // Author: wqKang
        // 创建检查按钮和结果标签 // Author: wqKang
        Button checkButton = new Button("检查"); // Author: wqKang
        Label resultLabel = new Label(); // Author: wqKang
        // Author: wqKang
        // 检查按钮事件处理 // Author: wqKang
        checkButton.setOnAction(event -> { // Author: wqKang
            int correctCount = checkAnswers(answerFields); // Author: wqKang
            resultLabel.setText("分数: " + correctCount + "/" + NUM_QUESTIONS); // Author: wqKang
            displayAccuracyChart(correctCount); // Author: wqKang
        }); // Author: wqKang
        // Author: wqKang
        // 添加控件到题目VBox // Author: wqKang
        questionVBox.getChildren().addAll(answerFields); // Author: wqKang
        questionVBox.getChildren().add(checkButton); // Author: wqKang
        questionVBox.getChildren().add(resultLabel); // Author: wqKang
        questionVBox.getChildren().add(accuracyChart); // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    // 从数据库获取最新的题目 // Author: wqKang
    private List<IEquation> getLatestQuestionsFromDatabase(int numQuestions) { // Author: wqKang
        try (Connection connection = MySQLUtil.getConnection()) { // Author: wqKang
            return MySQLUtil.getLatestEquations(connection, numQuestions); // Author: wqKang
        } catch (SQLException | ClassNotFoundException e) { // Author: wqKang
            e.printStackTrace(); // Author: wqKang
        } // Author: wqKang
        return Collections.emptyList(); // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    // 生成并显示题目 // Author: wqKang
    public void generateAndDisplayQuestions() { // Author: wqKang
        equationCollection.generate(NUM_QUESTIONS, new EquationCheckerOfRange(0, 100)); // Author: wqKang
        answerFields = new TextField[NUM_QUESTIONS]; // Author: wqKang
        // Author: wqKang
        // 清空题目VBox // Author: wqKang
        questionVBox.getChildren().clear(); // Author: wqKang
        // Author: wqKang
        // 显示题目 // Author: wqKang
        for (int i = 0; i < NUM_QUESTIONS; i++) { // Author: wqKang
            IEquation equation = equationCollection.getEquationsList().get(i); // Author: wqKang
            // Author: wqKang
            // 打印每个生成的习题到控制台 // Author: wqKang
            System.out.println("问题生成 " + (i + 1) + ": " + equation.toString()); // Author: wqKang
            // Author: wqKang
            HBox questionBox = createQuestionBox(i + 1, equation); // Author: wqKang
            questionVBox.getChildren().add(questionBox); // Author: wqKang
        } // Author: wqKang
        // Author: wqKang
        accuracyChart.getData().clear(); // 清空准确度图表 // Author: wqKang
        // Author: wqKang
        // 清空答案输入框 // Author: wqKang
        for (TextField answerField : answerFields) { // Author: wqKang
            answerField.clear(); // Author: wqKang
        } // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    // 将题目保存到数据库 // Author: wqKang
    public void saveEquationsToDatabase() { // Author: wqKang
        try (Connection connection = MySQLUtil.getConnection()) { // Author: wqKang
            for (IEquation equation : equationCollection.getEquationsList()) { // Author: wqKang
                MySQLUtil.insertEquation(connection, equation.getOperand1(), String.valueOf(equation.getOperator()), equation.getOperand2()); // Author: wqKang
            } // Author: wqKang
        } catch (SQLException | ClassNotFoundException e) { // Author: wqKang
            e.printStackTrace(); // Author: wqKang
        } // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    // Author: wqKang
    // 显示准确度图表 // Author: wqKang
    private void displayAccuracyChart(int correctCount) { // Author: wqKang
        accuracyChart.getData().clear(); // Author: wqKang
        accuracyChart.getData().add(new PieChart.Data("正确", correctCount)); // Author: wqKang
        accuracyChart.getData().add(new PieChart.Data("错误", NUM_QUESTIONS - correctCount)); // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    // 创建题目的HBox // Author: wqKang
    private HBox createQuestionBox(int questionNumber, IEquation equation) { // Author: wqKang
        Label questionLabel = new Label("问题 " + questionNumber + ": "); // Author: wqKang
        Label equationLabel = new Label(equation.toString()); // Author: wqKang
        // Author: wqKang
        HBox hbox = new HBox(); // Author: wqKang
        hbox.getChildren().addAll(questionLabel, equationLabel); // Author: wqKang
        // Author: wqKang
        // 将答案输入框添加到数组以便以后检查 // Author: wqKang
        answerFields[questionNumber - 1] = new TextField(); // Author: wqKang
        // Author: wqKang
        hbox.getChildren().add(answerFields[questionNumber - 1]); // Author: wqKang
        return hbox; // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    // 检查答案 // Author: wqKang
    private int checkAnswers(TextField[] answerFields) { // Author: wqKang
        int correctCount = 0; // Author: wqKang
        // Author: wqKang
        for (int i = 0; i < NUM_QUESTIONS; i++) { // Author: wqKang
            try { // Author: wqKang
                int userAnswer = Integer.parseInt(answerFields[i].getText()); // Author: wqKang
                int actualAnswer = equationCollection.getEquationsList().get(i).calculate(); // Author: wqKang
                // Author: wqKang
                if (userAnswer == actualAnswer) { // Author: wqKang
                    correctCount++; // Author: wqKang
                } // Author: wqKang
            } catch (NumberFormatException e) { // Author: wqKang
                // 忽略非整数输入 // Author: wqKang
            } // Author: wqKang
        } // Author: wqKang
        // Author: wqKang
        return correctCount; // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    // 检查答案并显示准确度对话框 // Author: wqKang
    private void showAccuracyDialog(int correctCount) { // Author: wqKang
        double accuracy = (double) correctCount / NUM_QUESTIONS * 100; // Author: wqKang
        // Author: wqKang
        Alert alert = new Alert(Alert.AlertType.INFORMATION); // Author: wqKang
        alert.setTitle("准确度报告"); // Author: wqKang
        alert.setHeaderText("准确度报告"); // Author: wqKang
        alert.setContentText("你正确回答了 " + correctCount + " 题，准确度为 " + accuracy + "%"); // Author: wqKang
        // Author: wqKang
        ButtonType okButton = new ButtonType("确定", ButtonBar.ButtonData.OK_DONE); // Author: wqKang
        alert.getButtonTypes().setAll(okButton); // Author: wqKang
        // Author: wqKang
        Optional<ButtonType> result = alert.showAndWait(); // Author: wqKang
        if (result.isPresent() && result.get() == ButtonType.OK) { // Author: wqKang
            // Author: wqKang
        } // Author: wqKang
    } // Author: wqKang
} // Author: wqKang
