package com.nmfzone.app.config.gate;

import java.net.InetAddress;

import com.google.common.base.Strings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

@Component
public class Server implements EmbeddedServletContainerCustomizer
{

    @Value("${config.server.host}")
    protected String serverHost;

    @Value("${config.server.port}")
    protected String serverPort;

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container)
    {
        serverPort = Strings.isNullOrEmpty(serverPort) ? "0" : serverPort;
        try {
            container.setAddress(InetAddress.getByName(serverHost));
            container.setPort(Integer.parseInt(serverPort));
        } catch(Exception e) {
            System.out.println("Server configuration incorrect!");
            e.printStackTrace();
            System.exit(1);
        }
    }

}
