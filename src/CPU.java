public class CPU {
    public static final int IDLE = 0;
    public static final int BUSY = 1;

    public Job currentJob;
    public int currentState = CPU.IDLE;
    
    public Job removeJob() {
        Job temp = this.currentJob;
        this.currentJob = null;
        this.currentState = CPU.IDLE;
        return temp;
    }

    public void giveJob(Job job) {
        this.currentJob = job;
    }

    public int processCurrentJob() {
        this.currentState = CPU.BUSY;
        this.currentJob.execute();
        return this.currentJob.getStatus();
    } 
    
}
