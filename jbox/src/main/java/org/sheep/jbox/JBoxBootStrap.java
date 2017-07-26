package org.sheep.jbox;

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
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(HelloServlet.class, "/hello");
        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[]{context, new DefaultHandler()});
        server.setHandler(handlers);
        server.start();
        server.join();
    }

    public class HelloServlet extends HttpServlet {
        String greeting = "哇哈哈";

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
}
