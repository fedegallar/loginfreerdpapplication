/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import java.io.IOException;

/**
 *
 * @author Fede G
 * f: Fullscreen
 * rfx: RemoteFX
 */
public class ProcessRDP {
    String user;
    String password;
    String ip;
    String port;

    /**
     * CreateProcessRDP class that launch FreeRDP.
     * @param user
     * @param password
     * @param ip
     * @param port
     */
    public ProcessRDP(String user, String password, String ip, String port){
        this.user = user;
        this.password = password;
        this.ip = ip;
        this.port = port;
    }

    /**
     * Launch FreeRDP with user, password, ip and port.
     */
    public void launchFreeRDP(){
        try{
            System.out.println(user + password + ip + port);
            Process p = Runtime.getRuntime().exec("xfreerdp /u:"+user+" /p:"+password+" /v:192.168.17.42 /p:3389 /f /rfx");
            p.waitFor();
        }
        catch(Exception e){
           e.printStackTrace();
        }
    }
}
