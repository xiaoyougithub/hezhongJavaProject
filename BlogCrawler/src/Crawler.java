import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
 
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
 
public class Crawler {
    //根据url从网络获取网页文本
    public Document getHtmlTextByUrl(String url) {
        /*
        1.Document:A HTML Document.
         */
        Document doc = null;
        try {
            int i = (int) (Math.random() * 1000); //做一个随机延时，防止网站屏蔽
            while (i != 0) {
                i--;
            }
            /*
            1.The core public access point to the jsoup functionality.【访问jsoup 功能的核心开放接口】
            2.connect(url) -> 连接到某个url上的方法
            3.data():Add a request data parameter
            4.cookie():Set a cookie to be sent in the request
            5.post():Execute the request as a POST, and parse the result.
            */
            doc = Jsoup.connect(url).data("query", "Java")
                    .userAgent("Mozilla").cookie("auth", "token")
                    .timeout(300000).post();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                doc = Jsoup.connect(url).timeout(5000000).get();
            } catch (IOException e1) { // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        return doc;
    }
 
    //get html by local url,if local url not exists ,get url through network and save in local
    public Document getHtmlTextByPath(String name, String url) {
        String path = "D:/" + name + ".htm"; //the local url's path
        Document doc = null;
        File input = new File(path);
        try {
            /*
            1.(optional) character set of file contents. Set to null to determine from http-equiv meta tag,
            if present, or fall back to UTF-8 (which is often safe to do).
             */
            doc = Jsoup.parse(input,"gb2312");//gb2312是后面url指定网站使用的一个CHARSET【这个值需要根据需要进行设置】
            if (!doc.children().isEmpty()) {
                //doc = null;
                System.out.println("已经存在");
            }
        } catch (IOException e) {
            System.out.println("文件未找到，正在从网络获取.......");
            doc = this.getHtmlTextByUrl(url);
            //并且保存到本地
            this.saveHtml(url,name);
        }
        return doc;
    }
 
    //将网页保存在本地（通过url,和保存的名字）
    public void saveHtml(String url,String name) {
        try {
            name = name + ".htm";//set file's name
            // System.out.print(name);
            File dest = new File("D:/" + name);//D:\
            //接收字节输入流
            InputStream is;
            //字节输出流
            FileOutputStream fos = new FileOutputStream(dest);
            URL temp = new URL(url);
            is = temp.openStream();
            //为字节输入流加缓冲
            BufferedInputStream bis = new BufferedInputStream(is);
            //为字节输出流加缓冲
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int length;
            byte[] bytes = new byte[1024 * 20];
            while ((length = bis.read(bytes, 0, bytes.length)) != -1) {
                fos.write(bytes, 0, length);
            }
            bos.close();
            fos.close();
            bis.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //根据元素属性获取某个元素内的elements列表
    public Elements getEleByClass(Document doc,String className)
    {
        Elements elements= null;
        elements = doc.select(className);//这里把我们获取到的html文本doc，和工具class名，注意<tr class="provincetr">
        return elements;   //此处返回的就是所有的tr集合
    }
    //获取省 、市 、县等的信息
    public ArrayList getProvince(String name,String url ,String type)
    {
        ArrayList result= new ArrayList();
        String classType = "h2." +type;
        //"tr.provincetr"  => 要获取标签为<tr class="provincetr">的信息
        System.out.println("classType is :" + classType);
        //从网络上获取网页
        // Document doc = this.getHtmlTextByUrl(url);
        //从本地获取网页,如果没有则从网络获取
        Document doc2 = this.getHtmlTextByPath(name,url);
        System.out.println(name);
        if(doc2!=null){ //如果存在集合，则取出数据
            System.out.println("doc2!=null");
            Elements es =this.getEleByClass(doc2,classType);  //根据上述的classType得到tr的集合
            //System.out.println("es is :"+es.toString());
            for(Element e : es)   //依次循环每个元素，也就是一个tr
            {
                if(e!=null){
                	System.out.println(e);
                	for(Element ec:e.children()) {//爬取子元素，可以迭代使用这种方式深层遍历子元素
                		System.out.println(ec);//打印子元素（HTML元素）
                		System.out.println(ec.ownText());//打印子元素的文本值
                		System.out.println(ec.attr("abs:href"));//打印子元素的属性值
                	}
//                    //System.out.printf("element!=null"); //->for test
//                    for(Element ec : e.children())  //一个tr的子元素td，td内包含a标签
//                    {
//                        //身份的信息： 原来的url（当前url）  名称（北京） 现在url（也就是北京的url）  类型（prv）省
//                        String[] prv = new String[4];
//                        if(ec.children().first()!=null)
//                        {
//                            //原来的url
//                            prv[0]=url;  //就是参数url
//                            /* 获取城市名
//                            1.first()：Get the first matched element.
//                            2.ownText(): Gets the text owned by this element only; does not get the combined text of all children.
//                             */
//                            prv[1]=ec.children().first().ownText();  //a标签文本  如:北京
//                            System.out.println(prv[1]);
// 
//                            /* 获取子url地址x
//                            */
//                            prv[2]=ec.children().first().attr("abs:href");  //北京的url
//                            System.out.println(prv[2]);
//                            /*级别
//                            prv[3]=type; //就是刚刚传的类型，后面会有city 、county等
//                             */
//                            result.add(prv);//将所有身份加入list中
//                        }
//                    }
                }
            }
        }
        //返回所有的省份信息集合，存数据库，字段类型为： baseurl  name ownurl levelname（type） updatetime
        return result;
    }
    public static void main(String[] args) {
        Crawler html = new Crawler();
        //html.getHtmlTextByPath("2","http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2015/index.html");
        html.getProvince("blog6","http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8","title_blog_list");
    }
}
/**
 * 结果：classType is :h2.title_blog_list
文件未找到，正在从网络获取.......
blog6
doc2!=null
<h2 class="title_blog_list"><a href="#">计算机网络预习第十三周--应用层（最后一章）</a></h2>
<a href="#">计算机网络预习第十三周--应用层（最后一章）</a>
计算机网络预习第十三周--应用层（最后一章）
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">人机交互第11周--js之tab</a></h2>
<a href="#">人机交互第11周--js之tab</a>
人机交互第11周--js之tab
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">组网实践--有关路由器和交换机的配置</a></h2>
<a href="#">组网实践--有关路由器和交换机的配置</a>
组网实践--有关路由器和交换机的配置
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">计算机网络中期复习--概论、物理层、数据链路层、网络层</a></h2>
<a href="#">计算机网络中期复习--概论、物理层、数据链路层、网络层</a>
计算机网络中期复习--概论、物理层、数据链路层、网络层
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">组网实践第九周--路由器配置</a></h2>
<a href="#">组网实践第九周--路由器配置</a>
组网实践第九周--路由器配置
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">HTML5第九周学习</a></h2>
<a href="#">HTML5第九周学习</a>
HTML5第九周学习
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">计算机网络第九周预习--路由器结构、IPv6、IP多播、虚拟专用网和网络地址转换</a></h2>
<a href="#">计算机网络第九周预习--路由器结构、IPv6、IP多播、虚拟专用网和网络地址转换</a>
计算机网络第九周预习--路由器结构、IPv6、IP多播、虚拟专用网和网络地址转换
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">人机交互第八周总结</a></h2>
<a href="#">人机交互第八周总结</a>
人机交互第八周总结
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">HTML5第八周总结</a></h2>
<a href="#">HTML5第八周总结</a>
HTML5第八周总结
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">人机交互第八周--响应式布局和视口</a></h2>
<a href="#">人机交互第八周--响应式布局和视口</a>
人机交互第八周--响应式布局和视口
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">前端React框架</a></h2>
<a href="#">前端React框架</a>
前端React框架
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">软件综合实训之软件详细设计说明书和数据库设计说明书</a></h2>
<a href="#">软件综合实训之软件详细设计说明书和数据库设计说明书</a>
软件综合实训之软件详细设计说明书和数据库设计说明书
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">计算机网络第八周预习--网际控制报文协议和路由选择协议</a></h2>
<a href="#">计算机网络第八周预习--网际控制报文协议和路由选择协议</a>
计算机网络第八周预习--网际控制报文协议和路由选择协议
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">HTML5作业</a></h2>
<a href="#">HTML5作业</a>
HTML5作业
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">计算机网络预习第七周子网划分和构造超网</a></h2>
<a href="#">计算机网络预习第七周子网划分和构造超网</a>
计算机网络预习第七周子网划分和构造超网
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">人机交互第六周大整理</a></h2>
<a href="#">人机交互第六周大整理</a>
人机交互第六周大整理
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">HTML5预备知识JavaScript粗略系统学习</a></h2>
<a href="#">HTML5预备知识JavaScript粗略系统学习</a>
HTML5预备知识JavaScript粗略系统学习
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">软件设计说明书</a></h2>
<a href="#">软件设计说明书</a>
软件设计说明书
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">计算机网络预习第六周--网络层（服务、虚拟网络、IP协议）</a></h2>
<a href="#">计算机网络预习第六周--网络层（服务、虚拟网络、IP协议）</a>
计算机网络预习第六周--网络层（服务、虚拟网络、IP协议）
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">组网技术与实践第四周整理--共享局域网组网</a></h2>
<a href="#">组网技术与实践第四周整理--共享局域网组网</a>
组网技术与实践第四周整理--共享局域网组网
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">人机交互第四周整理--使用CSS美化图像</a></h2>
<a href="#">人机交互第四周整理--使用CSS美化图像</a>
人机交互第四周整理--使用CSS美化图像
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">人机交互第四周整理--使用CSS美化文本</a></h2>
<a href="#">人机交互第四周整理--使用CSS美化文本</a>
人机交互第四周整理--使用CSS美化文本
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">人机交互第四周整理--文本</a></h2>
<a href="#">人机交互第四周整理--文本</a>
人机交互第四周整理--文本
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">组网实践和技术第四周整理--计算机网络测试工具和命令</a></h2>
<a href="#">组网实践和技术第四周整理--计算机网络测试工具和命令</a>
组网实践和技术第四周整理--计算机网络测试工具和命令
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">HTML5第四周整理--nodejs</a></h2>
<a href="#">HTML5第四周整理--nodejs</a>
HTML5第四周整理--nodejs
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">组网配置第三周整理--交换器和综合布线</a></h2>
<a href="#">组网配置第三周整理--交换器和综合布线</a>
组网配置第三周整理--交换器和综合布线
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">大数据技术整理第三周--大数据带来的变革</a></h2>
<a href="#">大数据技术整理第三周--大数据带来的变革</a>
大数据技术整理第三周--大数据带来的变革
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">计算机网络第三周整理--数据链路层三大基本问题和点对点协议</a></h2>
<a href="#">计算机网络第三周整理--数据链路层三大基本问题和点对点协议</a>
计算机网络第三周整理--数据链路层三大基本问题和点对点协议
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">大数据技术整理第二周--大数据相关技术</a></h2>
<a href="#">大数据技术整理第二周--大数据相关技术</a>
大数据技术整理第二周--大数据相关技术
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">组网实践预习第三周--网络测试工具、命令和共享局域网组网</a></h2>
<a href="#">组网实践预习第三周--网络测试工具、命令和共享局域网组网</a>
组网实践预习第三周--网络测试工具、命令和共享局域网组网
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">组网实践整理第二周--传输介质和组网工具和连接方法</a></h2>
<a href="#">组网实践整理第二周--传输介质和组网工具和连接方法</a>
组网实践整理第二周--传输介质和组网工具和连接方法
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">人机交互第二周</a></h2>
<a href="#">人机交互第二周</a>
人机交互第二周
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">计算机网络第二周--物理层</a></h2>
<a href="#">计算机网络第二周--物理层</a>
计算机网络第二周--物理层
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">人机交互第二周</a></h2>
<a href="#">人机交互第二周</a>
人机交互第二周
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">组网实践第一周</a></h2>
<a href="#">组网实践第一周</a>
组网实践第一周
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">计算机网络第一周</a></h2>
<a href="#">计算机网络第一周</a>
计算机网络第一周
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">人机交互第一周</a></h2>
<a href="#">人机交互第一周</a>
人机交互第一周
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">git笔记</a></h2>
<a href="#">git笔记</a>
git笔记
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">软件商务双语沟通</a></h2>
<a href="#">软件商务双语沟通</a>
软件商务双语沟通
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">大数据技术导论第一周</a></h2>
<a href="#">大数据技术导论第一周</a>
大数据技术导论第一周
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">计算机硬件理论（计算机组成原理、操作系统、计算机网络）学习笔记和练习</a></h2>
<a href="#">计算机硬件理论（计算机组成原理、操作系统、计算机网络）学习笔记和练习</a>
计算机硬件理论（计算机组成原理、操作系统、计算机网络）学习笔记和练习
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">软件测试学习笔记和练习</a></h2>
<a href="#">软件测试学习笔记和练习</a>
软件测试学习笔记和练习
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">数据库（sql2008、MySQL）学习笔记和练习</a></h2>
<a href="#">数据库（sql2008、MySQL）学习笔记和练习</a>
数据库（sql2008、MySQL）学习笔记和练习
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">需求分析和建模学习笔记和练习</a></h2>
<a href="#">需求分析和建模学习笔记和练习</a>
需求分析和建模学习笔记和练习
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">编程语言（C语言、C++、Java）学习笔记和练习</a></h2>
<a href="#">编程语言（C语言、C++、Java）学习笔记和练习</a>
编程语言（C语言、C++、Java）学习笔记和练习
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">手机APP开发学习笔记和项目实例</a></h2>
<a href="#">手机APP开发学习笔记和项目实例</a>
手机APP开发学习笔记和项目实例
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">网站开发学习笔记和项目实例</a></h2>
<a href="#">网站开发学习笔记和项目实例</a>
网站开发学习笔记和项目实例
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#
<h2 class="title_blog_list"><a href="#">软件工程管理和毕业设计</a></h2>
<a href="#">软件工程管理和毕业设计</a>
软件工程管理和毕业设计
http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp?classId=8#

 * 
 */
