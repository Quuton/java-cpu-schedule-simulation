package ui;
import javax.swing.*;
import java.awt.*;

public class CPUStatus extends JPanel {
    JLabel currentJobHeader = new JLabel("Current Job ID", JLabel.CENTER);
    JLabel currentTimeHeader = new JLabel("Current Time Point", JLabel.CENTER);
    JLabel currentStatusHeader = new JLabel("CPU Status", JLabel.CENTER);
    JLabel currentJobLabel = new JLabel("None", JLabel.CENTER);
    JLabel currentTimeLabel = new JLabel("0", JLabel.CENTER);
    JLabel currentStatusLabel = new JLabel("Idle", JLabel.CENTER);

    public CPUStatus() {
        this.setLayout(new GridLayout(2, 3, 20, 20));
        this.add(currentJobHeader);
        this.add(currentTimeHeader);
        this.add(currentStatusHeader);
        this.add(currentJobLabel);
        this.add(currentTimeLabel);
        this.add(currentStatusLabel);

    }

    public void updateJob(Integer jobID) {
        currentJobLabel.setText(Integer.toString(jobID));
    }

    public void updateJob() {
        currentJobLabel.setText("No Job ID");
    }

    public void updateTime(Integer time) {
        currentTimeLabel.setText(Integer.toString(time));
    }

    public void updateStatus(int status) {
        switch (status) {
            case 0:
                currentStatusLabel.setText("Idle");
                break;
            case 1:
                currentStatusLabel.setText("Busy");
                break;
            default:
                currentStatusLabel.setText("Undefined");
                break;


        }

    }
}