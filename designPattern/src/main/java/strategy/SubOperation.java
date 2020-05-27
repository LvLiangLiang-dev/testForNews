package strategy;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2019-03-08 下午5:16
 */
public class SubOperation implements Strategy {
    @Override
    public int Operation(int num1, int num2) {
        return num1-num2;
    }
}
