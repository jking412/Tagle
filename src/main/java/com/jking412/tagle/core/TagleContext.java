package com.jking412.tagle.core;

import com.jking412.tagle.common.TagleExcel;
import com.jking412.tagle.controller.main.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class TagleContext implements TagleController {

    @Autowired
    private TagleExcel tagleExcel;

    @Autowired
    private MainController mainController;

    public static String defaultBanner = " _________  ________  ________  ___       _______      \n" +
            "|\\___   ___\\\\   __  \\|\\   ____\\|\\  \\     |\\  ___ \\     \n" +
            "\\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\___|\\ \\  \\    \\ \\   __/|    \n" +
            "     \\ \\  \\ \\ \\   __  \\ \\  \\  __\\ \\  \\    \\ \\  \\_|/__  \n" +
            "      \\ \\  \\ \\ \\  \\ \\  \\ \\  \\|\\  \\ \\  \\____\\ \\  \\_|\\ \\ \n" +
            "       \\ \\__\\ \\ \\__\\ \\__\\ \\_______\\ \\_______\\ \\_______\\\n" +
            "        \\|__|  \\|__|\\|__|\\|_______|\\|_______|\\|_______|\n";

    public void run() {
        File file = new File(tagleExcel.getExcelName());
        if (!file.exists()) {
            tagleExcel.createExcel();
        }
        tagleExcel.readExcel();
        System.out.println("欢迎来到Tagle");
        outPutBanner();
        toChildController(null);
    }


    @Override
    public void toChildController(String choice) {
        mainController.run();
        finish();
    }

    private void finish() {
        System.out.println("感谢对Tagle的使用，bye!");
        tagleExcel.createExcel();
    }

    private void outPutBanner() {
        File file = new File("banner.txt");
        if (!file.exists()) {
            System.out.println(defaultBanner);
            return;
        }
        OutputStream outputStream = new PrintStream(System.out);
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            for (int i = 0; i < len; i++) {
                outputStream.write(bytes[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
