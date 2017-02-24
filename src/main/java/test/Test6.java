package test;

/**
 * 泛型测试
 * 
 * @author liuruichao
 * Created on 2016-04-18 14:15
 */
public class Test6 {
    public static void main(String[] args) {
        // 根据该返回值推导出参数类型,进行校验,编译时擦除
        String str = test1("liuruichao");
    }

    public static <E> E test1(E e) {
        return e;
    }
}
