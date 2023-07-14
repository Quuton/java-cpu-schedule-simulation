import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import classes.Job;
import classes.Scheduler;
import java.util.ArrayList;
import javax.swing.*;
import com.formdev.flatlaf.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import ui.CPUStatus;
import ui.JobStatus;
import ui.SimulationController;
public class Main extends JFrame {
    public long speed = 0;
    public int preset = 0;
    JobStatus jobStatus = new JobStatus(new ArrayList<Job>());
    Scheduler scheduler = new Scheduler();
    SimulationController simulationController = new SimulationController();
    CPUStatus cpuStatus = new CPUStatus();

    public static void main(String[] args) {
        try {
            FlatDarkLaf.setup();
        } catch (Exception e){}

        Main main = new Main();
        while (true) {
            main.update();

            try {
                TimeUnit.MILLISECONDS.sleep(1250 - main.speed);
            } catch (Exception e) {
                return;
            }
        } 
    }

    public void update() {
        this.scheduler.stepTime();
        this.scheduler.printStatus();
        this.jobStatus.setJobList(this.scheduler.getJobPool());

        if (this.scheduler.cpu.getJob() != null){
            this.cpuStatus.updateJob(this.scheduler.cpu.getJob().getJobId());
        } else {
            this.cpuStatus.updateJob();
        }
        this.cpuStatus.updateStatus(this.scheduler.cpu.getState());
        this.cpuStatus.updateTime(this.scheduler.currentTime);
        // this.validate();
        // this.repaint();
        // this.update();
    }

    public void generateJobs(int preset) {
        this.scheduler.jobPool = new ArrayList<Job>();
        this.scheduler.cpu.removeJob();
        this.scheduler.currentTime = 0;
        switch (preset) {
            case 0:{
                for (int i = 0; i < 5; i++) {
                    scheduler.addJob(new Job(i, i + 1, 1 + (int) (i * 1.6)));
                }
                break;
            }
            case 1: {
                for (int i = 0; i < 5; i++) {
                    scheduler.addJob(new Job(i, i + 1, 10 - i));
                }
                break;

            }
            default:
                for (int i = 0; i < 5; i++) {
                    scheduler.addJob(new Job(i, i + 1, 1 + (int) (i * 1.6)));
                }
                break;

        }
    }
    
    public void updateSpeed(long delay) {
        this.speed = delay;
    }

    public Main() {
        // public class sliderListener implements ChangeListener {
        // @Override
        //     public void stateChanged(ChangeEvent event) {
        //         updateSpeed((long) ((JSlider) event.getSource()).getValue());
        //     }
        // }

        this.simulationController.bindResetButtonListener((ActionEvent e) -> {
            generateJobs(preset);
        });

        this.simulationController.bindSliderChangeListener((ChangeEvent e) -> {
            JSlider source = (JSlider) e.getSource();
            int value = source.getValue();
            // Do something with the new value
            updateSpeed(value);
        });

        this.simulationController.bindSpinnerChangeListener((ChangeEvent e) -> {
            JSpinner source = (JSpinner) e.getSource();
            int value = (int) source.getValue();
            // Do something with the new value
            this.preset = value;
        });


        generateJobs(this.preset);
        this.add(jobStatus, BorderLayout.NORTH);
        this.add(cpuStatus, BorderLayout.EAST);
        this.add(simulationController, BorderLayout.WEST);
        this.setDefaultCloseOperation(3);
        this.pack();
        this.setVisible(true);
    }

}