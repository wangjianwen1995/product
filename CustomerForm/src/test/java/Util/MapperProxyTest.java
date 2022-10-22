package Util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***
 * key 这里需要放到对映的包下面 从其他地方拿过来的,懒的调整了
 *
 */
public class MapperProxyTest {

    public static void main(String[] args) {
        try {
            Handler handler = new Handler();
            Class<?> interfaceClass = Class.forName("com.sxdl.drplus.test.testI");
            Object obj = Proxy.newProxyInstance(MapperProxyTest.class.getClassLoader(), new Class[]{interfaceClass}, handler);
            Method mainMethod = interfaceClass.getDeclaredMethod("say",String.class);
            Object invoke = mainMethod.invoke(obj,"哈哈啊哈");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
class Handler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(args[0]+"callBack .. sayHello...动态代理（接口没有实现类，使用JDK动态代理实现接口方法）");
        return null;
    }
}
interface testI{
    void say(String s);
}


