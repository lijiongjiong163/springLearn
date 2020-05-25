import com.ljj.Dynamic_Proxy.Impl.AFactory;
import com.ljj.Dynamic_Proxy.ManFactory;
import com.ljj.Dynamic_Proxy.daigou;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    @Test
    public void zhangsan(){
        AFactory aFactory = new AFactory();
        ManFactory o = (ManFactory)Proxy.newProxyInstance(AFactory.class.getClassLoader(),aFactory.getClass().getInterfaces(), new daigou(aFactory));
        o.sale("D");

    }
}
