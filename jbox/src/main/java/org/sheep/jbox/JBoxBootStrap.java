package org.sheep.jbox;

import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.sheep.jbox.container.Container;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: YangJiong
 * @Date: 18:33 2017/7/25
 */
public class JBoxBootStrap {

    private static Container container;

    void init() {

    }

    private JBoxBootStrap() {
    }

    public static void start() {

    }

    public static void restart() {

    }

    public static void stop() {

    }


    public static void main(String[] args) throws Exception {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});
        ServletContextHandler jettyContext = new ServletContextHandler();
        jettyContext.setContextPath("/");
        jettyContext.addServlet(HelloServlet.class, "/hello");
        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[]{jettyContext, new DefaultHandler()});
        server.setHandler(handlers);
        server.start();
        server.join();

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.setBaseDir("e:/tmp/tomcat");
        tomcat.getHost().setAutoDeploy(false);
        StandardContext tomcatContext = new StandardContext();
        tomcatContext.setPath("/");
        tomcatContext.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.getHost().addChild(tomcatContext);
        tomcat.addServlet("/", "homeServlet", new HelloServlet());
        tomcatContext.addServletMappingDecoded("/home", "homeServlet");
        tomcat.start();
        tomcat.getServer().await();

    }


}

class HelloServlet extends HttpServlet {
    String greeting = "hello";

    public HelloServlet() {
    }

    public HelloServlet(String greeting) {
        this.greeting = greeting;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<h1>" + greeting + "</h1>");
        response.getWriter().write("session= " + request.getSession(true).getId());
    }

}
