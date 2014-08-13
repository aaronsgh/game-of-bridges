(ns game-of-bridges.solver
  (:require [game-of-bridges.logic :as l]
            [game-of-bridges.util :as util]))

(defn canonical-bridge [{:keys [fst snd num] :as bridge}]
  (if (util/str< snd fst) {:fst snd :snd fst :num num} bridge))

(defn add-potential-bridges [state island current-bridges]
  (map (partial l/add-bridge current-bridges island)
       (l/neighbors island (update-in state [:bridges]
                                      (partial util/union current-bridges)))))

(defn all-configurations [{:keys [islands bridges] :as state} island]
  (loop [n (l/num-occupied bridges island)
         configurations [(l/get-bridges bridges island)]]
    (if (= n (:num island))
      (->> configurations
           (map (partial map canonical-bridge))
           (map (partial sort util/strcmp))
           (set))
      (recur (inc n)
             (mapcat (partial add-potential-bridges state island)
                              configurations)))))