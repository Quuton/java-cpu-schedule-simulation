import java.util.ArrayList;

public class Scheduler {
    public ArrayList<Job> jobPool = new ArrayList<Job>();

    public ArrayList<Job> getPendingJobs() {
        ArrayList<Job> pending = new ArrayList<Job>();

        for (Job job : this.jobPool) {
            if (job.getStatus() == Job.UNFINISHED) {
                pending.add(job);
            }
        }
        return pending;
    }

    public void addJob(Job job) {
        this.jobPool.add(job);
    }

    public Job getShortestJob() throws Exception{
        if (this.jobPool.size() == 0) {
            throw new Exception();
        } else if (this.jobPool.size() == 1) {
            return this.jobPool.get(0);
        } else {

            Job minimum = this.jobPool.get(0);
            for (Job job : this.jobPool) {
                if (minimum.getRemainingTime() > job.getRemainingTime()) {
                    minimum = job;
                }
            }
            return minimum;
        }



    }



}
