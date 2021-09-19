package com.heqin.mergedbeandefinition.spring3x;

import java.util.Properties;

/**
 * @Author heqin
 * @Date 2021/9/13 16:24
 */
public class ComplexObject {

    private Properties adminEmails;

    public Properties getAdminEmails() {
        return adminEmails;
    }

    public void setAdminEmails(Properties adminEmails) {
        this.adminEmails = adminEmails;
    }

    @Override
    public String toString() {
        return "ComplexObject{" +
                "adminEmails=" + adminEmails +
                '}';
    }
}
