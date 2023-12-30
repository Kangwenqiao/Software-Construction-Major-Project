package ExerciseClass; // Author: wqKang
// Author: wqKang

/**
 * // Author: wqKang
 * 加法算式类，继承自抽象算式类 AbstractEquation。 // Author: wqKang
 */ // Author: wqKang
public class AddEquation extends AbstractEquation { // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 构造函数，用于初始化加法算式的操作数和操作符。 // Author: wqKang
     * // Author: wqKang
     *
     * @param operand1 第一个操作数 // Author: wqKang
     * @param operand2 第二个操作数 // Author: wqKang
     */ // Author: wqKang
    public AddEquation(short operand1, short operand2) { // Author: wqKang
        // 调用父类构造函数，设置操作数和操作符 // Author: wqKang
        super(operand1, operand2, '+'); // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 计算并返回加法算式的结果。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 加法算式的计算结果 // Author: wqKang
     */ // Author: wqKang
    @Override // Author: wqKang
    public int calculate() { // Author: wqKang
        // 返回操作数1和操作数2的和 // Author: wqKang
        return getOperand1() + getOperand2(); // Author: wqKang
    } // Author: wqKang
} // Author: wqKang
