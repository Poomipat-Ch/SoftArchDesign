package edu.parinya.softarchdesign.structural;

public abstract class HealthcareWorkerDecorator extends HealthcareWorker {
    protected HealthcareServiceable worker;

    public HealthcareWorkerDecorator(HealthcareServiceable worker) {
        super((HealthcareWorker) worker);
        this.worker = worker;
        System.out.print("Decorate " + this.getName());
    }

    @Override
    public void service() {
        this.worker.service();
    }

    @Override
    public double getPrice() {
        return this.worker.getPrice();
    }
}
