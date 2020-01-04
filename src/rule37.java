import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class rule37 {

    public static void main(String[] args) {
        Plant[] garden = null;
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for(Plant.LifeCycle lc: Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());
        for(Plant p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        System.out.println(plantsByLifeCycle);

        // streamway
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle)));
    }
}
class Plant{
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL};

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle){
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }
}