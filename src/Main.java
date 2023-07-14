import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Main extends JFrame {
    public static void main(String[] args) {
       Scheduler scheduler = new Scheduler();
       for (int i = 0; i < 9; i++) {
        scheduler.addJob(new Job(i, i + 1, 1 + (int) (i * 1.3)));
       }
    //    Timer timer = new Timer(2000, new ActionListener(){
    //         @Override
    //         public void actionPerformed(ActionEvent actionEvent) {
    //             scheduler.stepTime();
    //             scheduler.printStatus();
    //         }
    //    });
    //    timer.start();
    while (true) {
        scheduler.stepTime();
        scheduler.printStatus();
        
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            return;
        }
    }

    }

}