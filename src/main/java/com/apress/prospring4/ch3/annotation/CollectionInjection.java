package com.apress.prospring4.ch3.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service("injectCollection")
public class CollectionInjection {

    @Resource(name = "map")
    private Map<String, Object> map;

    @Resource(name = "properties")
    private Properties props;

    @Resource(name = "set")
    private Set set;

    @Resource(name = "list")
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
        instance.displayInfo();
    }

    public void displayInfo() {
        System.out.println("\n Map contents: \n");
        for (Map.Entry<String, Object> entry: map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }
        System.out.println("\n Properties contents: \n");
        for (Map.Entry<Object, Object> entry: props.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }
        System.out.println("\n Set contents: \n");
        for (Object obj: set) {
            System.out.println("Value: " + obj);
        }
        System.out.println("\n List contents: \n");
        for (Object obj: list) {
            System.out.println("Value: " + obj);
        }
    }
}