package com.abstractedsheep.Logger;

import com.abstractedsheep.config.STSProperties;

import java.io.IOException;
import java.util.logging.FileHandler;
/**
 * Created by IntelliJ IDEA.
 * User: ujonnalagadda
 * Date: 7/22/11
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Logger extends java.util.logging.Logger{
    protected Logger(String s, String s1) {
        super(s, s1);
    }

    public static Logger getConfiguredLogger(Class c) {
        Logger log = (Logger) getLogger(c.getCanonicalName());
        String path = STSProperties.LOG_PATH + "/sts.log";

        try {
            log.addHandler(new FileHandler(path));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return log;
    }
}
