package com.heqin.proxy.jdk;

import java.io.File;
import java.io.FileOutputStream;

import com.heqin.proxy.UserDao;
import org.junit.Test;
import sun.misc.ProxyGenerator;

public class AopTest {

    @Test
    public void jdkProxy() throws Exception {
        byte[] bytes = ProxyGenerator.generateProxyClass("JDKProxyUserDao", new Class[]{UserDao.class});
        FileOutputStream outputStream = new FileOutputStream(new File("E:\\proxy\\jdk\\JDKProxyUserDao.class"));
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }

}
