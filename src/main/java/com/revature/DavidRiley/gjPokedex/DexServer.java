package com.revature.DavidRiley.gjPokedex;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.startup.Tomcat;

public class DexServer {
        private Tomcat server;

        public DexServer(DexService dexService){
                // This is the Constructor.
                this.server = new Tomcat();
                this.server.setBaseDir("java.io.tmpdir");
                this.server.getConnector();
                this.server.addContext("", null);
                this.server.addServlet("", "dexServlet", dexService).addMapping("/");
                try {
                        this.server.start();
                } catch (LifecycleException e) {
                        e.printStackTrace();
                }
        }

}
