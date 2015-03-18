(println (str "TESTSCRIPT-CLJ: " (-> (ClassLoader/getSystemResource *file*) clojure.java.io/file .getParent)))
