import com.ljj.Dynamic_Proxy.Impl.AFactory;
import com.ljj.Dynamic_Proxy.Impl.BFactory;
import com.ljj.Dynamic_Proxy.ManFactory;
import com.ljj.Dynamic_Proxy.WomanFactory;
import com.ljj.Dynamic_Proxy.daigouCompany;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    @Test
    public void zhangsan(){
        AFactory aFactory = new AFactory();
        daigouCompany daigougongsi = new daigouCompany(aFactory);
        ManFactory o = (ManFactory)Proxy.newProxyInstance(AFactory.class.getClassLoader(),aFactory.getClass().getInterfaces(), daigougongsi);
        o.sale("D");
        System.out.println("-----------张三老婆的需求-----------");
        BFactory bFactory = new BFactory();
        daigougongsi.setFactory(bFactory);
        try {
            WomanFactory o2 = (WomanFactory)Proxy.newProxyInstance(Class.forName("com.ljj.Dynamic_Proxy.Impl.BFactory").getClassLoader(),bFactory.getClass().getInterfaces(), daigougongsi);
            o2.sale(180);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
