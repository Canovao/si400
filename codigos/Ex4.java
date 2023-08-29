public class TemperaturaCelsius {
    private double temperaturaCelsius;

    public void definirCelsius(double temperatura) {
        temperaturaCelsius = temperatura;
    }

    public double obterFahrenheit() {
        return (temperaturaCelsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        TemperaturaCelsius temperatura = new TemperaturaCelsius();
        temperatura.definirCelsius(25.0);

        System.out.println("Temperatura em Celsius: " + temperatura.temperaturaCelsius);
        System.out.println("Temperatura em Fahrenheit: " + temperatura.obterFahrenheit());
    }
}
