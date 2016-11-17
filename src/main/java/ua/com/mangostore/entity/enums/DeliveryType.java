package ua.com.mangostore.entity.enums;

public enum DeliveryType {
    PICKUP,
    COURIER,
    UNMANNED_AIRCRAFT;

    DeliveryType() {
    }

    @Override
    public String toString() {
        switch (this.name()) {
            case ("PICKUP"): {
                return "Самовывоз";
            }
            case ("COURIER"): {
                return "Доставка курьером";
            }
            case ("UNMANNED_AIRCRAFT"): {
                return "Доставка дроном";
            }
        }
        return "ОШИБКА";
    }
}
