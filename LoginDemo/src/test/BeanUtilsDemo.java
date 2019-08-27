package test;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 14:30 2019/8/22
 * @Version: $
 */
public class BeanUtilsDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        User user=new User();
        //设置的是属性，不是成员变量的值
        BeanUtils.setProperty(user,"username","zhangsan");
        try {
//            获取的是属性值
             BeanUtils.getProperty(user, "username");
            System.out.println(user);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
