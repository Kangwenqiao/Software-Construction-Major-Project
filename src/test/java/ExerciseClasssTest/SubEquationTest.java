package ExerciseClasssTest; // Author: wqKang
// Author: wqKang

import ExerciseClass.SubEquation;
import org.junit.jupiter.api.Test;

// Author: wqKang
public class SubEquationTest { // Author: wqKang
    // Author: wqKang
    @Test
    // Author: wqKang
    void testConstructorAndCalculate() { // Author: wqKang
        // 创建减法算式对象 // Author: wqKang
        SubEquation subEquation = new SubEquation((short) 5, (short) 3); // Author: wqKang
        // Author: wqKang
        // 测试构造函数是否正确设置了操作数和操作符 // Author: wqKang
        assertEquals(5, subEquation.getOperand1(), "操作数1应该为5"); // Author: wqKang
        assertEquals(3, subEquation.getOperand2(), "操作数2应该为3"); // Author: wqKang
        assertEquals('-', subEquation.getOperator(), "操作符应该为'-'"); // Author: wqKang
        // Author: wqKang
        // 测试calculate方法是否正确计算减法结果 // Author: wqKang
        assertEquals(2, subEquation.calculate(), "5 - 3 应该等于 2"); // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    @Test
    // Author: wqKang
    void testEqualsAndHashCode() { // Author: wqKang
        SubEquation equation1 = new SubEquation((short) 5, (short) 3); // Author: wqKang
        SubEquation equation2 = new SubEquation((short) 5, (short) 3); // Author: wqKang
        SubEquation equation3 = new SubEquation((short) 4, (short) 3); // Author: wqKang
        // Author: wqKang
        // 测试相等性 // Author: wqKang
        assertEquals(equation1, equation2, "equation1 应该等于 equation2"); // Author: wqKang
        assertEquals(equation2, equation1, "equation2 应该等于 equation1"); // Author: wqKang
        assertNotEquals(equation1, equation3, "equation1 不应该等于 equation3"); // Author: wqKang
        assertNotEquals(equation2, equation3, "equation2 不应该等于 equation3"); // Author: wqKang
        // Author: wqKang
        // 测试哈希码 // Author: wqKang
        assertEquals(equation1.hashCode(), equation2.hashCode(), "equation1 和 equation2 的哈希码应该相等"); // Author: wqKang
        assertNotEquals(equation1.hashCode(), equation3.hashCode(), "equation1 和 equation3 的哈希码不应该相等"); // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    @Test
    // Author: wqKang
    void testToString() { // Author: wqKang
        SubEquation equation = new SubEquation((short) 5, (short) 3); // Author: wqKang
        String expected = "5 - 3"; // Author: wqKang
        assertEquals(expected, equation.toString(), "toString 方法返回的字符串应该符合预期"); // Author: wqKang
    } // Author: wqKang
} // Author: wqKang
