package tool;

import lombok.extern.slf4j.Slf4j;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2020/5/18.
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            PropertyUtils propertyUtils = new PropertyUtils();
            Class action = Class.forName(PropertyUtils.getStringValue("className", ""));
            Action o = (Action) action.newInstance();
            o.action();
            log.info("action name:{}, atcion is over", o.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
