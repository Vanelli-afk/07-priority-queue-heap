package br.univali.hospitalqueue.model;

public class Patient extends Person implements Comparable<Patient>{

    private int urgencyLevel;
    private int waitTimeMinutes;
    private boolean vulnerableGroup;

    public Patient(String name,
                int urgencyLevel,
                int waitTimeMinutes,
                boolean vulnerableGroup) {
        super(name);
        setUrgencyLevel(urgencyLevel);
        setWaitTimeMinutes(waitTimeMinutes);
        setVulnerableGroup(vulnerableGroup);
    }
    
    public int getUrgencyLevel(){
        return urgencyLevel;
    }
    
    public int getWaitTimeMinutes(){
        return waitTimeMinutes;
    }
    
    public boolean getVulnerableGroup(){
        return vulnerableGroup;
    }
    
    public void setUrgencyLevel(int urgencyLevel){
        this.urgencyLevel = urgencyLevel;
    }
    
    public void setWaitTimeMinutes(int waitTimeMinutes){
        this.waitTimeMinutes = waitTimeMinutes;
    }
    
    public void setVulnerableGroup(boolean vulnerableGroup){
        this.vulnerableGroup = vulnerableGroup;
    }
    
    @Override
    public int compareTo(Patient other) {
        // urgency
        if (getUrgencyLevel() != other.getUrgencyLevel()) {
            return getUrgencyLevel() - other.getUrgencyLevel();
        }
        
        // wait time
        if (getWaitTimeMinutes() != other.getWaitTimeMinutes()) {
            return getWaitTimeMinutes() - other.getWaitTimeMinutes();
        }
        
        // vulnerable
        if (getVulnerableGroup() && !other.getVulnerableGroup()) {
            return 1;
        }
        
        if (!getVulnerableGroup() && other.getVulnerableGroup()) {
            return -1;
        }
        
        return 0;
    }

    @Override
    public String toString() {
        return String.format(
            "%-20s | Urgency: %-2d | Wait: %3d min | Vulnerable: %-3s",
            super.getName(),
            urgencyLevel,
            waitTimeMinutes,
            vulnerableGroup ? "YES" : "NO"
        );
    }
}