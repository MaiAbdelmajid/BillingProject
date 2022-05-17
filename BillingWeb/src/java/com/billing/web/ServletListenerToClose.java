/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billing.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author LENOVO
 */
public class ServletListenerToClose implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("the app is deployed");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("the app is undeployed");

        try {
         CustomerDAO.closecon();
        } catch (Exception e) {
            System.out.println(e + " : error to start connection");
        }

    }
}
