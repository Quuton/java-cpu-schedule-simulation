package classes;
public class CPU {
    public static final int IDLE = 0;
    public static final int BUSY = 1;

    public Job currentJob = null;
    public int currentState = CPU.IDLE;
    
    public void removeJob() {
        this.currentJob = null;
        this.currentState = CPU.IDLE;
    }

    public void setJob(Job job) {
        this.currentState = CPU.BUSY;
        if (job == null) {
            this.currentState = CPU.IDLE;
        }
        this.currentJob = job;
    }

    public Job getJob() {
        return this.currentJob;
    }

    public void processCurrentJob() {
        if (this.getJob() != null) {
            this.currentState = CPU.BUSY;
            this.currentJob.execute();
        }
    } 
    
    public int getState() {
        return this.currentState;
    }
}
