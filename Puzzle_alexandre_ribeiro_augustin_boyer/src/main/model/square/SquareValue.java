package main.model.square;

public enum SquareValue {
	ZERO("0"), ONE("1"), EMPTY(" ");

	private String value;

	SquareValue(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return this.value;
	}

	private void setValue(String value) {
		this.value = value;
	}
}
