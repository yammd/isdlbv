/*
 * robot.java
 */

package project;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import project.misc.ArrayList2d;

/**
 * The main class of the application.
 */
public class robot extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new robotView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of robot
     */
    public static robot getApplication() {
        return Application.getInstance(robot.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        //launch(robot.class, args);
        ArrayList2d array2d = new ArrayList2d<Integer>();
        //array2d.add(10, 5);
        //array2d.set(10, 10, 100);
        //array2d.add(10,0);
        //array2d.add(15,1);
        //array2d.add(20, 2);
        //array2d.set(0, 10, new Integer(100));
        array2d.add(100,1,1);
        array2d.print();
    }
}
