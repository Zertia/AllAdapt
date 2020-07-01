package net.devquip.swingAdapt.main;

import net.devquip.swingAdapt.lwjgl.frames.FrameManager;
import net.devquip.swingAdapt.test.ClassPane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.WritableRaster;
import java.io.IOException;

public class SwingAdapt {

    public static final int LITTLE_TRANSPARENT = 50;

    public static final Color DISABLED_COLOR = getTransparentInstance(Color.GRAY, 50);

    public static final Color LITTLE_TRANSPARENT_WHITE = getTransparentWhite(50);

    public static final Color HOVER_COLOR = LITTLE_TRANSPARENT_WHITE;

    private static String resourcePath;

    static SwingAdapt instance;

    public SwingAdapt() {
        instance = this;
    }

    public static void main(String[] args) {
        /*
        * Tests
        */
        SwingAdapt.setSystemLookNFeel();
        SwingAdapt.setResourcePath("/net/devquip/swingAdapt/resources/");
    //    FrameManager.createJFrame("Frame", "Frame", 1000, 1000, new ClassPane(), false);
        FrameManager.createOpenGLFrame(500, 100, "Test", false, 0, 0, true);
    }

    public static SwingAdapt getInstance() {
        return instance;
    }

    public static void setSystemLookNFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            System.out.println("[Swinger] WARNING: Can't set the system look n feel : " + e);
        } catch (InstantiationException e) {
            System.out.println("[Swinger] WARNING: Can't set the system look n feel : " + e);
        } catch (IllegalAccessException e) {
            System.out.println("[Swinger] WARNING: Can't set the system look n feel : " + e);
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("[Swinger] WARNING: Can't set the system look n feel : " + e);
        }
    }

    public static BufferedImage copyImage(BufferedImage image) {
        ColorModel cm = image.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = image.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    public static Image fillImage(Image image, Color color, ImageObserver imageObserver) {
        Graphics g = image.getGraphics();
        g.setColor(color);
        g.fillRect(0, 0, image.getWidth(imageObserver), image.getHeight(imageObserver));
        return image;
    }

    public static Color getTransparentInstance(Color color, int transparency) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), transparency);
    }

    public static Color getTransparentWhite(int transparency) {
        return getTransparentInstance(Color.WHITE, transparency);
    }

    public static void activateAntialias(Graphics g) {
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }

    public static Point getRecCenterPos(Rectangle parent, Rectangle rectangle) {
        double x = parent.getWidth() / 2.0D - rectangle.getWidth() / 2.0D;
        double y = parent.getHeight() / 2.0D - rectangle.getHeight() / 2.0D;
        return new Point((int)x, (int)y);
    }

    public static void drawCenteredString(Graphics g, String str, Rectangle parent) {
        FontMetrics fm = g.getFontMetrics();
        Rectangle2D stringBounds = fm.getStringBounds(str, g);
        Point centerPos = getRecCenterPos(parent, stringBounds.getBounds());
        g.drawString(str, (int)centerPos.getX(), (int)centerPos.getY());
    }

    public static void drawFullsizedImage(Graphics g, JComponent component, Image image) {
        g.drawImage(image, 0, 0, component.getWidth(), component.getHeight(), component);
    }

    public static void setResourcePath(String resourcePath) {
        SwingAdapt.resourcePath = resourcePath.endsWith("/") ? resourcePath.substring(0, resourcePath.length() - 1) : resourcePath;
    }

    public static String getResourcePath() {
        return resourcePath;
    }

    public static int crossMult(int value, int maximum, int coefficient) {
        return (int)(value / maximum * coefficient);
    }

    public static BufferedImage getResource(String resource) {
        try {
            return ImageIO.read(SwingAdapt.class.getResourceAsStream(getResourcePath() + "/" + resource));
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't load the given resource (" + getResourcePath() + "/" + resource + ") : " + e);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Can't load the given resource (" + getResourcePath() + "/" + resource + ") : " + e);
        }
    }

    public static void fillFullsizedRect(Graphics g, JComponent component) {
        g.fillRect(0, 0, component.getWidth(), component.getHeight());
    }

    public static void fillFullsizedRect(Graphics g, JComponent component, Color color) {
        g.setColor(color);
        g.fillRect(0, 0, component.getWidth(), component.getHeight());
    }
}