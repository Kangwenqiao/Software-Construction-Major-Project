package ExerciseClass; // Author: wqKang
// Author: wqKang

/**
 * // Author: wqKang
 * 范围约束算式检查器类。 // Author: wqKang
 * 实现了 EquationChecker 接口，用于检查算式的操作数和结果是否在指定范围内。 // Author: wqKang
 */ // Author: wqKang
public class EquationCheckerOfRange implements EquationChecker { // Author: wqKang
    private final int min;  // 允许的最小值 // Author: wqKang
    private final int max;  // 允许的最大值 // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 构造函数，用于初始化范围约束算式检查器的最小值和最大值。 // Author: wqKang
     * // Author: wqKang
     *
     * @param min 允许的最小值 // Author: wqKang
     * @param max 允许的最大值 // Author: wqKang
     */ // Author: wqKang
    public EquationCheckerOfRange(int min, int max) { // Author: wqKang
        this.min = min; // Author: wqKang
        this.max = max; // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 检查给定算式是否满足范围约束条件。 // Author: wqKang
     * // Author: wqKang
     *
     * @param equation 要检查的算式对象，实现了 IEquation 接口 // Author: wqKang
     * @return 如果算式的操作数和结果都在指定范围内，返回 true；否则返回 false // Author: wqKang
     */ // Author: wqKang
    @Override // Author: wqKang
    public boolean check(IEquation equation) { // Author: wqKang
        // 计算算式的结果 // Author: wqKang
        int result = equation.calculate(); // Author: wqKang
        // Author: wqKang
        // 检查操作数1、操作数2和结果是否都在指定范围内 // Author: wqKang
        return equation.getOperand1() >= min && equation.getOperand1() <= max && // Author: wqKang
                equation.getOperand2() >= min && equation.getOperand2() <= max && // Author: wqKang
                result >= min && result <= max; // Author: wqKang
    } // Author: wqKang
} // Author: wqKang
