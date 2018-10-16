/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfreerdpaplication.config;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author Fede G
 */
public class Config {
    private String ip;
    private String port;
    public Config(){
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    
    public String SaveProperties(){
        Properties prop = new Properties();
        try{
            prop.setProperty("ip", this.getIp());
            prop.setProperty("port", this.getPort());
            prop.store(new FileOutputStream("/home/federico/.freerdplogin/config.properties"), null);
            return "Properties saved";
        }
        catch(IOException e){
            e.printStackTrace();
            return "There was a problem saving the file";
        }
    }
    
    public void LoadProperties(){
        Properties prop = new Properties();
        try{
            prop.load(this.getClass().getClassLoader().getResourceAsStream("/home/federico/.freerdplogin/config.properties"));
            this.setIp(prop.getProperty("ip"));
            this.setPort(prop.getProperty("port"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
