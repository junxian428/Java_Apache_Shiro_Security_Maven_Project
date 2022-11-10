package org.example;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthenticatingRealm {
    //doGetAuthenticationInfo(AuthenticationToken)
    //
    protected AuthenticationInfo     doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        // Step 1
        String principal = authenticationToken.getPrincipal().toString();
        // Step 2
        String password = new String((char[]) authenticationToken.getCredentials());
        System.out.println("User " + principal + " "+password );
        // Step 3
        if(principal.equals("zhangsan")){
            // Step 3.1
            String pwdInfo = "7174f64b13022acd3c56e2781e098a5f";
            AuthenticationInfo info = new SimpleAuthenticationInfo(
                    authenticationToken.getPrincipal(),
                    pwdInfo,
                    ByteSource.Util.bytes("salt"),
                    authenticationToken.getPrincipal().toString()
            );
            return info;

        }
        // Step 4
        return null;
    }
}
