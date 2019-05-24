package bqtrung.demospring.obj;

import bqtrung.demospring.model.User;

/**
 * Class description goes here.
 *
 * @version 23 May 2019
 * @author Trung Bui
 */
public class CommonConvention extends User {
	/* A class implementation comment can go here. */

	/** classVar1 documentation comment */
	public static int classVar1;

	/***
	 * classVar2 documentation comment that happens to be more than one line long
	 */
	private static Object classVar2;

	/** instanceVar1 documentation comment */
	public Object instanceVar1;

	/** instanceVar2 documentation comment */
	protected int instanceVar2;

	/** instanceVar3 documentation comment */
	private Object[] instanceVar3;

	/**
	 * ...constructor CommonConvention documentation comment...
	 */
	public CommonConvention() {
		// ...implementation goes here...
	}

	/**
	 * ...method doSomething documentation comment...
	 */
	public void doSomething() {
		// ...implementation goes here...
	}

	/**
	 * ...method doSomethingElse documentation comment...
	 * 
	 * @param someParam description
	 */
	public void doSomethingElse(Object someParam) {
		// ...implementation goes here...
	}
}
