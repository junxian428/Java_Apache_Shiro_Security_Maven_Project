package org.example;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = (SecurityManager) factory.getInstance();
        SecurityUtils.setSecurityManager((SecurityManager) securityManager);
        Subject subject = SecurityUtils.getSubject();
        // Create token
        AuthenticationToken token = new UsernamePasswordToken("zhangsan","z3");
        // Complete Login
        try{
            subject.login(token);
            System.out.println("Login Success");
            boolean hasRole = subject.hasRole("role1");
            System.out.println("Whether got: " + hasRole);

            // Determine the permission for operation
            boolean permitted = subject.isPermitted("user:insert");
            System.out.println("Check the permission " + permitted);
        }catch(UnknownAccountException e){
            System.out.println("Account wrong");
            e.printStackTrace();
        }catch(IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("Incorrect password");
        }
        catch (AuthenticationException e){
            e.printStackTrace();
        }


    }
}