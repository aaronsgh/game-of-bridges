(defproject game-of-bridges "0.1.0-SNAPSHOT"
  :description "Bridges, the logic puzzle game"
  :url "https://github.com/aaronsgh/game-of-bridges"
  :license {:name "GNU General Public License"
            :url "http://www.gnu.org/copyleft/gpl.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [quil "2.0.0"]]
  :main ^:skip-aot game-of-bridges.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})