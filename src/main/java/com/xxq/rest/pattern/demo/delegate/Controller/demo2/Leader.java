package com.xxq.rest.pattern.demo.delegate.Controller.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoqiang
 * @Title: Leader
 * @ProjectName delegate-pattern-demo
 * @Description: TODO
 * @date 2018-12-10 21:51
 */
public class Leader implements  ITarget{
    private Map<String, ITarget> targets = new HashMap<String, ITarget>();

    public Leader() {
        targets.put("加密", new TargetA());
        targets.put("开发", new TargetB());
    }

    /**
     * 不干活
      * @param command
     */
    public void doing(String command) {
        targets.get(command).doing(command);
    }
}
