package ExerciseClasssTest;

import ExerciseClass.AddEquation;
import ExerciseClass.EquationChecker;
import ExerciseClass.EquationCollection;
import ExerciseClass.IEquation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EquationCollectionTest {

    @Test
    void testGenerateAndClear() {
        // 创建方程集合
        EquationCollection equationCollection = new EquationCollection();

        // 创建一个简单的约束检查器，要求结果在范围 [0, 10] 内
        EquationChecker checker = equation -> equation.calculate() >= 0 && equation.calculate() <= 10;

        // 生成方程并检查是否符合约束条件
        equationCollection.generate(5, checker);
        assertFalse(equationCollection.isEmpty(), "方程集合不应该为空");

        // 清空方程集合并检查是否为空
        equationCollection.clear();
        assertTrue(equationCollection.isEmpty(), "方程集合应该为空");
    }

    @Test
    void testAddAllAndGetEquationsList() {
        // 创建方程集合
        EquationCollection equationCollection = new EquationCollection();

        // 创建方程集合1
        List<IEquation> equations1 = new ArrayList<>();
        equations1.add(new AddEquation((short) 2, (short) 3));
        equations1.add(new AddEquation((short) 4, (short) 5));

        // 创建方程集合2
        List<IEquation> equations2 = new ArrayList<>();
        equations2.add(new AddEquation((short) 1, (short) 2));
        equations2.add(new AddEquation((short) 6, (short) 7));

        // 将方程集合1和方程集合2添加到方程集合
        equationCollection.addAll(equations1);
        equationCollection.addAll(equations2);

        // 获取方程集合的列表形式并检查是否包含所有元素
        List<IEquation> equationList = equationCollection.getEquationsList();
        assertTrue(equationList.containsAll(equations1), "方程集合应该包含所有元素");
        assertTrue(equationList.containsAll(equations2), "方程集合应该包含所有元素");
    }

    @Test
    void testIterator() {
        // 创建方程集合
        EquationCollection equationCollection = new EquationCollection();

        // 创建方程集合
        List<IEquation> equations = new ArrayList<>();
        equations.add(new AddEquation((short) 2, (short) 3));
        equations.add(new AddEquation((short) 4, (short) 5));

        // 将方程集合添加到方程集合
        equationCollection.addAll(equations);

        // 使用迭代器遍历方程集合并检查是否包含所有元素
        for (IEquation equation : equationCollection) {
            assertTrue(equations.contains(equation), "方程集合应该包含所有元素");
        }
    }
}
