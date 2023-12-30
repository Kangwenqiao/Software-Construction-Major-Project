package ExerciseClass; // Author: wqKang

import java.util.*;
// Author: wqKang

/**
 * // Author: wqKang
 * 方程集合类，实现了 Iterable 接口，用于存储和操作 IEquation 接口的方程对象。 // Author: wqKang
 */ // Author: wqKang
public class EquationCollection implements Iterable<IEquation> { // Author: wqKang
    private final Set<IEquation> equationSet = new HashSet<>(); // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 生成指定数量的方程，并使用提供的 EquationChecker 进行约束检查。 // Author: wqKang
     * // Author: wqKang
     *
     * @param n       要生成的方程数量 // Author: wqKang
     * @param checker 约束检查器，用于检查生成的方程是否符合特定条件 // Author: wqKang
     */ // Author: wqKang
    public void generate(int n, EquationChecker checker) { // Author: wqKang
        EquationFactory factory = new EquationFactory(); // Author: wqKang
        Random random = new Random(); // Author: wqKang
        // Author: wqKang
        // 循环生成方程，直到达到指定数量 n // Author: wqKang
        for (int i = 0; i < n; i++) { // Author: wqKang
            // 从工厂获取随机方程 // Author: wqKang
            IEquation equation = factory.getEquationRandom(); // Author: wqKang
            // Author: wqKang
            // 检查方程是否满足约束条件且未重复 // Author: wqKang
            while (!checker.check(equation) || equationSet.contains(equation)) { // Author: wqKang
                // 如果不满足条件，重新获取随机方程 // Author: wqKang
                equation = factory.getEquationRandom(); // Author: wqKang
            } // Author: wqKang
            // Author: wqKang
            // 将满足条件的方程添加到集合中 // Author: wqKang
            equationSet.add(equation); // Author: wqKang
        } // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 清空方程集合。 // Author: wqKang
     */ // Author: wqKang
    public void clear() { // Author: wqKang
        equationSet.clear(); // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 将给定的方程集合添加到当前集合中。 // Author: wqKang
     * // Author: wqKang
     *
     * @param equations 要添加的方程集合 // Author: wqKang
     */ // Author: wqKang
    public void addAll(Collection<IEquation> equations) { // Author: wqKang
        equationSet.addAll(equations); // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 处理数据库异常，打印异常信息并在实际应用中可能需要显示错误消息给用户。 // Author: wqKang
     * // Author: wqKang
     *
     * @param e 异常对象 // Author: wqKang
     */ // Author: wqKang
    private void 处理数据库异常(Exception e) { // Author: wqKang
        e.printStackTrace(); // Author: wqKang
        // 在实际应用中，可能需要处理异常，例如显示错误消息给用户 // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 获取方程集合的列表形式。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 包含方程集合所有元素的列表 // Author: wqKang
     */ // Author: wqKang
    public List<IEquation> getEquationsList() { // Author: wqKang
        return new ArrayList<>(equationSet); // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 检查方程集合是否为空。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 如果方程集合为空，返回 true；否则返回 false // Author: wqKang
     */ // Author: wqKang
    public boolean isEmpty() { // Author: wqKang
        return equationSet.isEmpty(); // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 实现 Iterable 接口，以便使用 foreach 循环遍历方程集合。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 方程集合的迭代器 // Author: wqKang
     */ // Author: wqKang
    @Override // Author: wqKang
    public Iterator<IEquation> iterator() { // Author: wqKang
        return equationSet.iterator(); // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 获取方程集合的大小。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 方程集合的大小 // Author: wqKang
     */ // Author: wqKang
    public int size() { // Author: wqKang
        return equationSet.size(); // Author: wqKang
    } // Author: wqKang
    // Author: wqKang
} // Author: wqKang
