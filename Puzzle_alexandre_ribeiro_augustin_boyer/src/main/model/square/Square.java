package main.model.square;

import main.model.Observed;

public class Square extends Observed {

	private String value;
	private boolean modifiable;

	public Square(String value, boolean modifiable) {
		this.setValue(value);
		this.setModifiable(modifiable);
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private Boolean getModifiable() {
		return this.modifiable;
	}

	private void setModifiable(boolean modifiable) {
		this.modifiable = modifiable;
	}

	public void changeValue() {
		int i = 0;
		String[] tab = { SquareValue.EMPTY.getValue(), SquareValue.ZERO.getValue(), SquareValue.ONE.getValue() };
		if (this.getModifiable()) {
			for (String b : tab) {
				if (b.equals(this.getValue())) {
					this.changeValue(b, i, tab);
					break;
				}
				i++;
			}
		}
	}

	private void changeValue(String b, int i, String[] tab) {
		if (i >= tab.length - 1) {
			this.setValue(tab[0]);
		} else {
			this.setValue(tab[i + 1]);
		}
	}
}
