package ExerciseClasssTest; // Author: wqKang
// Author: wqKang

import ExerciseClass.AddEquation;
import ExerciseClass.EquationChecker;
import ExerciseClass.EquationCollection;
import ExerciseClass.IEquation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

// Author: wqKang
public class EquationCollectionTest { // Author: wqKang
    // Author: wqKang
    @Test
    // Author: wqKang
    void testGenerateAndClear() { // Author: wqKang
        // 创建方程集合 // Author: wqKang
        EquationCollection equationCollection = new EquationCollection(); // Author: wqKang
        // Author: wqKang
        // 创建一个简单的约束检查器，要求结果在范围 [0, 10] 内 // Author: wqKang
        EquationChecker checker = equation -> equation.calculate() >= 0 && equation.calculate() <= 10; // Author: wqKang
        // Author: wqKang
        // 生成方程并检查是否符合约束条件 // Author: wqKang
        equationCollection.generate(5, checker); // Author: wqKang
        assertFalse(equationCollection.isEmpty(), "方程集合不应该为空"); // Author: wqKang
        // Author: wqKang
        // 清空方程集合并检查是否为空 // Author: wqKang
        equationCollection.clear(); // Author: wqKang
        assertTrue(equationCollection.isEmpty(), "方程集合应该为空"); // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    @Test
    // Author: wqKang
    void testAddAllAndGetEquationsList() { // Author: wqKang
        // 创建方程集合 // Author: wqKang
        EquationCollection equationCollection = new EquationCollection(); // Author: wqKang
        // Author: wqKang
        // 创建方程集合1 // Author: wqKang
        List<IEquation> equations1 = new ArrayList<>(); // Author: wqKang
        equations1.add(new AddEquation((short) 2, (short) 3)); // Author: wqKang
        equations1.add(new AddEquation((short) 4, (short) 5)); // Author: wqKang
        // Author: wqKang
        // 创建方程集合2 // Author: wqKang
        List<IEquation> equations2 = new ArrayList<>(); // Author: wqKang
        equations2.add(new AddEquation((short) 1, (short) 2)); // Author: wqKang
        equations2.add(new AddEquation((short) 6, (short) 7)); // Author: wqKang
        // Author: wqKang
        // 将方程集合1和方程集合2添加到方程集合 // Author: wqKang
        equationCollection.addAll(equations1); // Author: wqKang
        equationCollection.addAll(equations2); // Author: wqKang
        // Author: wqKang
        // 获取方程集合的列表形式并检查是否包含所有元素 // Author: wqKang
        List<IEquation> equationList = equationCollection.getEquationsList(); // Author: wqKang
        assertTrue(equationList.containsAll(equations1), "方程集合应该包含所有元素"); // Author: wqKang
        assertTrue(equationList.containsAll(equations2), "方程集合应该包含所有元素"); // Author: wqKang
    } // Author: wqKang

    // Author: wqKang
    @Test
    // Author: wqKang
    void testIterator() { // Author: wqKang
        // 创建方程集合 // Author: wqKang
        EquationCollection equationCollection = new EquationCollection(); // Author: wqKang
        // Author: wqKang
        // 创建方程集合 // Author: wqKang
        List<IEquation> equations = new ArrayList<>(); // Author: wqKang
        equations.add(new AddEquation((short) 2, (short) 3)); // Author: wqKang
        equations.add(new AddEquation((short) 4, (short) 5)); // Author: wqKang
        // Author: wqKang
        // 将方程集合添加到方程集合 // Author: wqKang
        equationCollection.addAll(equations); // Author: wqKang
        // Author: wqKang
        // 使用迭代器遍历方程集合并检查是否包含所有元素 // Author: wqKang
        for (IEquation equation : equationCollection) { // Author: wqKang
            assertTrue(equations.contains(equation), "方程集合应该包含所有元素"); // Author: wqKang
        } // Author: wqKang
    } // Author: wqKang
} // Author: wqKang
