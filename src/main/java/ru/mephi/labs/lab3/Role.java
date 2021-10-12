package ru.mephi.labs.lab3;

public enum Role {
    STAFF(0.1),
    MANAGER(0.2),
    EXECUTIVE(0.3);

    private final double interestRate;

    Role(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
    public static double byRole(Role role)
    {
        return switch(role){
            case STAFF -> STAFF.getInterestRate();
            case MANAGER -> MANAGER.getInterestRate();
            case EXECUTIVE -> EXECUTIVE.getInterestRate();
        };
    }
}
