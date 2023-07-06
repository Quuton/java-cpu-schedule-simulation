package ui;
import javax.swing.*;
import java.awt.*;

public class CPUStatus extends JPanel {
    JLabel currentJobHeader = new JLabel("Current Job");
    JLabel currentTimeHeader = new JLabel("Current Time Point");
    JLabel currentStatusHeader = new JLabel("CPU Status");
    JLabel currentJobLabel = new JLabel("None");
    JLabel currentTimeLabel = new JLabel("0");
    JLabel currentStatusLabel = new JLabel("Idle");

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

    public void updateTime(Integer time) {
        currentTimeLabel.setText(Integer.toString(time));
    }

    public void updateStatus(int CPUStatus) {
        currentStatusLabel.setText(TOOL_TIP_TEXT_KEY);
    }
}