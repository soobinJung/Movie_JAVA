package Movie_reservation;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
	
	// 제로 = 0 final로 선언
    public static final Money ZERO = Money.wons(0);

    // 총액
    private final BigDecimal amount;

    
    // 총액 반환 long
    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }
    // 총액 반환 double
    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    // Money 생성자
    Money(BigDecimal amount) {
        this.amount = amount;
    }

    // amount에 값을 더해주다.
    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    // amount에 값을 빼주다.
    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    // 곱해주다.
    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }
 
    // amount > 0
    public boolean isLessThan(Money other) {
        return amount.compareTo(other.amount) < 0;
    }
    
    // amount < 0
    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }
    
    // Object 같냐
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Money)) {
            return false;
        }

        Money other = (Money)object;
        return Objects.equals(amount.doubleValue(), other.amount.doubleValue());
    }

    // Hash code 값으로 객체를 저장하고 빠르게 찾는다.
    public int hashCode() {
        return Objects.hashCode(amount);
    }

    // toString
    public String toString() {
        return amount.toString() + "원";
    }
}
