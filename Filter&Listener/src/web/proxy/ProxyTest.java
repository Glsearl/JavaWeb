package web.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 16:17 2019/10/12
 * @Version: $
 */
public class ProxyTest {
    public static void main(String[] args) {
        //1.创建真实对象
        Dell dell=new Dell();

        //2.动态代理增强Dell对象
        /*
            三个参数：
                1. 类加载器：真实对象.getClass().getClassLoader()
                2. 接口数组：真实对象.getClass().getInterfaces()
                3. 处理器：new InvocationHandler()
         */
        SaleComputer proxy_dell = (SaleComputer) Proxy.newProxyInstance(dell.getClass().getClassLoader(), dell.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                 /*
                代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
                    参数：
                        1. proxy:代理对象
                        2. method：代理对象调用的方法，被封装为的对象
                        3. args:代理对象调用的方法时，传递的实际参数
             */
//                System.out.println("该方法执行了");
//                System.out.println(method.getName());
//                System.out.println(args[0]);
                if (method.getName().equals("sale")){
                    //1.增强参数
                  double money = (double) args[0];
                  money=money*0.8;
                  //增强方法体执行逻辑
                    System.out.println("满100包邮。。。");
                    String obj = (String) method.invoke(dell, money);
                    System.out.println("享受VIP待遇....");
                    //返回值增强
                    return obj+"送鼠标垫";
                }else {
                    String obj = (String) method.invoke(dell, args);
                    return obj;
                }

            }
        });
        //调用方法
        String sale = proxy_dell.sale(8000);
        System.out.println(sale);


        //proxy_dell.show();
    }

}
