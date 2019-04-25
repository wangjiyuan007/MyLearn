package MyLearn.Demo;


import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: SQLConvert
 * @Description: SQLServer转Postgre
 * @Company: www.leador.com.cn
 * @Date: 2019-04-25 10:40
 * @author: wangjiyuan
 * @Version: 1.0
 **/

public class SQLConvert {
    public static void main(String[] args) throws Exception{
        String inputfile = "E:\\WJY\\HAD\\高精度编译-sql2008转postgres脚本\\post_sql2008_ziyan2.txt";
        String outputfile = "E:\\WJY\\HAD\\高精度编译-sql2008转postgres脚本\\post_sql2008_ziyan2_convert.txt";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(inputfile),"GBK");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String lineSql = null;
        List<String> list = new ArrayList<>();

        while ((lineSql = bufferedReader.readLine()) != null){
            String[] arr = lineSql.split(" ");
            if (arr[0].toString().equals("create")){
                arr[2] = "\"" + arr[2] + "\"";
                String str = StringUtils.join(arr," ");
                list.add(str);
                System.out.println(str);
            }else if (arr[0].toString().equals("alter")){
                arr[2] = "\"" + arr[2] + "\"";
                String str = StringUtils.join(arr," ");
                list.add(str);
                System.out.println(str);
            }else if (arr[0].toString().equals("/*==============================================================*/") ||
                    arr[0].toString().equals("/*") ||
                    arr[0].toString().equals(");") ||
                    arr[0].toString().equals(null)){
                String str = StringUtils.join(arr," ");
                list.add(str);
                System.out.println(str);
            }else if (arr[0].toString().equals("")){
                if (arr.length>1){
                    if (!arr[3].toString().equals("add")){
                        arr[3] = "\"" + arr[3].toUpperCase() + "\"";
                        if (arr[3].toString().equals("\"SHAPE\"")){
                            arr[19] = "Geometry";
                        }
                        String str = StringUtils.join(arr," ");
                        list.add(str);
                        System.out.println(str);
                    }else if (arr[3].toString().equals("add")){
                        arr[8] = "("+"\"" + arr[8].substring(1,arr[8].length()-2).toUpperCase() + "\"" + ");";
                        String str = StringUtils.join(arr," ");
                        list.add(str);
                        System.out.println(str);
                    }else {
                        String str = StringUtils.join(arr," ");
                        list.add(str);
                        System.out.println(str);
                    }
                }else {
                    String str = StringUtils.join(arr," ");
                    list.add(str);
                    System.out.println(str);
                }

            }

        }
        File file = new File(outputfile);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (String l : list){
            bufferedWriter.write(l + "\r\n");
        }
        bufferedWriter.close();
    }
}
