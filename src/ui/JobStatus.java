package ui;
import javax.swing.*;

import classes.JobTableModel;
import classes.Job;
import java.awt.*;
import java.util.ArrayList;


public class JobStatus extends JPanel {
    // JobTableModel tableModel;
    JTable table = new JTable();
    JScrollPane scrollPane;

    public JobStatus(ArrayList<Job> jobs){
        JobTableModel tableModel = new JobTableModel(jobs);
        this.table.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
        this.setVisible(true);
    }

    public void setJobList(ArrayList<Job> jobList) {
        JobTableModel tableModel = new JobTableModel(jobList);
        this.table.setModel(tableModel);
    }

}
