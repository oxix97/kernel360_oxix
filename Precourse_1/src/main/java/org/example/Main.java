package org.example;

import org.example.controller.ResumeController;
import org.example.view.ResumeView;

public class Main {
    public static void main(String[] args) {
        new ResumeController(new ResumeView()).run();
    }
}