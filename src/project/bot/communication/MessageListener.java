/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.bot.communication;

import java.util.EventListener;

/**
 *
 * @author mad
 */
public interface MessageListener extends EventListener {

    public void MessageDetected(MessageEvent event);
}
