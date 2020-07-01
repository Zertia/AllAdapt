package net.devquip.swingAdapt.lwjgl.frames;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

public class FrameManager {

    static boolean running = false;
    static int FRAME_CAP = 60;

    public FrameManager() {
        start();
    }

    public static void createOpenGLFrame(int width, int height, String title) {
        try {
            Display.setTitle(title);
            Display.setDisplayMode(new org.lwjgl.opengl.DisplayMode(width, height));
            Display.create();
            initGL();
            while (!Display.isCloseRequested()) { // Line 26

                Display.update();
                Display.sync(60);
                render();
            }

            Display.destroy();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    public static void createOpenGLFrame(int width, int height, String title, boolean resizable, int x, int y) {
        try {
            Display.setTitle(title);
            Display.setDisplayMode(new org.lwjgl.opengl.DisplayMode(width, height));
            Display.setResizable(resizable);
            Display.setLocation(x, y);
            Display.create();
            initGL();
            while (!Display.isCloseRequested()) { // Line 26

                Display.update();
                Display.sync(60);
                render();
            }

            Display.destroy();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    public static void createOpenGLFrame(int width, int height, String title, boolean resizable, int x, int y, boolean implementsLoop) {
        try {
            Display.setTitle(title);
            Display.setDisplayMode(new org.lwjgl.opengl.DisplayMode(width, height));
            Display.setResizable(resizable);
            Display.setLocation(x, y);
            Display.create();
            initGL();
            while (!Display.isCloseRequested()) { // Line 26

                Display.update();
                Display.sync(60);
                render();
            }

            Display.destroy();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    public static void start() {
        running = true;
        loop();
    }

    public static void stop() {
        running = false;
    }

    public static void exit() {
        Display.destroy();
        System.exit(0);
    }

    public static void loop() {
        while (running) {
            if(Display.isCloseRequested()) stop();
            Display.update();
            System.out.println("Loop");
            render();
        }
        exit();
    }

    public static void initGL() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluOrtho2D(0, Display.getWidth(), Display.getHeight(), 0);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
    }

    public static void render() {
        glRectf(16,16, 32, 32);
    }
}