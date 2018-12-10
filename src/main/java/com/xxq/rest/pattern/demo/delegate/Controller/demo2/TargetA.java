package com.xxq.rest.pattern.demo.delegate.Controller.demo2;

/**
 * @author xiaoqiang
 * @Title: TargetA
 * @ProjectName delegate-pattern-demo
 * @Description: TODO
 * @date 2018-12-10 21:52
 */
public class TargetA implements  ITarget {

    public void doing(String command) {
        System.out.println("我是A员工，我在干" + command);
    }
}
