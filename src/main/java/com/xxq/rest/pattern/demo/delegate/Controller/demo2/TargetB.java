package com.xxq.rest.pattern.demo.delegate.Controller.demo2;

/**
 * @author xiaoqiang
 * @Title: TargetB
 * @ProjectName delegate-pattern-demo
 * @Description: TODO
 * @date 2018-12-10 21:52
 */
public class TargetB  implements  ITarget{

    public void doing(String command) {
        System.out.println("我是B员工，我在做 " + command);
    }
}
