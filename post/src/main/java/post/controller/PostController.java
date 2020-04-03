package post.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import post.tool.OkHttpPost;

import java.io.IOException;

@RestController
public class PostController {

    @GetMapping("/")
    public String getDomain() throws IOException {
        String url = "http://receive:8080/receive";
        String s = OkHttpPost.getMethod(url);
        return "打开该应用的运维监控页面,然后刷新一次该页面,查看运维处组件连线间流量效果";
    }

    @GetMapping("/hostname")
    public String getHostname() {
        return System.getenv("HOSTNAME");
    }
}
