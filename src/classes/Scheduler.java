package classes;
import java.util.ArrayList;

public class Scheduler {
    public ArrayList<Job> jobPool = new ArrayList<Job>();
    public CPU cpu = new CPU();
    public int currentTime = 0;

    public ArrayList<Job> getPendingJobs() {
        ArrayList<Job> pending = new ArrayList<Job>();

        for (Job job : this.jobPool) {
            if (job.getStatus() == Job.UNFINISHED && job.getArrivalTime() <= this.currentTime) {
                pending.add(job);
            }
        }
        return pending;
    }

    public void addJob(Job job) {
        this.jobPool.add(job);
    }

    public Job getShortestJob() { 
        ArrayList<Job> pending = getPendingJobs();

        if (pending.size() == 0) {
            return null;
        } else if (pending.size() == 1) {
            return pending.get(0);
        } else {
            Job minimum = pending.get(0);
            for (Job job : pending) {
                if (minimum.getRemainingTime() > job.getRemainingTime()) {
                    minimum = job;
                }
            }
            return minimum;
        }
    }

    public void stepTime() {
        
        if (this.cpu.getJob() == null) {
            this.cpu.setJob(getShortestJob());
        } else if (this.cpu.getJob().getRemainingTime() > getShortestJob().getRemainingTime()) {
            this.cpu.setJob(getShortestJob());
        }

        this.cpu.processCurrentJob();

        if (this.cpu.getJob() != null) {
            if (this.cpu.getJob().getStatus() == Job.FINISHED) {
                this.cpu.removeJob();
                this.cpu.setJob(getShortestJob());
            }
        }
    
        this.currentTime++;
    }

    public void printStatus() {
        System.out.format("Current Time: %d \n", this.currentTime);
        System.out.format("CPU Status: %d \n", this.cpu.getState());
        if (this.cpu.getJob() == null) {
            System.out.format("CPU JobID: None \n");
        } else {
            System.out.format("CPU JobID: %d \n", this.cpu.getJob().getJobId());
        }
        for (Job job : jobPool) {
            System.out.format("JOB ID #%d \n", job.getJobId());
            System.out.format("JOB Status %d \n", job.getStatus());
            System.out.format("JOB Remaining Time %d \n", job.getRemainingTime());
        }

    }

    public ArrayList<Job> getJobPool() {
        return this.jobPool;
    }

}
