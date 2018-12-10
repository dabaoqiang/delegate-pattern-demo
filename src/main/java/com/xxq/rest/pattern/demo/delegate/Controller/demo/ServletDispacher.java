package com.xxq.rest.pattern.demo.delegate.Controller.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoqiang
 * @Title: ServletDispacher
 * @ProjectName delegate-pattern-demo
 * @Description: 项目经理
 * 之前每一个url对于一个urlMapping，
 * 先做讲这个urlMpaing转给ServletDispatcher处理
 * @date 2018-12-10 21:11
 */
public class ServletDispacher {


    private static List<Handler> handerMapping = new ArrayList<Handler>();

    public ServletDispacher(){
        try {
            Class<?> memberActionClass = MemberAction.class;
            handerMapping.add(
                    new Handler().
                            setController(memberActionClass.newInstance()).
                            setMethod(memberActionClass.getMethod("getMemberById", new Class[]{String.class})
           ).setUrl("/web/getMemberById.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void doService(HttpServletRequest request, HttpServletResponse response) {
        doDispatcher(request, response);

    }

    /**
     * 委派模式
     * @param request
     * @param response
     */
    private void doDispatcher(HttpServletRequest request, HttpServletResponse response) {
       //1.获取用户请求的URL；
       // 如果按照J2EE的标志，每个url对应一个servlet；
        String uri= request.getRequestURI();

        //2.Servlet拿到以后，要做权衡（要做判断，要做选择）/
        // 根据用户请求的URL，去找到这个URL对应的java类的的对应方法

        //3.通过拿到的URL去handlerMapping （我们把它认为是策略常量）
        Handler handler = null;
        Object controller = null;
        for (Handler h:handerMapping){
            if (uri.equals(h.getUrl())){
                handler = h;
                break;
            }
        }


        //4.将具体的任务分发给Method，（通过反射区调用其他对于的方法）
        Object object = null;
        try {
            object =  handler.getMethod().invoke(handler.getController(), request.getParameter("mid"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //5、获取到method执行的结果，通过response返回结果；
//        response.getWriter().write();

    }

    class Handler {

        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }

}
