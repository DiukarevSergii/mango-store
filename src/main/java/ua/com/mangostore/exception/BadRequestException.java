package ua.com.mangostore.exception;

/**
 * Исключение генерируется, если данные не найдены в базе данных.
 */
public class BadRequestException extends RuntimeException {
    /**
     * Конструктр без параметров.
     */
    public BadRequestException() {
        super();
    }

    /**
     * Конструктор с параметром.
     *
     * @param message Сообщение исключения.
     */
    public BadRequestException(String message) {
        super(message);
    }
}
