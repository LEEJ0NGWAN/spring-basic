package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;
//    private final ObjectProvider<MyLogger> myLoggerProvider; // provider 방식

//    @Autowired
//    public LogDemoService(ObjectProvider<MyLogger> myLoggerProvider) {
//        this.myLoggerProvider = myLoggerProvider;
//    }

    public void logic(String id) {
//        myLoggerProvider.getObject().log("service id = "+id); // provider 방식
        myLogger.log("service id = "+id);
    }

}
