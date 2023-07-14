package classes;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class JobTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Job ID", "Arrival", "Burst", "Progress", "Job Status"};
    private ArrayList<Job> jobList = new ArrayList<Job>();

    public JobTableModel(ArrayList<Job> jobList) {
        this.jobList = jobList;
    }

    public void setJobList(ArrayList<Job> jobList) {
        this.jobList = jobList;
    }

    @Override
    public int getRowCount() {
        return jobList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Job job = jobList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return job.jobID;
            case 1:
                return job.arrival;
            case 2:
                return job.executionTime;
            case 3:
                return job.executionProgress;
            case 4:
                return job.jobStatus;
            default:
                throw new IllegalArgumentException("Invalid column index");
        }
    }
}
