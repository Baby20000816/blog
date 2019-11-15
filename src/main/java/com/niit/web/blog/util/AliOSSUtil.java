package com.niit.web.blog.util;



import com.aliyun.oss.OSSClient;

import java.io.File;
import java.util.UUID;

/**
 * @author jh_wu
 * @ClassName AliOSSUtil
 * @Description TODO
 * @Date 2019/11/6:12:23
 * @Version 1.0
 **/
public class AliOSSUtil {
    public static String ossUpload(File file){
            String bucketDomain = "https://student-managee.oss-cn-shanghai.aliyuncs.com/";
            String endpoint = "oss-cn-shanghai.aliyuncs.com";
            String accessKeyId = "LTAI4FcUiGZb75XGwiCC7Yzu";
            String accessKeySecret = "ZX0hbGsO2aOAWUfGJlrL48Tkp0bfFQ";
            String bucketName = "student-managee";
            String filedir = "img/";
            String filename = file.getName();
            String myname = "吴家浩";
        System.out.println(filename);
        String filekey = myname+filename.substring(filename.indexOf("."));
        OSSClient ossClient = new OSSClient(endpoint,accessKeyId,accessKeySecret);
        ossClient.putObject(bucketName,filedir+filekey,file);
        StringBuffer url = new StringBuffer();
        url.append(bucketDomain).append(filedir).append(filekey);
        ossClient.shutdown();
        return url.toString();
    }


    public static void main(String[] args) {
        File file = new File("D:/1.jpg");
        String url = ossUpload(file);
        System.out.println(url);
    }
}