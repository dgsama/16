
public class Temperatura {

	/**
	 * El valor representado por este objeto temperatura, en grados Celsius.
	 * Internamente, la temperatura se almacena tanto en grados Celsius como en
	 * Fahrenheit, y ambos valores se actualizan sólo cuando es necesario (en
	 * este caso, cuando se recibe una llamada a {@code asCelsius} y el valor de
	 * este atributo estaba sin sincronizar (el valor representado por este
	 * objeto se había modificado a través de una o varias llamadas a
	 * {@code setFahrenheit}.
	 */
	private double celsius;

	/**
	 * El valor representado por este objeto temperatura, en grados Fahrenheit.
	 * Internamente, la temperatura se almacena tanto en grados Celsius como en
	 * Fahrenheit, y ambos valores se actualizan sólo cuando es necesario (en
	 * este caso, cuando se recibe una llamada a {@code asFahrenheit} y el valor
	 * de este atributo estaba sin sincronizar (el valor representado por este
	 * objeto se había modificado a través de una o varias llamadas a
	 * {@code setCelsius}.
	 */
	private double fahrenheit;

	/**
	 * Representa si el valor del atributo {@code celsius} está o no
	 * actualizado.
	 */
	private boolean celsiusOk;

	/**
	 * Representa si el valor del atributo {@code fahrenheit} está o no
	 * actualizado.
	 */
	private boolean fahrenheitOk;

	public Temperatura() {
		setCelsius(0);
	}

	public void setCelsius(double value) {
		this.celsius = value;
		celsiusOk = true;
		fahrenheitOk = false;
	}

	public void setFahrenheit(double value) {
		this.fahrenheit = value;
		fahrenheitOk = true;
		celsiusOk = false;
	}

	public double asCelsius() {
		if (!celsiusOk)
			celsius = (fahrenheit - 32) * 5 / 9;
		return celsius;
	}

	public double asFahrenheit() {
		if (!fahrenheitOk)
			fahrenheit = celsius * 9 / 5 + 32;
		return fahrenheit;
	}

	@Override
	public String toString() {
		return String.format("%.1f ºC", celsius);
	}

}
