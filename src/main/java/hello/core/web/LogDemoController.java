package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerProvider; // provider 방식
    private final MyLogger myLogger;

//    생성자 의존성 주입
//    @Autowired
//    public LogDemoController(
//      LogDemoService logDemoService, ObjectProvider<MyLogger> myLoggerProvider, Mylogger mylogger) {
//        this.logDemoService = logDemoService;
//        this.myLoggerProvider = myLoggerProvider;
//        this.myLogger = mylogger;
//    }

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerProvider.getObject(); // provider 방식
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
