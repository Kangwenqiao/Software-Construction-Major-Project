package ExerciseClasssTest;

import ExerciseClass.*;
import org.testng.annotations.Test;

public class IntegrationTest {

    @Test
    public void testEquationIntegration() {
        // 创建范围方程检查器，限制范围在0到100之间
        EquationChecker checker = new EquationCheckerOfRange(0, 100);

        // 创建方程集合
        EquationCollection equationCollection = new EquationCollection();

        // 创建方程工厂
        EquationFactory equationFactory = new EquationFactory();

        // 生成10个方程并添加到方程集合，同时进行范围检查
        equationCollection.generate(10, checker);

        // 打印生成的方程
        for (IEquation equation : equationCollection) {
            System.out.println("Generated Equation: " + equation.toString());
        }

        // 清空方程集合
        equationCollection.clear();

        // 从方程工厂获取随机方程
        IEquation randomEquation = equationFactory.getEquationRandom();

        // 打印随机生成的方程
        System.out.println("Random Equation: " + randomEquation.toString());

        // 创建加法方程
        IEquation addEquation = new AddEquation((short) 5, (short) 10);

        // 打印加法方程
        System.out.println("Add Equation: " + addEquation.toString());

        // 创建减法方程
        IEquation subEquation = new SubEquation((short) 8, (short) 3);

        // 打印减法方程
        System.out.println("Sub Equation: " + subEquation.toString());

        // 使用方程集合的迭代器遍历方程
        for (IEquation equation : equationCollection) {
            System.out.println("Equation from Collection: " + equation.toString());
        }
    }
}
