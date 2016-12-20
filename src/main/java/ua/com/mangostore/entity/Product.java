package ua.com.mangostore.entity;

import ua.com.mangostore.entity.enums.OnMain;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает сущность "Товар".
 * Аннотация @Entity говорит о том что объекты этого класса будет обрабатываться Hibernate.
 * Аннотация @Table(name = "Products") указывает на таблицу "Products", в которой будут храниться объекты.
 *
 * @author Diukarev Sergii
 */
@Entity
@Table(name = "Products")
public class Product {

    /**
     * Уникальный код обьекта.
     * Аннотация @Id говорит о том что поле является ключем для текущего объекта,
     * Аннотация @GeneratedValue говорит о том что значение генерируется автоматически.
     * Значение поля сохраняется в колонке "PRODUCT_ID".
     */
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private long productId;

    /**
     * Наименование товара. Значение поля сохраняется в колонке "PRODUCT_TITLE". Не может быть null.
     */
    @Column(nullable = false, name = "PRODUCT_TITLE")
    private String productTitle;

    /**
     * Тип товара.
     * Не может быть null.
     */
    @Column(nullable = false, name = "TYPE")
    private String type;

    /**
     * Бренд
     * Не может быть null.
     */
    @Column(nullable = false, name = "BRAND")
    private String brand;

    /**
     * Полная стоимость за одну штуку
     * Не может быть null.
     */
    @Column(nullable = false, name = "FULL_PRICE")
    private double fullPrice;

    /**
     * Цена со скидкой
     */
    @Column(name = "SALE_PRICE")
    private double salePrice;

    /**
     * Описание товара
     */
    @Column(name = "DESCRIPTION", length = 20000)
    private String description;


    /**
     * Характеристики товара
     */
    @Column(name = "SPECIFICATION", length = 5000)
    private String specification;

    /**
     * Ссылка на изображение товара
     */
    @Column(name = "IMAGE_URL")
    private String imageURL;

    /**
     * Функция отображения на главной
     */
    @Column(name = "ON_MAIN")
    @Enumerated(EnumType.STRING)
    private OnMain onMain;

    /**
     * Количество
     */
    @Column(name = "QUANTITY")
    private int quantity;

    /**
     * Торговые позиции.
     * К текущему товару можно добраться через поле "product"
     * в объекте класса {@link SalePosition}.
     * Выборка объекта salePosition при первом доступе к нему.
     * Сущность salePosition автоматически удаляется при удалении текущей.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
    private List<SalePosition> salePositions = new ArrayList<>();

    /**
     * Объект {@link DecimalFormat} для  форматирования десятичных чисел.
     */
    public static DecimalFormat df = new DecimalFormat();

    {
        df.setGroupingUsed(true);
        df.setGroupingSize(3);

        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setZeroDigit('0');
        decimalFormatSymbols.setGroupingSeparator(' ');

        df.setDecimalFormatSymbols(decimalFormatSymbols);
    }

    /**
     * Конструктор без параметров
     */
    public Product() {
    }

    /**
     * Конструктр с параметрами.
     *
     * @param productTitle Наименование
     * @param type Тип
     * @param brand Бренд
     * @param fullPrice Полная стомость
     * @param salePrice Цена со скидкой
     */
    public Product(String productTitle, String type, String brand, double fullPrice, double salePrice) {
        this.productTitle = productTitle;
        this.type = type;
        this.brand = brand;
        this.fullPrice = fullPrice;
        this.salePrice = salePrice;
        this.onMain = OnMain.NOT_ON_MAIN;
    }

    /**
     * Возвращает количество
     *
     * @return Значение типа {@link int} - количество.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Устанавливает количество.
     *
     * @param quantity количество.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Возвращает показатель отображения на главной
     *
     * @return Значение типа {@link OnMain}
     */
    public OnMain getOnMain() {
        return onMain;
    }

    /**
     * Устанавливает показатель отображения на главной
     *
     * @param onMain показатель отображения на главной
     */
    public void setOnMain(OnMain onMain) {
        this.onMain = onMain;
    }

    /**
     * Возвращает наименование товара
     *
     * @return Значение типа {@link String} - наименование товара.
     */
    public String getProductTitle() {
        return productTitle;
    }

    /**
     * Устанавливает наименование товара
     *
     * @param productTitle  наименование товара
     */
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    /**
     * Возвращает тип товара
     *
     * @return Значение типа {@link String} - тип товара.
     */
    public String getType() {
        return type;
    }

    /**
     * Устанавливает тип товара
     *
     * @param type тип товара
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Возвращает бренд товара
     *
     * @return Значение типа {@link String} - бренд товара.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Устанавливает бренд товара
     *
     * @param brand бренд товара
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    /**
     * Возвращает полную стоимость товара
     *
     * @return Значение типа {@link String} -  полную стоимость товара.
     */
    public double getFullPrice() {
        return fullPrice;
    }

    /**
     * Возвращает полную стоимость товара в форматированном виде
     *
     * @return Значение типа {@link String} - полная стоимость товара.
     */
    public String getFormatFullPrice() {
        return df.format(getFullPrice());
    }

    /**
     * Возвращает стоимость товара со скидкой в форматированном виде
     *
     * @return Значение типа {@link String} - стоимость товара со скидкой.
     */
    public String getFormatSalePrice() {
        return df.format(getSalePrice());
    }

