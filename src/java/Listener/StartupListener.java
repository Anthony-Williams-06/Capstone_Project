/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listener;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author antho
 */
public class StartupListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Move files logic
	String windowsUserHome = System.getProperty("user.home");
	String diskDir = windowsUserHome + File.separator + "EnvisionImages";
        String targetFolder = sce.getServletContext().getRealPath("/images");

        File sourceDir = new File(diskDir);
        File targetDir = new File(targetFolder);

        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }

        for (File file : sourceDir.listFiles()) {
            if (file.isFile() && file.getName().matches(".*\\.(jpg|jpeg|png|gif|bmp)$")) {
                try {
                    Files.move(file.toPath(),Path.of(targetFolder, file.getName()), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Moved: " + file.getName());
                } catch (Exception e) {
                    System.err.println("Error moving file: " + file.getName());
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application shutting down...");
    }

}
