package Util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class IOTest {


    /**
     * 读取文件中的数据转成String
     * 将String写入到文件中
     * @throws IOException
     */
    @Test
    public void IOTest1() throws IOException {

        String path="C:\\Users\\HP\\Desktop\\安全\\紧急任务.txt";
        String string = FileUtils.readFileToString(new File(path), "utf-8");
        System.out.println(string);

        String data="设计方式家里的饭加啥六道街坊四邻可点击分离框架";
        FileUtils.writeStringToFile(new File(path),data,"utf-8",true);


        List<String> list = Arrays.asList("1", "2", "第三方士大夫", "胜多负少的");
        FileUtils.writeLines(new File(path),"utf-8",list,true);


        /**'
         * 指定打开一个文件将要写入数据,
         *   1 如果文件不存在会创建文件
         *   2 如果文件目录不存在会创建文件目录
         *   3 如果文件不能打开会抛出异常
         *
         */
        FileOutputStream fileOutputStream = FileUtils.openOutputStream(new File(path + "t"), true);

 
    }

    /**
     *
     * 获取文件 名称 /后缀
     * @throws IOException
     */
    @Test
    public void IOTest2() throws IOException {

        String path="C:\\Users\\HP\\Desktop\\安全\\紧急任务.txt";

        System.out.println("文件名称:"+FilenameUtils.getBaseName(path));
        System.out.println("文件后缀:"+FilenameUtils.getExtension(path));
    }
}
