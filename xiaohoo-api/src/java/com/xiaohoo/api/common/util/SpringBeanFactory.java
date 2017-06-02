package com.xiaohoo.api.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringBeanFactory {
    private static final BizLogger LOGGER = BizLogger.getLogger(SpringBeanFactory.class);

    /**
     * avoid new factory
     */
    public SpringBeanFactory() {
    }

    private static ApplicationContext appContext;

    /**
     * Build application context
     * 
     * @return
     */
    public static synchronized ApplicationContext getContext() {
        if (appContext == null) {
            try {
                String[] configLocations = { "/config/spring/biz_root.xml" };
                appContext = new ClassPathXmlApplicationContext(configLocations);
            } catch (Exception e) {
                LOGGER.error("Error occurred while getting application context.", e);
            }
        }
        return appContext;
    }

    /**
     * Get bean by bean name
     * 
     * @param beanName
     *            String
     * @return Object
     * @throws Exception
     */
    public static Object getBean(String beanName) {
        try {
            return getContext().getBean(beanName);
        } catch (Exception e) {
            LOGGER.error("Exception to get bean object", e);
            return null;
        }
    }

    public static void setAppContext(ApplicationContext appContext) {
        SpringBeanFactory.appContext = appContext;
    }
}
