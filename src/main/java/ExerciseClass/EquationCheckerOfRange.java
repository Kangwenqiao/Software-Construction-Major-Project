package ExerciseClass;

/**
 * 范围约束算式检查器类。
 * 实现了 EquationChecker 接口，用于检查算式的操作数和结果是否在指定范围内。
 */
public class EquationCheckerOfRange implements EquationChecker {
    private int min;  // 允许的最小值
    private int max;  // 允许的最大值

    /**
     * 构造函数，用于初始化范围约束算式检查器的最小值和最大值。
     *
     * @param min 允许的最小值
     * @param max 允许的最大值
     */
    public EquationCheckerOfRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    /**
     * 检查给定算式是否满足范围约束条件。
     *
     * @param equation 要检查的算式对象，实现了 IEquation 接口
     * @return 如果算式的操作数和结果都在指定范围内，返回 true；否则返回 false
     */
    @Override
    public boolean check(IEquation equation) {
        // 计算算式的结果
        int result = equation.calculate();

        // 检查操作数1、操作数2和结果是否都在指定范围内
        return equation.getOperand1() >= min && equation.getOperand1() <= max &&
                equation.getOperand2() >= min && equation.getOperand2() <= max &&
                result >= min && result <= max;
    }
}
