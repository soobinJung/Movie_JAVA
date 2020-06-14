package Movie_reservation;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
	
	// ���� = 0 final�� ����
    public static final Money ZERO = Money.wons(0);

    // �Ѿ�
    private final BigDecimal amount;

    
    // �Ѿ� ��ȯ long
    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }
    // �Ѿ� ��ȯ double
    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    // Money ������
    Money(BigDecimal amount) {
        this.amount = amount;
    }

    // amount�� ���� �����ִ�.
    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    // amount�� ���� ���ִ�.
    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    // �����ִ�.
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
    
    // Object ����
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

    // Hash code ������ ��ü�� �����ϰ� ������ ã�´�.
    public int hashCode() {
        return Objects.hashCode(amount);
    }

    // toString
    public String toString() {
        return amount.toString() + "��";
    }
}
