

public class Job {
    public static int UNFINISHED = 0;
    public static int FINISHED = 1;

    public Integer jobID;
    public Integer arrival;
    public Integer executionTime;
    public Integer executionProgress = 0;
    public int jobStatus = 0;

    public Job(Integer jobID, Integer arrival, Integer executionTime) {
        this.jobID = jobID;
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
    
    public int getRemainingTime() {
        return executionTime - executionProgress;
    }
    public int getStatus() {return this.jobStatus;}

    public Job clone() {
        try {
            return (Job) super.clone();
        } catch (CloneNotSupportedException e) {
            // This exception will be thrown if the class does not implement Cloneable
            // or if a subclass overrides clone() method and does not call super.clone()
            // handle the exception as per your requirements
            return null;
        }
    }

    public int getJobId() {
        return this.jobID;
    }
}
