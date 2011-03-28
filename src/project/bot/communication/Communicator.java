/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.bot.communication;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import project.bot.*;
/**
 *
 * @author mad
 */
public class Communicator implements MessageListener, PropertyChangeListener {

    ArrayList<Bot> botList;

    public Communicator()
    {
        this.botList = new ArrayList<Bot>();
    }
    
    public void MessageDetected(MessageEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
