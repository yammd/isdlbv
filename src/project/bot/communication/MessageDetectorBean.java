/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.bot.communication;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 *
 * @author mad
 */
public class MessageDetectorBean {
    //private Vector NewsListeners;
    private ArrayList<Object> msgListeners;

    protected PropertyChangeSupport gestprop = new PropertyChangeSupport(this);

    /** Creates a new instance of IndicDetectorBean */
    public MessageDetectorBean()
    {
        this.msgListeners = new ArrayList<Object>();
    }

    public void notifyMessageDetected()
    {
        MessageEvent msgevt = new MessageEvent(this);
        for(int i=0; i< this.msgListeners.size();i++)
        {
            MessageListener ml = (MessageListener) this.msgListeners.get(i);
            ml.MessageDetected(msgevt);
        }

        System.out.println("A message has been detected on the medium");
    }

    public void addMessageListener(MessageListener al)
    {
       if(!msgListeners.contains(al))
           msgListeners.add(al);
    }

    public void addPropertyChangeListener(PropertyChangeListener l)
    {
        gestprop.addPropertyChangeListener(l);
    }

    public void removeMessageListener(MessageListener al)
    {
        if(msgListeners.contains(al))
            msgListeners.remove(al);
    }

    public void removePropertyChangeListener(PropertyChangeListener l)
    {
        gestprop.removePropertyChangeListener(l);
    }
}
