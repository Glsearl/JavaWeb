package web.proxy;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 16:05 2019/10/12
 * @Version: $
 */
public class Dell implements SaleComputer{
    @Override
    public String sale(double money) {
        System.out.println("花了"+money+"买了一台电脑");
        return "Dell电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑。。。");
    }
}
