/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.util;

/**
 *
 * @author mike
 */
public class ConfigurationUtil {
    
    private static String configPath = "";
    
    public static String getConfigPath() {
        return configPath;
    }

    public static void setConfigPath(String configPath) {
        ConfigurationUtil.configPath = configPath;
    }
    
}
