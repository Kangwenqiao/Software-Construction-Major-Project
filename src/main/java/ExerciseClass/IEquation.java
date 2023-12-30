package ExerciseClass; // Author: wqKang
// Author: wqKang

/**
 * // Author: wqKang
 * 算式接口，定义了表示数学算式的方法。 // Author: wqKang
 */ // Author: wqKang
public interface IEquation { // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 获取算式的第一个操作数。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 第一个操作数 // Author: wqKang
     */ // Author: wqKang
    short getOperand1(); // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 获取算式的第二个操作数。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 第二个操作数 // Author: wqKang
     */ // Author: wqKang
    short getOperand2(); // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 获取算式的操作符。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 操作符 // Author: wqKang
     */ // Author: wqKang
    char getOperator(); // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 计算并返回算式的结果。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 算式的计算结果 // Author: wqKang
     */ // Author: wqKang
    int calculate(); // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 返回算式的字符串表示形式。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 字符串表示形式 // Author: wqKang
     */ // Author: wqKang
    String toString(); // Author: wqKang
} // Author: wqKang
