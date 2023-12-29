package javafx;

import ExerciseClass.EquationCheckerOfRange;
import ExerciseClass.EquationCollection;
import ExerciseClass.IEquation;
import Mysql.MySQLUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * JavaFX 应用程序类，用于生成口算习题并进行用户交互。
 */
public class EquationApplication extends Application {
    private static final int NUM_QUESTIONS = 5;
    private EquationCollection equationCollection;
    private VBox questionVBox;
    private TextField[] answerFields;
    private PieChart accuracyChart;

    @Override
    public void start(Stage stage) {
        // 初始化算式集合
        equationCollection = new EquationCollection();

        // 菜单
        MenuItem generateMenuItem = new MenuItem("生成习题");
        MenuItem saveMenuItem = new MenuItem("保存习题");
        MenuItem loadMenuItem = new MenuItem("读取习题");
        MenuItem checkMenuItem = new MenuItem("检查习题");

        // 菜单项事件处理
        generateMenuItem.setOnAction(event -> {
            // 生成并展示新的习题
            initializeUI();
        });

        loadMenuItem.setOnAction(event -> {
            // 从数据库加载并展示最新的五道题目
            loadAndDisplayDatabaseQuestions();
        });

        // 保存习题菜单项事件处理
        saveMenuItem.setOnAction(event -> saveEquationsToDatabase());

        // 检查习题菜单项事件处理
        checkMenuItem.setOnAction(event -> {
            // 检查答案并显示准确度对话框
            int correctCount = checkAnswers(answerFields);
            showAccuracyDialog(correctCount);
        });

        Menu fileMenu = new Menu("文件");
        fileMenu.getItems().addAll(generateMenuItem, saveMenuItem, loadMenuItem, checkMenuItem);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);

        // 控件
        questionVBox = new VBox();
        questionVBox.setSpacing(10);
        questionVBox.setPadding(new Insets(20));

        answerFields = new TextField[NUM_QUESTIONS];
        accuracyChart = new PieChart(); // 创建新的 PieChart 实例

        // 初始化 UI
        initializeUI();

        // 布局
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(questionVBox);

