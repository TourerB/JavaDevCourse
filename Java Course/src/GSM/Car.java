package GSM;

public class Car {
    String code; //можно было сделать int
    int sign;
    int mileage;
    String param;

    public Car() {}

    public Car(String code, int sign, int mileage) {
        this.code = code;
        this.sign = sign;
        this.mileage = mileage;}

    public Car(String code) {
        // Тестовый конструктор
        this.code = code;
        }

    public Car(String code, int sign, int mileage, String param) {
        this.code = code;
        this.sign = sign;
        this.mileage = mileage;
        this.param = param;}

        @Override
    public String toString() {
        return this.code + ", " + this.sign + ", "+ this.mileage + ", " + this.param;
    }
}
