package edu.parinya.softarchdesign.structural;

import java.util.Date;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator {


    public TimeLoggingHealthcareWorker(HealthcareServiceable worker){
        super(worker);
        System.out.println(" with TimeLogging.");
    }

    @Override
    public void service() {
        Date timeLogging = new Date();
        System.out.print(timeLogging.toString() + ": ");
        super.service();
    }
}
