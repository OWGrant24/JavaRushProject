package JavaRush.Java_Collections.Collections2.RMI.task3212.service.impl;

import JavaRush.Java_Collections.Collections2.RMI.task3212.service.Service;

public class JMSServiceImpl implements Service {

    @Override
    public void execute() {
        System.out.println("Executing the JMSService");
    }

    @Override
    public String getName() {
        return "JMSService";
    }

}

