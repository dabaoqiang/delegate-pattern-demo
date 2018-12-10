package com.xxq.rest.pattern.demo.delegate.Controller.demo2;

/**
 * @author xiaoqiang
 * @Title: Boss
 * @ProjectName delegate-pattern-demo
 * @Description: 委派模式 就是静态代理和策略模式一种特殊的组合；
 * 客户请求（Boss），委派者（Leader），被做委派者（Target）；
 * 委派者要持有被委派者的引用；
 * 代理模式：注重的是过程；
 * 委派模式：注重的结果；
 * 策略模式：注重的是可扩展（外部扩展），委派模式内部的灵活和复用；
 * @date 2018-12-10 21:52
 */
public class Boss {

    public static void main(String[] args) {
        new Leader().doing("开发");
    }
}
