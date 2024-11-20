package studio9;

import java.util.LinkedList;

public class Polynomial {
	
	private LinkedList<Double> list;

	/**
	 * Constructs a Polynomial with no terms yet.
	 */
	public Polynomial() {
		list = new LinkedList<Double>();
	}

	
	/**
	 * 
	 * @param coeff
	 * @return polynomial with added term
	 */
	public void addTerm(double coeff) {
		list.add(coeff);
	}
	
	/*
	 * Returns a String of the polynomial with the proper form:
	 * 
	 * Cx^N + Cx^N-1 + ... + Cx + C
	 */
	public String toString() {
		String polynomialValues = "";
		int power = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				polynomialValues = polynomialValues + list.get(i);
			} else {
				power = list.size() - 1 - i;
				polynomialValues = polynomialValues + list.get(i) + "x^" + power + "+";
			}
		}
		return polynomialValues;
	}
	
	/**
	 * 
	 * @param x
	 * @return value of polynomial at that x
	 */
	public double evaluate(double x) {
		double value = 0;
		for (int i = 0; i < list.size(); i++) {
			value = value + (list.get(i) * Math.pow(x, list.size() - 1 - i));
		}
		return value;
	}

	
	public Polynomial derivative() {
		int power = 0;
		double newCoeff = 0;
		Polynomial derivative = new Polynomial();
		for (int i = 0; i < list.size() - 1; i++) {
			power = list.size() - 1 - i;
			newCoeff = list.get(i) * power;
			derivative.addTerm(newCoeff);
		}
		return derivative;
	}
	

	/**
	 * This is the "equals" method that is called by
	 *    assertEquals(...) from your JUnit test code.
	 *    It must be prepared to compare this Polynomial
	 *    with any other kind of Object (obj).  Eclipse
	 *    automatically generated the code for this method,
	 *    after I told it to use the contained list as the basis
	 *    of equality testing.  I have annotated the code to show
	 *    what is going on.
	 */

	public boolean equals(Object obj) {
		// If the two objects are exactly the same object,
		//    we are required to return true.  The == operator
		//    tests whether they are exactly the same object.
		if (this == obj)
			return true;
		// "this" object cannot be null (or we would have
		//    experienced a null-pointer exception by now), but
		//    obj can be null.  We are required to say the two
		//    objects are not the same if obj is null.
		if (obj == null)
			return false;

		//  The two objects must be Polynomials (or better) to
		//     allow meaningful comparison.
		if (!(obj instanceof Polynomial))
			return false;

		// View the obj reference now as the Polynomial we know
		//   it to be.  This works even if obj is a BetterPolynomial.
		Polynomial other = (Polynomial) obj;

		//
		// If we get here, we have two Polynomial objects,
		//   this and other,
		//   and neither is null.  Eclipse generated code
		//   to make sure that the Polynomial's list references
		//   are non-null, but we can prove they are not null
		//   because the constructor sets them to some object.
		//   I cleaned up that code to make this read better.


		// A LinkedList object is programmed to compare itself
		//   against any other LinkedList object by checking
		//   that the elements in each list agree.

		return this.list.equals(other.list);
	}

}