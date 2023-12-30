package ExerciseClasssTest; // Author: wqKang
// Author: wqKang

import ExerciseClass.AddEquation;
import ExerciseClass.EquationCheckerOfRange;
import ExerciseClass.IEquation;
import org.junit.jupiter.api.Test;

// Author: wqKang
public class EquationCheckerOfRangeTest { // Author: wqKang
    // Author: wqKang
    @Test
    // Author: wqKang
    void testCheck() { // Author: wqKang
        // 创建一个范围约束算式检查器，设置允许的最小值和最大值 // Author: wqKang
        EquationCheckerOfRange checker = new EquationCheckerOfRange(0, 10); // Author: wqKang
        // Author: wqKang
        // 创建一个算式对象，操作数和结果都在指定范围内 // Author: wqKang
        IEquation validEquation = new AddEquation((short) 3, (short) 5); // Author: wqKang
        // Author: wqKang
        // 创建一个算式对象，操作数和结果有一个不在指定范围内 // Author: wqKang
        IEquation invalidEquation = new AddEquation((short) 7, (short) 5); // Author: wqKang
        // Author: wqKang
        // 测试算式检查器是否正确检查范围约束 // Author: wqKang
        assertTrue(checker.check(validEquation), "validEquation 应该符合范围约束"); // Author: wqKang
        assertFalse(checker.check(invalidEquation), "invalidEquation 不应该符合范围约束"); // Author: wqKang
    } // Author: wqKang
} // Author: wqKang
