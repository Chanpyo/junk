package rand;

import java.util.*;

/**
 * @author Chanpyo Hong
 */
public class RandomSelector {
    public static void main(String[] args) {
        RandomSelector randomSelector = new RandomSelector();
        randomSelector.select(
                2020000, 3,
                2015059,
                2015064,
                2016105,
                2016130,
                2016193,
                2017034,
                2017036,
                2017072,
                2017155,
                2017183,
                2018041,
                2018050,
                2018087,
                2018111,
                2018115,
                2018307
        );
    }

    private void select(int baseEmpno, int ticket, int... empnos) {
        Set<Emp> candidates = new HashSet<>();
        for (int empno : empnos) {
            candidates.add(new Emp(empno));
        }

        Set<Emp> chosen = new HashSet<>();
        final Random random = new Random(baseEmpno);

        if (candidates.size() <= ticket) {
            chosen = candidates;
        } else {
            while (chosen.size() < ticket) {
                List<Emp> base = new ArrayList<>();
                for (Emp candidate : candidates) {
                    if (!chosen.contains(candidate)) {
                        int weight = (baseEmpno - candidate.getEmpno()) / 100;
                        for (int i = 0; i < weight; i++) {
                            base.add(candidate);
                        }
                    }
                }

                chosen.add(base.get(random.nextInt(base.size())));
            }
        }

        for (Emp emp : chosen) {
            System.out.println(emp);
        }
    }
}
