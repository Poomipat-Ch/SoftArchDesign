package edu.parinya.softarchdesign.structural;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable{
    private final Set<HealthcareServiceable> members = new LinkedHashSet<>();

//    public void addMember(HealthcareServiceable worker){
//        this.members.add(worker);
//    }

    public void addMember(HealthcareServiceable... worker){
        this.members.addAll(List.of(worker));
    }

    public void removeMember(HealthcareServiceable worker) {
        this.members.remove(worker);
    }

    @Override
    public void service() {
        for (HealthcareServiceable worker : this.members){
            worker.service();
        }
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (HealthcareServiceable worker : this.members){
            price += worker.getPrice();
        }
        return price;
    }


}
