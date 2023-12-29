package ExerciseClasssTest;

import ExerciseClass.AddEquation;
import ExerciseClass.EquationCheckerOfRange;
import ExerciseClass.IEquation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EquationCheckerOfRangeTest {

    @Test
    void testCheck() {
        // 创建一个范围约束算式检查器，设置允许的最小值和最大值
        EquationCheckerOfRange checker = new EquationCheckerOfRange(0, 10);

        // 创建一个算式对象，操作数和结果都在指定范围内
        IEquation validEquation = new AddEquation((short) 3, (short) 5);

        // 创建一个算式对象，操作数和结果有一个不在指定范围内
        IEquation invalidEquation = new AddEquation((short) 7, (short) 5);

        // 测试算式检查器是否正确检查范围约束
        assertTrue(checker.check(validEquation), "validEquation 应该符合范围约束");
        assertFalse(checker.check(invalidEquation), "invalidEquation 不应该符合范围约束");
    }
}
