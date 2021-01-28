package com.sam.resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ResourceTest {

    @Test
    public void testByteArrayResource() {
        Resource resource = new ByteArrayResource("Hello World!".getBytes());
        if(resource.exists()) {
            dumpStream(resource);
        }
    }

    private void dumpStream(Resource resource) {
        InputStream is = null;
        try {
            //1.获取文件资源
            is = resource.getInputStream();
            //2.读取资源
            byte[] descBytes = new byte[is.available()];
            is.read(descBytes);
            System.out.println(new String(descBytes));
            System.out.println(resource.getDescription());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                //3.关闭资源
                is.close();
            } catch (IOException e) {
            }
        }
    }

    @Test
    public void testInputStreamResource() {
        ByteArrayInputStream bis = new ByteArrayInputStream("Hello World!".getBytes());
        Resource resource = new InputStreamResource(bis);
        if(resource.exists()) {
            dumpStream(resource);
        }
        Assert.assertEquals(true, resource.isOpen());
    }

    @Test
    public void testFileResource() {
        File file = new File("/Users/zhanghui/Documents/aaa.txt");
        Resource resource = new FileSystemResource(file);
        if(resource.exists()) {
            dumpStream(resource);
        }
        Assert.assertEquals(false, resource.isOpen());
    }

}
