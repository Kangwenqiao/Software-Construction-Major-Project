package ExerciseClasssTest; // Author: wqKang
// Author: wqKang

import ExerciseClass.*;
import org.testng.annotations.Test;

// Author: wqKang
public class IntegrationTest { // Author: wqKang
    // Author: wqKang
    @Test // Author: wqKang
    public void testEquationIntegration() { // Author: wqKang
        // 创建范围方程检查器，限制范围在0到100之间 // Author: wqKang
        EquationChecker checker = new EquationCheckerOfRange(0, 100); // Author: wqKang
        // Author: wqKang
        // 创建方程集合 // Author: wqKang
        EquationCollection equationCollection = new EquationCollection(); // Author: wqKang
        // Author: wqKang
        // 创建方程工厂 // Author: wqKang
        EquationFactory equationFactory = new EquationFactory(); // Author: wqKang
        // Author: wqKang
        // 生成10个方程并添加到方程集合，同时进行范围检查 // Author: wqKang
        equationCollection.generate(10, checker); // Author: wqKang
        // Author: wqKang
        // 打印生成的方程 // Author: wqKang
        for (IEquation equation : equationCollection) { // Author: wqKang
            System.out.println("Generated Equation: " + equation.toString()); // Author: wqKang
        } // Author: wqKang
        // Author: wqKang
        // 清空方程集合 // Author: wqKang
        equationCollection.clear(); // Author: wqKang
        // Author: wqKang
        // 从方程工厂获取随机方程 // Author: wqKang
        IEquation randomEquation = equationFactory.getEquationRandom(); // Author: wqKang
        // Author: wqKang
        // 打印随机生成的方程 // Author: wqKang
        System.out.println("Random Equation: " + randomEquation.toString()); // Author: wqKang
        // Author: wqKang
        // 创建加法方程 // Author: wqKang
        IEquation addEquation = new AddEquation((short) 5, (short) 10); // Author: wqKang
        // Author: wqKang
        // 打印加法方程 // Author: wqKang
        System.out.println("Add Equation: " + addEquation); // Author: wqKang
        // Author: wqKang
        // 创建减法方程 // Author: wqKang
        IEquation subEquation = new SubEquation((short) 8, (short) 3); // Author: wqKang
        // Author: wqKang
        // 打印减法方程 // Author: wqKang
        System.out.println("Sub Equation: " + subEquation); // Author: wqKang
        // Author: wqKang
        // 使用方程集合的迭代器遍历方程 // Author: wqKang
        for (IEquation equation : equationCollection) { // Author: wqKang
            System.out.println("Equation from Collection: " + equation.toString()); // Author: wqKang
        } // Author: wqKang
    } // Author: wqKang
} // Author: wqKang
