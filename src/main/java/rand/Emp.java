package rand;

import java.util.Objects;

/**
 * @author Chanpyo Hong
 */
public class Emp {
    private final int empno;

    public Emp(int empno) {
        if (empno > 9999999 || empno < 1997000) {
            throw new IllegalArgumentException();
        }
        this.empno = empno;
    }

    public int getEmpno() {
        return empno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return empno == emp.empno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empno);
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                '}';
    }
}
