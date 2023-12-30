package ExerciseClasssTest; // Author: wqKang
// Author: wqKang

import ExerciseClass.AddEquation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

// Author: wqKang
public class AddEquationTest { // Author: wqKang
    // Author: wqKang
    @Test
    // Author: wqKang
    void testConstructorAndCalculate() { // Author: wqKang
        AddEquation addEquation = new AddEquation((short) 3, (short) 5); // Author: wqKang
        // Author: wqKang
        // 测试构造函数是否正确设置了操作数和操作符 // Author: wqKang
        assertEquals(3, addEquation.getOperand1(), "操作数1应该为3"); // Author: wqKang
        assertEquals(5, addEquation.getOperand2(), "操作数2应该为5"); // Author: wqKang
        assertEquals('+', addEquation.getOperator(), "操作符应该为'+'"); // Author: wqKang
        // Author: wqKang
        // 测试calculate方法是否正确计算加法结果 // Author: wqKang
        assertEquals(8, addEquation.calculate(), "3 + 5 应该等于 8"); // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    @Test
    // Author: wqKang
    void testEqualsAndHashCode() { // Author: wqKang
        AddEquation equation1 = new AddEquation((short) 3, (short) 5); // Author: wqKang
        AddEquation equation2 = new AddEquation((short) 3, (short) 5); // Author: wqKang
        AddEquation equation3 = new AddEquation((short) 4, (short) 5); // Author: wqKang
        // Author: wqKang
        // 测试相等性 // Author: wqKang
        assertEquals(equation1, equation2, "equation1 应该等于 equation2"); // Author: wqKang
        assertNotEquals(equation1, equation3, "equation1 不应该等于 equation3"); // Author: wqKang
        // Author: wqKang
        // 测试哈希码 // Author: wqKang
        assertEquals(equation1.hashCode(), equation2.hashCode(), "equation1 和 equation2 的哈希码应该相等"); // Author: wqKang
        assertNotEquals(equation1.hashCode(), equation3.hashCode(), "equation1 和 equation3 的哈希码不应该相等"); // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    @Test
    // Author: wqKang
    void testToString() { // Author: wqKang
        AddEquation equation = new AddEquation((short) 3, (short) 5); // Author: wqKang
        String expected = "3 + 5"; // Author: wqKang
        assertEquals(expected, equation.toString(), "toString 方法返回的字符串应该符合预期"); // Author: wqKang
    } // Author: wqKang
} // Author: wqKang
