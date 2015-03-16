package mods.mcscript.utility;

import clojure.lang.RT;
import clojure.lang.Symbol;
import clojure.lang.Var;

//Utility class for executing clojure code
public class Clojure {
	public static final Var REQUIRE=var("clojure.core", "require");
	public static final Var META=var("clojure.core", "meta");
	public static final Var EVAL=var("clojure.core", "eval");
	public static final Var READ_STRING=var("clojure.core", "read-string");

	/**
	 * Require a namespace by name, loading it if necessary.
	 *
	 * Calls clojure.core/require
	 *
	 * @param nsName
	 * @return
	 */
	public static Object require(String nsName) {
		return REQUIRE.invoke(Symbol.intern(nsName));
	}

	public static Object readString(String s) {
		return READ_STRING.invoke(s);
	}

	/**
	 * Looks up a var by name in the clojure.core namespace.
	 *
	 * The var can subsequently be invoked if it is a function.
	 *
	 * @param varName
	 * @return
	 */
	public static Var var(String varName) {
		return var("clojure.core",varName);
	}

	/**
	 * Looks up a var by name in the given namespace.
	 *
	 * The var can subsequently be invoked if it is a function.
	 * @param nsName
	 * @param varName
	 * @return
	 */
	public static Var var(String nsName, String varName) {
		return RT.var(nsName,varName);
	}

	/**
	 * Evaluates a String, which should contain valid Clojure code.
	 *
	 * @param string
	 * @return
	 */
	public static Object eval(String string) {
		return EVAL.invoke(readString(string));
	}

}
