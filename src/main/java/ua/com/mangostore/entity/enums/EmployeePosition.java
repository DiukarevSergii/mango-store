package ua.com.mangostore.entity.enums;

public enum EmployeePosition {
    ADMIN,
    COURIER,
    MANAGER;

    EmployeePosition() {
    }

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}
