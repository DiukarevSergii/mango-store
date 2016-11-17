package ua.com.mangostore.entity.enums;

/**
 * Перечесление вожможных статусов выполнения заказа.
 */
public enum Status {
    NEW,
    WORK,
    DELIVERY,
    CLOSED,
    DELETED;

    @Override
    public String toString() {
        switch (this.name()) {
            case ("NEW"): {
                return "Новый";
            }
            case ("WORK"): {
                return "В работе";
            }
            case ("DELIVERY"): {
                return "Идет доставка";
            }
            case ("CLOSED"): {
                return "Закрыт";
            }
            case ("DELETED"): {
                return "Удален";
            }
        }
        return "ОШИБКА";
    }
}

