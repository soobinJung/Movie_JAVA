package Movie_reservation;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
 