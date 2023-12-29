package ExerciseClass;
import java.util.*;

/**
 * 方程集合类，实现了 Iterable 接口，用于存储和操作 IEquation 接口的方程对象。
 */
public class EquationCollection implements Iterable<IEquation> {
    private final Set<IEquation> equationSet = new HashSet<>();

    /**
     * 生成指定数量的方程，并使用提供的 EquationChecker 进行约束检查。
     *
     * @param n       要生成的方程数量
     * @param checker 约束检查器，用于检查生成的方程是否符合特定条件
     */
    public void generate(int n, EquationChecker checker) {
        EquationFactory factory = new EquationFactory();
        Random random = new Random();

        // 循环生成方程，直到达到指定数量 n
        for (int i = 0; i < n; i++) {
            // 从工厂获取随机方程
            IEquation equation = factory.getEquationRandom();

            // 检查方程是否满足约束条件且未重复
            while (!checker.check(equation) || equationSet.contains(equation)) {
                // 如果不满足条件，重新获取随机方程
                equation = factory.getEquationRandom();
            }

            // 将满足条件的方程添加到集合中
            equationSet.add(equation);
        }
    }

    /**
     * 清空方程集合。
     */
    public void clear() {
        equationSet.clear();
    }

    /**
     * 将给定的方程集合添加到当前集合中。
     *
     * @param equations 要添加的方程集合
     */
    public void addAll(Collection<IEquation> equations) {
        equationSet.addAll(equations);
    }

    /**
     * 处理数据库异常，打印异常信息并在实际应用中可能需要显示错误消息给用户。
     *
     * @param e 异常对象
     */
    private void 处理数据库异常(Exception e) {
        e.printStackTrace();
        // 在实际应用中，可能需要处理异常，例如显示错误消息给用户
    }

    /**
     * 获取方程集合的列表形式。
     *
     * @return 包含方程集合所有元素的列表
     */
    public List<IEquation> getEquationsList() {
        return new ArrayList<>(equationSet);
    }

    /**
     * 检查方程集合是否为空。
     *
     * @return 如果方程集合为空，返回 true；否则返回 false
     */
    public boolean isEmpty() {
        return equationSet.isEmpty();
    }

    /**
     * 实现 Iterable 接口，以便使用 foreach 循环遍历方程集合。
     *
     * @return 方程集合的迭代器
     */
    @Override
    public Iterator<IEquation> iterator() {
        return equationSet.iterator();
    }
}