        // 场景和舞台
        Scene scene = new Scene(borderPane, 800, 640);
        stage.setTitle("口算习题薄");
        stage.setScene(scene);
        stage.show();
    }

    // 初始化用户界面
    private void initializeUI() {
        // 清空现有题目VBox的内容
        questionVBox.getChildren().clear();

        // 生成并显示题目
        generateAndDisplayQuestions();

        // 创建检查按钮和结果标签
        Button checkButton = new Button("检查");
        Label resultLabel = new Label();

        // 检查按钮事件处理
        checkButton.setOnAction(event -> {
            int correctCount = checkAnswers(answerFields);
            resultLabel.setText("分数: " + correctCount + "/" + NUM_QUESTIONS);
            displayAccuracyChart(correctCount);
        });

        // 添加控件到题目VBox
        questionVBox.getChildren().addAll(answerFields);
        questionVBox.getChildren().add(checkButton);
        questionVBox.getChildren().add(resultLabel);
        questionVBox.getChildren().add(accuracyChart);
    }

    // 从数据库加载并显示题目
    private void loadAndDisplayDatabaseQuestions() {
        // 清空现有题目VBox的内容
        questionVBox.getChildren().clear();

        // 从数据库获取最新的题目
        List<IEquation> latestQuestions = getLatestQuestionsFromDatabase(NUM_QUESTIONS);
        equationCollection.clear(); // 清空现有的题目
        equationCollection.addAll(latestQuestions); // 添加最新的题目
        answerFields = new TextField[NUM_QUESTIONS];

        // 显示题目
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            IEquation equation = equationCollection.getEquationsList().get(i);

            // 打印每个生成的习题到控制台
            System.out.println("问题读取 " + (i + 1) + ": " + equation.toString());

            HBox questionBox = createQuestionBox(i + 1, equation);
            questionVBox.getChildren().add(questionBox);
        }

        accuracyChart.getData().clear(); // 清空准确度图表

        // 清空答案输入框
        for (TextField answerField : answerFields) {
            answerField.clear();
        }

        // 创建检查按钮和结果标签
        Button checkButton = new Button("检查");
        Label resultLabel = new Label();

        // 检查按钮事件处理
        checkButton.setOnAction(event -> {
            int correctCount = checkAnswers(answerFields);
            resultLabel.setText("分数: " + correctCount + "/" + NUM_QUESTIONS);
            displayAccuracyChart(correctCount);
        });

        // 添加控件到题目VBox
        questionVBox.getChildren().addAll(answerFields);
        questionVBox.getChildren().add(checkButton);
        questionVBox.getChildren().add(resultLabel);
        questionVBox.getChildren().add(accuracyChart);
    }

    // 从数据库获取最新的题目
    private List<IEquation> getLatestQuestionsFromDatabase(int numQuestions) {
        try (Connection connection = MySQLUtil.getConnection()) {
            return MySQLUtil.getLatestEquations(connection, numQuestions);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    // 生成并显示题目
    private void generateAndDisplayQuestions() {
        equationCollection.generate(NUM_QUESTIONS, new EquationCheckerOfRange(0, 100));
        answerFields = new TextField[NUM_QUESTIONS];

        // 清空题目VBox
        questionVBox.getChildren().clear();

        // 显示题目
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            IEquation equation = equationCollection.getEquationsList().get(i);

            // 打印每个生成的习题到控制台
            System.out.println("问题生成 " + (i + 1) + ": " + equation.toString());

            HBox questionBox = createQuestionBox(i + 1, equation);
            questionVBox.getChildren().add(questionBox);
        }

        accuracyChart.getData().clear(); // 清空准确度图表

        // 清空答案输入框
        for (TextField answerField : answerFields) {
            answerField.clear();
        }
    }

    // 将题目保存到数据库
    private void saveEquationsToDatabase() {
        try (Connection connection = MySQLUtil.getConnection()) {
            for (IEquation equation : equationCollection.getEquationsList()) {
                MySQLUtil.insertEquation(connection, equation.getOperand1(), String.valueOf(equation.getOperator()), equation.getOperand2());
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 检查答案并显示准确度图表
    private void checkAnswersAndDisplayChart() {
        int correctCount = checkAnswers(answerFields);
        displayAccuracyChart(correctCount);
    }

    // 显示准确度图表
    private void displayAccuracyChart(int correctCount) {
        accuracyChart.getData().clear();
        accuracyChart.getData().add(new PieChart.Data("正确", correctCount));
        accuracyChart.getData().add(new PieChart.Data("错误", NUM_QUESTIONS - correctCount));
    }

    // 创建题目的HBox
    private HBox createQuestionBox(int questionNumber, IEquation equation) {
        Label questionLabel = new Label("问题 " + questionNumber + ": ");
        Label equationLabel = new Label(equation.toString());

        HBox hbox = new HBox();
        hbox.getChildren().addAll(questionLabel, equationLabel);

        // 将答案输入框添加到数组以便以后检查
        answerFields[questionNumber - 1] = new TextField();

        hbox.getChildren().add(answerFields[questionNumber - 1]);
        return hbox;
    }

    // 检查答案
    private int checkAnswers(TextField[] answerFields) {
        int correctCount = 0;

        for (int i = 0; i < NUM_QUESTIONS; i++) {
            try {
                int userAnswer = Integer.parseInt(answerFields[i].getText());
                int actualAnswer = equationCollection.getEquationsList().get(i).calculate();

                if (userAnswer == actualAnswer) {
                    correctCount++;
                }
            } catch (NumberFormatException e) {
                // 忽略非整数输入
            }
        }

        return correctCount;
    }

    // 检查答案并显示准确度对话框
    private void showAccuracyDialog(int correctCount) {
        double accuracy = (double) correctCount / NUM_QUESTIONS * 100;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("准确度报告");
        alert.setHeaderText("准确度报告");
        alert.setContentText("你正确回答了 " + correctCount + " 题，准确度为 " + accuracy + "%");

        ButtonType okButton = new ButtonType("确定", ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(okButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // 用户点击了确定按钮
            // 可以添加处理逻辑，如果需要的话
        }
    }

    public static void main(String[] args) {
        launch();
    }
}