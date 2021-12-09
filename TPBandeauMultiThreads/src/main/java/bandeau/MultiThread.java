/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandeau;

import java.util.List;

/**
 *
 * @author lgarriga
 */
public class MultiThread extends Thread {

    private List<ScenarioElement> myElements;

    public MultiThread(Bandeau b, List<ScenarioElement> myElements) {
        this.myElements = myElements;
        this.b = b;
    }
    private Bandeau b;

    public void run() {
        synchronized (b) {
            for (ScenarioElement element : myElements) {
                for (int repeats = 0; repeats < element.repeats; repeats++) {
                    element.effect.playOn(b);
                }
            }
        }
    }

}
