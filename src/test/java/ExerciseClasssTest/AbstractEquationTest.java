package ExerciseClasssTest; // Author: wqKang
// Author: wqKang

import ExerciseClass.AbstractEquation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

// Author: wqKang
public class AbstractEquationTest { // Author: wqKang
    // Author: wqKang
    @Test
    // Author: wqKang
    void testEqualsAndHashCode() { // Author: wqKang
        AbstractEquation equation1 = new ConcreteEquation((short) 3, (short) 5, '+'); // Author: wqKang
        AbstractEquation equation2 = new ConcreteEquation((short) 3, (short) 5, '+'); // Author: wqKang
        AbstractEquation equation3 = new ConcreteEquation((short) 4, (short) 5, '+'); // Author: wqKang
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
        AbstractEquation equation = new ConcreteEquation((short) 3, (short) 5, '+'); // Author: wqKang
        String expected = "3 + 5"; // Author: wqKang
        assertEquals(expected, equation.toString(), "toString 方法返回的字符串应该符合预期"); // Author: wqKang
    } // Author: wqKang
} // Author: wqKang
