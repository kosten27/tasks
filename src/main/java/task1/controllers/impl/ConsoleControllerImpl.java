package task1.controllers.impl;

import task1.controllers.ViewController;

public class ConsoleControllerImpl implements ViewController {
    public void show(String s) {
        System.out.println(s);
    }
}