    /**
     * Устанавливает полную стоимость товара
     *
     * @param fullPrice полную стоимость товара
     */
    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }


    /**
     * Возвращает стоимость товара со скидкой
     *
     * @return Значение типа {@link double} - стоимость товара со скидкой.
     */
    public double getSalePrice() {
        return salePrice;
    }

    /**
     * Устанавливает стоимость товара со скидкой
     *
     * @param salePrice стоимость товара со скидкой
     */
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * Возвращает характеристики товара
     *
     * @return Значение типа {@link String} - характеристики товара.
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * Возвращает описание товара
     *
     * @return Значение типа {@link String} - описание товара.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Устанавливает описание товара
     *
     * @param description описание товара
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Возвращает ссылку на изображение товара
     *
     * @return Значение типа {@link String} - ссылка на изображение товара.
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Устанавливает ссылку на изображение товара
     *
     * @param imageURL ссылка на изображение товара
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Устанавливает характеристики товара
     *
     * @param specification характеристики товара
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * Устанавливает характеристики товара
     *
     * @param os операционная система
     * @param processor процессор
     * @param displaySize размер дисплея
     * @param displayResolution разрешение дисплея
     * @param deviceSize размеры устройства
     * @param weight вес устройства
     * @param mainCamera главная камера
     * @param frontCamera фронтальная камера
     */
    public void setSpecification(
            String os, String processor, String displaySize, String displayResolution,
            String deviceSize, String weight, String mainCamera, String frontCamera) {

        this.setSpecification(
                String.format("<p><b>Операционная система:</b> %s </p>" +
                                "<p><b>Процессор:</b> %s </p>" +
                                "<p><b>Дисплей:</b> %s дюймов" +
                                "<br><b>Разрешение:</b> %s пикселей</p>" +
                                "<p><b>Размеры (В х Ш х Г):</b> %s </p>" +
                                "<p><b>Вес:</b> %s </p>" +
                                "<p><b>Основная камера:</b> %s </p>" +
                                "<p><b>Фронтальная камера:</b> %s </p>",
                        os, processor, displaySize, displayResolution, deviceSize,
                        weight, mainCamera, frontCamera));
    }

    /**
     * Устанавливает характеристики товара
     *
     * @param os операционная система
     * @param mainProcessor основной процессор
     * @param graphicProcessor графический процессор
     * @param displaySize размер дисплея
     * @param displayResolution разрешение дисплея
     * @param deviceSize размеры устройства
     * @param weight вес устройства
     * @param ddrMemeory количество оперативной памяти
     * @param cumulativeMemory количество накопительной памяти
     * @param audio аудио
     */
    public void setSpecification(
            String os, String mainProcessor, String graphicProcessor,
            String displaySize, String displayResolution,
            String deviceSize, String weight,
            String ddrMemeory, String cumulativeMemory, String audio) {

        this.setSpecification(
                String.format("<p><b>Операционная система:</b> %s </p>" +
                                "<p><b>Основной процессор:</b> %s </p>" +
                                "<p><b>Графический процессор::</b> %s </p>" +
                                "<p><b>Дисплей:</b> %s дюймов" +
                                "<br><b>Разрешение:</b> %s пикселей</p>" +
                                "<p><b>Размеры (В х Ш х Г):</b> %s &nbsp;&nbsp;" +
                                "<b>Вес:</b> %s </p>" +
                                "<p><b>Оперативная память:</b> %s</p>" +
                                "<p><b>Накопительная память:</b> %s</p>" +
                                "<p><b>Аудио:</b> %s </p>",
                        os,
                        mainProcessor, graphicProcessor,
                        displaySize, displayResolution,
                        deviceSize, weight,
                        ddrMemeory, cumulativeMemory,
                        audio));
    }

    /**
     * Возвращает список торговых позиций, для которых пренадлежит текущий товара.
     *
     * @return Объект класса {@link SalePosition} - торговая позиция.
     */
    public List<SalePosition> getSalePositions() {
        return salePositions;
    }

    /**
     * Устанавливает список торговых позиций, для которых пренадлежит текущий товара.
     *
     * @param salePositions Торговая позиция.
     */
    public void setSalePositions(List<SalePosition> salePositions) {
        this.salePositions = salePositions;
    }

    /**
     * Сравнение товаров
     * Переопределенный метод родительского класса {@link Object}.
     *
     * @return Значение типа {@link boolean}.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.fullPrice, fullPrice) != 0) return false;
        if (Double.compare(product.salePrice, salePrice) != 0) return false;
        if (!productTitle.equals(product.productTitle)) return false;
        if (type != null ? !type.equals(product.type) : product.type != null) return false;
        return brand != null ? brand.equals(product.brand) : product.brand == null;

    }

    /**
     * HashCode товара
     * Переопределенный метод родительского класса {@link Object}.
     *
     * @return Значение типа {@link int}.
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productTitle.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        temp = Double.doubleToLongBits(fullPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(salePrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


    /**
     * Возвращает полное описание товара.
     * Переопределенный метод родительского класса {@link Object}.
     *
     * @return Значение типа {@link String} - полное описание товара (наименование, тип, бренд, поная стоимость,
     * цена со скидкой, описание, характеристики, ссыдка на изображение, пометка на главной, количество, список  ).
     */
    @Override
    public String toString() {
        return "Product{" +
                "productTitle='" + productTitle + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", fullPrice=" + fullPrice +
                ", salePrice=" + salePrice +
                ", description='" + description + '\'' +
                ", specification='" + specification + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", onMain=" + onMain +
                ", quantity=" + quantity +
                ", salePositions=" + salePositions +
                '}';
    }
}