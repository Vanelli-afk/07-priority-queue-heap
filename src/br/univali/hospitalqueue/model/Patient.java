package br.univali.hospitalqueue.model;

/**
 * Represents a hospital patient with clinical triage parameters.
 * Implements Comparable to establish priority routing based on Manchester triage rules.
 * * @author Miguel Vanelli
 * @version 1.0
 * @see Person
 */
public class Patient extends Person implements Comparable<Patient>{

    /** The clinical urgency level ranging from 1 to 5. */
    private int urgencyLevel;
    
    /** Cumulative waiting time spent by the patient in minutes. */
    private int waitTimeMinutes;
    
    /** Flag identifying whether the patient belongs to a legally vulnerable group. */
    private boolean vulnerableGroup;

    /**
     * Constructs a new Patient with triage attributes.
     *
     * @param name            the full name of the patient
     * @param urgencyLevel    the priority rating (1 to 5)
     * @param waitTimeMinutes the time spent waiting in minutes
     * @param vulnerableGroup true if pediatric or geriatric criteria are met
     */
    public Patient(String name,
                int urgencyLevel,
                int waitTimeMinutes,
                boolean vulnerableGroup) {
        super(name);
        setUrgencyLevel(urgencyLevel);
        setWaitTimeMinutes(waitTimeMinutes);
        setVulnerableGroup(vulnerableGroup);
    }
    
    /**
     * Gets the patient's triage urgency score.
     *
     * @return the clinical urgency index
     */
    public int getUrgencyLevel(){
        return urgencyLevel;
    }
    
    /**
     * Gets the total duration spent in the queue.
     *
     * @return waiting time in minutes
     */
    public int getWaitTimeMinutes(){
        return waitTimeMinutes;
    }
    
    /**
     * Checks if the patient belongs to a vulnerable group.
     *
     * @return true if vulnerable, false otherwise
     */
    public boolean getVulnerableGroup(){
        return vulnerableGroup;
    }
    
    /**
     * Updates the clinical urgency score.
     *
     * @param urgencyLevel the new urgency level
     */
    public void setUrgencyLevel(int urgencyLevel){
        this.urgencyLevel = urgencyLevel;
    }
    
    /**
     * Updates the tracked waiting time.
     *
     * @param waitTimeMinutes waiting duration in minutes
     */
    public void setWaitTimeMinutes(int waitTimeMinutes){
        this.waitTimeMinutes = waitTimeMinutes;
    }
    
    /**
     * Modifies the vulnerability classification flag.
     *
     * @param vulnerableGroup true if priority classification applies
     */
    public void setVulnerableGroup(boolean vulnerableGroup){
        this.vulnerableGroup = vulnerableGroup;
    }
    
    /**
     * Compares this patient with another to establish sorting weights.
     *
     * @param other the target patient instance to compare against
     * @return a negative integer, zero, or a positive integer
     */
    @Override
    public int compareTo(Patient other) {
        if (getUrgencyLevel() != other.getUrgencyLevel()) {
            return getUrgencyLevel() - other.getUrgencyLevel();
        }
        
        if (getWaitTimeMinutes() != other.getWaitTimeMinutes()) {
            return getWaitTimeMinutes() - other.getWaitTimeMinutes();
        }
        
        if (getVulnerableGroup() && !other.getVulnerableGroup()) {
            return 1;
        }
        
        if (!getVulnerableGroup() && other.getVulnerableGroup()) {
            return -1;
        }
        
        return 0;
    }

    /**
     * Generates a structured view of the patient metrics.
     *
     * @return a formatted single line with the patient metrics
     */
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