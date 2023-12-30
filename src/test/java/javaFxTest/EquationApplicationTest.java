package javaFxTest;

import javafx.EquationApplication;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

public class EquationApplicationTest {

    @Start
    public void start(Stage stage) {
        new EquationApplication().start(stage);
    }

    @BeforeEach
    public void setUp() throws Exception {
        // 设置已经由 @Start 方法处理
    }

    @Test
    public void testUIInteraction(FxRobot robot) {
        // 模拟用户与 UI 的交互
        robot.clickOn("#generateMenuItem");

        robot.clickOn("#checkButton");

        // 验证 UI 元素的状态
        verifyThat("#resultLabel", hasText("分数: 1/5"));
    }

    @Test
    public void testSaveEquationsToDatabase(FxRobot robot) {
        // 模拟用户与 UI 的交互
        robot.clickOn("#saveMenuItem");

        // 验证保存到数据库的操作是否成功
        // 这可能涉及到检查数据库中是否有新的题目被保存
    }

    @Test
    public void testLoadAndDisplayDatabaseQuestions(FxRobot robot) {
        // 模拟用户与 UI 的交互
        robot.clickOn("#loadMenuItem");

        // 验证从数据库加载并显示题目的操作是否成功
        // 可能涉及到检查 UI 中是否显示了新加载的题目
    }

    // 添加更多的测试用例，测试其他功能和交互
}
