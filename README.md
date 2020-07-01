# AllAdapt

AllAdapt was created for people who don't want to waste time. This library can manage LWJGL (OpenGL) and Swing. It adds different Swing components like textured buttons or bars of textured or colored progressions. You can create a window with only one line.

Swing example:

1. JFrameManager.createJFrame (String nameJFrame, String title, int width, int height, Component classPane, boolean resizable)

2. JFrameManager.createJFrame (String nameJFrame, String title, int width, int height, Component classPane)

3. JFrameManager.createJFrame (String nameJFrame, String title, int width, int height, boolean resizable)

4. JFrameManager.createJFrame (String nameJFrame, String title, int width, int height)

Be careful not to place a null anywhere. The library does not yet manage this type of exception.


LWJGL example:

1. OpenGLFrameManager.createOpenGLFrame (int width, int height, String title)

2. OpenGLFrameManager.createOpenGLFrame (int width, int height, String title, boolean resizable, int x, int y)

3. OpenGLFrameManager.createOpenGLFrame (int width, int height, String title, boolean resizable, int x, int y, boolean implementsLoop)

Also be careful not to place a null for these methods.


ResourcePath example:

SwingAdapt.setSystemLookAndFeel ();
SwingAdapt.setResourcePath ("path");

// Others

SwingAdapt.getResourcePath ("image");

JButtonTextured example:

JButtonTextured button = new JButtonTextured (SwingAdapt.getResourcePath ("button");

JColoredBar example:

JColoredBar progressBarTextured = new JColoredBar (SwingAdapt.getTransparentWhite (100), SwingAdapt.getTransparentInstance (Color.GREEN, 50));


Warning, some elements of this library have been made in other libraries. Mainly by the creator Litarvan in his library "Swinger". https://github.com/Litarvan/Swinger
