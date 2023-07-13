

public class Job {
    public static int UNFINISHED = 0;
    public static int FINISHED = 1;

    public Integer jobID;
    public Integer arrival;
    public Integer executionTime;
    public Integer executionProgress = 0;
    public int jobStatus = 0;

    public Job(Integer jobID, Integer arrival, Integer executionTime) {
        if (jobID == 0) {
            this.arrival = 0;
        } else {
            this.arrival = arrival;
        }

        this.executionTime = executionTime;
    }

    public void execute() {
        if (this.jobStatus != Job.FINISHED) {
            executionProgress++;
            if (executionProgress >= executionTime) {
                this.jobStatus = Job.FINISHED;
            }
        }
    }

    public int getStatus() {return this.jobStatus;}
}
