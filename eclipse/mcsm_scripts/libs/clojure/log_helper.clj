(ns libs.clojure.log-helper)

(defn log
  [script to-print]
  (println (str "[MCSM-SCRIPT " script "]: " to-print)))